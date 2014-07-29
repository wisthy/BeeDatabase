package be.shoktan.beeDatabase.controllers;

import play.mvc.Controller;
import play.mvc.Result;
import be.shoktan.beeDatabase.views.html.index;

public class Application extends Controller {

    public static Result index() {
        //return ok("Your new application is ready.");
    	return ok(index.render("Your new application is ready."));
    }

}
