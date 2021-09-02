package acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NovoLance {
	private HttpServletRequest req;
	private HttpServletResponse resp;

	public NovoLance(HttpServletRequest req, HttpServletResponse resp) {
		this.req=req;
		this.resp=resp;
	}
	public void executa() throws IOException, ServletException{
		req.getRequestDispatcher("/WEB-INF/pages/propoeLances.jsp").forward(req, resp);
	} 
}
