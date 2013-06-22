package controllers;

import static play.data.Form.form;
import models.Usuario;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class Login extends Controller {
    final static Form<Usuario> loginForm = form(Usuario.class);
    
	public static Result login() {
		return ok(views.html.login.form.render(loginForm));
	}
	
//	@BodyParser.Of(BodyParser.Json.class)
	public static Result execute() {
		Form<Usuario> bindFromRequest = loginForm.bindFromRequest();
		boolean hasErrors = bindFromRequest.hasErrors();
		if (!hasErrors) {
			if (bindFromRequest.get() != null) {
				Usuario byId = Usuario.find.byId(bindFromRequest.get().id);
				if (byId.senha.equalsIgnoreCase(bindFromRequest.get().senha)) {
					//TODO criar pagina apos o login. admin page teste
					return ok();
				}else {
					return unauthorized("Usuário e/ou senha inválido");
				}
			}
			return unauthorized("Usuário e/ou senha inválido");
		}else {
			return badRequest();
		}
	}
}
