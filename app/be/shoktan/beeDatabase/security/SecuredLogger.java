package be.shoktan.beeDatabase.security;


import play.Logger;
import play.Logger.ALogger;
import play.mvc.Http.Context;
import play.mvc.Http.Session;

public class SecuredLogger {
	private static final String SESSION_ID = "sessionId";
	private ALogger LOGGER;
	
	

	/**
	 * 
	 */
	private SecuredLogger(Class<?> clazz) {
		super();
		LOGGER = Logger.of(clazz);
	}



	public static SecuredLogger of(Class<?> clazz) {
		return new SecuredLogger(clazz);
	}
	
	public String commonLog(String message){
		Session session = Context.current().session();
		String sessionId = session.get(SESSION_ID);
		if(sessionId == null){
			// it's a new session
//			sessionId = ""+LongSequenceGenerator.getInstance().getNextSequenceId();
//			session.put(SESSION_ID, sessionId);
			sessionId = "0";
		}
		return sanitize("[Sess:"+sessionId+"]"+message);
	}
	
	public String sanitize(String message){
		return message;
	}



	/**
	 * @return
	 * @see play.Logger.ALogger#isDebugEnabled()
	 */
	public boolean isDebugEnabled() {
		return LOGGER.isDebugEnabled();
	}



	/**
	 * @return
	 * @see play.Logger.ALogger#isErrorEnabled()
	 */
	public boolean isErrorEnabled() {
		return LOGGER.isErrorEnabled();
	}



	/**
	 * @return
	 * @see play.Logger.ALogger#isInfoEnabled()
	 */
	public boolean isInfoEnabled() {
		return LOGGER.isInfoEnabled();
	}



	/**
	 * @return
	 * @see play.Logger.ALogger#isTraceEnabled()
	 */
	public boolean isTraceEnabled() {
		return LOGGER.isTraceEnabled();
	}



	/**
	 * @return
	 * @see play.Logger.ALogger#isWarnEnabled()
	 */
	public boolean isWarnEnabled() {
		return LOGGER.isWarnEnabled();
	}



	public void debug(String message) {
		LOGGER.debug(commonLog(message));
	}



	public void info(String message) {
		LOGGER.info(commonLog(message));
	}



	public void trace(String message) {
		LOGGER.trace(commonLog(message));
	}



	public void error(String message) {
		LOGGER.trace(commonLog(message));
	}
	
	
	
}
