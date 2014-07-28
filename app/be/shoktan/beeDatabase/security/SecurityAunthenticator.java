package be.shoktan.beeDatabase.security;


import play.mvc.Http.Context;
import play.mvc.Result;
import play.mvc.Security;
import controllers.routes;

public class SecurityAunthenticator extends Security.Authenticator {
	/*
	 * (non-Javadoc)
	 * @see play.mvc.Security.Authenticator#getUsername(play.mvc.Http.Context)
	 */
    @Override
    public String getUsername(Context ctx) {
        return ctx.session().get("login");
    }

    /*
     * (non-Javadoc)
     * @see play.mvc.Security.Authenticator#onUnauthorized(play.mvc.Http.Context)
     */
    @Override
    public Result onUnauthorized(Context ctx) {
    	return redirect(routes.Application.index());
    }
    
//    public boolean hasACL(ACL acl){
//    	return GrantedAccess.isACLGranted(Context.current().request().username(), acl);
//    }
}