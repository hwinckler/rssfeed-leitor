package rssfeedleitor.dao.factory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SqlSessionFactoryProvider {

	private static final Logger logger = LoggerFactory.getLogger(SqlSessionFactoryProvider.class);

	private SqlSessionFactory sqlSessionFactory;

	@Produces
	@ApplicationScoped
	public SqlSessionFactory produceFactory() {
		try {

			logger.debug("obtendo arquivo de configuração do mybatis...");

			try (Reader reader = Resources.getResourceAsReader("mybatis-config.xml")) {

				if (sqlSessionFactory == null) {
					logger.debug("criando SqlSessionFactory...");

					sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
				}
			}

		}

		catch (FileNotFoundException e) {
			logger.error("error", e);
		} catch (IOException e) {
			logger.error("error", e);
		}
		
		return sqlSessionFactory;
	}

}
