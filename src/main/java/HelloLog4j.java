import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HelloLog4j {

	static Logger logger = LoggerFactory.getLogger(HelloLog4j.class);
	
	public static void main(String[] args) {
		
		logger.debug("Hello World!");

	}

}
