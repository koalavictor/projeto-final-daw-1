package acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import leilao.Leilao;
import service.LeilaoService;


public class ListarLeiloes{
	private HttpServletRequest req;
	private HttpServletResponse resp;

	public ListarLeiloes(HttpServletRequest req, HttpServletResponse resp) {
		this.req=req;
		this.resp=resp;
	}
	
	public void executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Leilao> leiloes = new LeilaoService().consultaTodosLeiloes();
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/leiloes.jsp");
		req.setAttribute("leiloes", leiloes);
		req.setAttribute("usuarioLogado", "koala");
		dispatcher.forward(req, resp);
	}
}
