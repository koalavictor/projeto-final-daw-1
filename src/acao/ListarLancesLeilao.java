package acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import leilao.Lance;
import leilao.Leilao;
import service.LeilaoService;

public class ListarLancesLeilao {
	private HttpServletRequest req;
	private HttpServletResponse resp;

	public ListarLancesLeilao(HttpServletRequest req, HttpServletResponse resp) {
		this.req=req;
		this.resp=resp;
	}
	
	public void executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//String campoNome = req.getParameter("input-name");
		List<Lance> lances = new LeilaoService().consultaTodosLances();
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/lancesLeilao.jsp");
		req.setAttribute("lances", lances);
		req.setAttribute("usuarioLogado", "koala");
		//req.setAttribute("Leilao", campoNome);
		dispatcher.forward(req, resp);
	}
}
