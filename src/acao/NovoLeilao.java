package acao;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import leilao.Leilao;

public class NovoLeilao {
	private HttpServletRequest req;
	private HttpServletResponse resp;

	public NovoLeilao(HttpServletRequest req, HttpServletResponse resp) {
		this.req=req;
		this.resp=resp;
	}
	public void executa() throws IOException, ServletException{
		req.getRequestDispatcher("/WEB-INF/pages/cadastroLeilao.jsp").forward(req, resp);
	} 
}
