package controllers;

import play.api.templates.Html;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class Fila extends Controller{

	public static Result lista() {
		models.Fila senha = new models.Fila("2");
		senha.save();
		
	return ok(views.html.fila.lista.render("tste", Html.apply(Json.toJson(senha).asText())));
	}
	
	public static Result index() {
		return ok();
	}
}
