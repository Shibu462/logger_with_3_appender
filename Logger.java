
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


public class Logger{
	enum LogLevel{
		DEBUG,INFO,ERROR
	}
	
	private static volatile Logger instance;
	private static LogLevel currentLevel = LogLevel.DEBUG;
	
	private List<LogAppender> appenders = new CopyOnWriteArrayList<>();
	
	private Logger(){}
	
	public static Logger getInstance(){
		if(instance==null){
			synchronized(Logger.class){
				if(instance==null){
					instance = new Logger();
				}
			}
		}
		return instance;
	}
	
	public void log(LogLevel level, String message){
		if(level.ordinal()>currentLevel.ordinal()){
			
			String time = LocalDateTime.now().toString();
			String formatted = "[" + level + "]" + time + " "+ message;
			
			for(LogAppender appender:appenders){
				appender.append(formatted);
			}
		}
	}
	
	public void addAppender(LogAppender appender){
		appenders.add(appender);
	}
	
	public static void main(String[] args){
		Logger logger = Logger.getInstance();
		
		logger.addAppender(new ConsoleAppender());
		logger.addAppender(new FileAppender("app.log"));
		logger.addAppender(new ServerAppender());
		
		logger.log(LogLevel.INFO,"App started");
		logger.log(LogLevel.INFO,"App Working");
		logger.log(LogLevel.INFO,"App paused");
		logger.log(LogLevel.INFO,"App restarted");
		logger.log(LogLevel.ERROR,"App down");
		
	}
	
}