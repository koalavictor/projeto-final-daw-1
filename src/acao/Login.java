package acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login {
	private HttpServletRequest req;
	private HttpServletResponse resp;

	public Login(HttpServletRequest req, HttpServletResponse resp) {
		this.req=req;
		this.resp=resp;
	}
	public void executa() throws IOException, ServletException{
		String login = req.getParameter("input-login");
		String senha = req.getParameter("input-senha");
		if(login!=null && login.equals("koala")&& senha.equals("123")) {
			HttpSession session = req.getSession();
			session.setAttribute("usuarioLogado", login);
			resp.sendRedirect(req.getServletContext().getContextPath() + "/entrada?acao=listar");
			return;
		}
		req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req, resp);
	} 
}
