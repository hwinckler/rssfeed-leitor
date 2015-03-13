package dbunit.dataset.load;

import java.io.FileInputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;

import rssfeedleitor.dao.factory.SqlSessionFactoryProvider;
import rssfeedleitor.dao.impl.CategoryDAOImpl;

public class DBUnitLoad {

	private static final Logger logger = LogManager.getLogger(DBUnitLoad.class);
	
	public static SqlSessionFactory sessionFactory = new SqlSessionFactoryProvider().produceFactory();
	
	private static DatabaseConnection databaseConnection;
	private static IDataSet idataSet;
	private static SqlSession session;
	
	public static void setUp(final String dataSet) throws Exception{
		
		logger.debug("setUp...");
		
		session = sessionFactory.openSession();
				
		databaseConnection = new DatabaseConnection(session.getConnection());
		
		idataSet = new FlatXmlDataSetBuilder().build(new FileInputStream(DBUnitLoad.class.getResource(dataSet).getFile()));

        DatabaseOperation.INSERT.execute(databaseConnection, idataSet);
        
	}
	
	public static void tearDown() throws Exception{
		
		logger.debug("tearDown...");
		
        DatabaseOperation.TRUNCATE_TABLE.execute(databaseConnection, idataSet);
        
        session.close();
 
        
	}
}
