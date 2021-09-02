package acao;

import java.io.IOException;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import leilao.Leilao;
import service.LeilaoService;

public class AtualizarLeilao {
	private HttpServletRequest req;
	private HttpServletResponse resp;

	public AtualizarLeilao(HttpServletRequest req, HttpServletResponse resp) {
		this.req=req;
		this.resp=resp;
	}
	public void executa() throws ServletException, IOException {
		String nomeLeilao = req.getParameter("nomeLeilao");
		new LeilaoService().atualizar(nomeLeilao);
		List<Leilao> leiloes = new LeilaoService().consultaTodosLeiloes();
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/leiloes.jsp");
		req.setAttribute("leiloes", leiloes);
		dispatcher.forward(req, resp);
	}
}
