import java.lang.reflect.Method;

import play.Application;
import play.GlobalSettings;
import play.Logger;
import play.mvc.Action;
import play.mvc.Http.Request;

public class Global extends GlobalSettings {	
	/*
	 * (non-Javadoc)
	 * @see play.GlobalSettings#onRequest(play.mvc.Http.Request, java.lang.reflect.Method)
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public Action onRequest(Request request, Method method) {
		if(Logger.isTraceEnabled())Logger.trace("method=" + request.method() + " uri=" + request.uri() + " remote-address=" + request.remoteAddress());
		return super.onRequest(request, method);
	}

	/*
	 * (non-Javadoc)
	 * @see play.GlobalSettings#onStop(play.Application)
	 */
	@Override
	public void onStop(Application app) {
		if(Logger.isTraceEnabled())Logger.trace("Application has stopped");
	}

	/*
	 * (non-Javadoc)
	 * @see play.GlobalSettings#onStart(play.Application)
	 */
	@Override
	public void onStart(Application app) {
		if(Logger.isTraceEnabled())Logger.trace("Application has started");

		// Check if the database is empty
//		if (User.find.findRowCount() == 0) {
//			String dataset = "test-data.yml";
//			if(Logger.isDebugEnabled())Logger.debug("loading initial dataset from file <"+dataset+">");
//			Ebean.save((List<?>) Yaml.load(dataset));
//		}
	}
}