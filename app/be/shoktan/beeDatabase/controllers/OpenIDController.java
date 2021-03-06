package be.shoktan.beeDatabase.controllers;



import play.data.DynamicForm;
import play.data.Form;
import play.libs.F.Function;
import play.libs.F.Promise;
import play.libs.openid.OpenID;
import play.libs.openid.OpenID.UserInfo;
import play.mvc.Controller;
import play.mvc.Result;

public class OpenIDController extends Controller {

  public static Result login() {
    //return ok(login.render(""));
	  return ok("42");
  }

  public static Promise<Result> loginPost() {
    DynamicForm requestData = Form.form().bindFromRequest();
    String openID = requestData.get("openID");

    final Promise<String> redirectUrlPromise = OpenID.redirectURL(openID, routes.OpenIDController.openIDCallback().absoluteURL(request()));

    final Promise<Result> resultPromise = redirectUrlPromise.map(new Function<String, Result>() {
      @Override
      public Result apply(String url) {
        return redirect(url);
      }
    }).recover(new Function<Throwable, Result>() {
      @Override
      public Result apply(Throwable throwable) throws Throwable {
        //return badRequest(login.render(throwable.getMessage()));
    	  return badRequest("bad 42");
      }
    });

    return resultPromise;
  }

  public static Promise<Result> openIDCallback() {

    final Promise<UserInfo> userInfoPromise = OpenID.verifiedId();

    final Promise<Result> resultPromise = userInfoPromise.map(new Function<UserInfo, Result>() {
      @Override
      public Result apply(UserInfo userInfo) {
        return ok(userInfo.id + "\n" + userInfo.attributes);
      }
    }).recover(new Function<Throwable, Result>() {
      @Override
      public Result apply(Throwable throwable) throws Throwable {
        //return badRequest(views.html.login.render(throwable.getMessage()));
    	  return badRequest("bad 42");
      }
    });

    return resultPromise;
  }

}