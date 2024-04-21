package userDefinedLibraries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
 
public class LoggerClass {
	public Logger  log;
	public   LoggerClass(){
		log=LogManager.getLogger( this.getClass());
	}
}
