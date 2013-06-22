package controllers;

import static play.data.Form.form;
import models.Usuario;
import play.data.Form;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Http.RequestBody;
import play.mvc.Result;

public class Login extends Controller {
    final static Form<Usuario> loginForm = form(Usuario.class);
    
	public static Result login() {
		return ok(views.html.login.form.render(loginForm));
	}
	
//	@BodyParser.Of(BodyParser.Json.class)
	public static Result execute() {
		RequestBody body = request().body();
		Usuario as = body.as(Usuario.class);
		Usuario byId = Usuario.find.byId(as.id);
		if (byId != null) {
			if (byId.senha.equalsIgnoreCase(as.senha)) {
				//TODO criar pagina apos o login. admin page
				return ok();
			}else {
				return unauthorized("Usuário e/ou senha inválido");
			}
		}
		return unauthorized("Usuário e/ou senha inválido");
	}
}
