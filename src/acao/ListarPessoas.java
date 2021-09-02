package acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import leilao.Leilao;
import leilao.Pessoa;
import service.LeilaoService;
import service.PessoaService;

public class ListarPessoas {
	private HttpServletRequest req;
	private HttpServletResponse resp;

	public ListarPessoas(HttpServletRequest req, HttpServletResponse resp) {
		this.req=req;
		this.resp=resp;
	}
	
	public void executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Pessoa> pessoas = new PessoaService().consultaTodasPessoas();
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/pessoas.jsp");
		req.setAttribute("pessoas", pessoas);
		req.setAttribute("usuarioLogado", "koala");
		dispatcher.forward(req, resp);
	}
}
