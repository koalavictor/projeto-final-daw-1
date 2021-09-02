package acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout {
	private HttpServletRequest req;
	private HttpServletResponse resp;

	public Logout(HttpServletRequest req, HttpServletResponse resp) {
		this.req=req;
		this.resp=resp;
	}
	public void executa() throws IOException, ServletException{
		HttpSession session = req.getSession();
		session.invalidate();
		req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req, resp);
	} 
}
