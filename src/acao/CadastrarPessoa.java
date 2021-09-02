package acao;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import leilao.Leilao;
import leilao.Pessoa;
import service.LeilaoService;
import service.PessoaService;

public class CadastrarPessoa {
	private HttpServletRequest req;
	private HttpServletResponse resp;

	public CadastrarPessoa(HttpServletRequest req, HttpServletResponse resp) {
		this.req=req;
		this.resp=resp;
		
	}
	
	public void executa() throws IOException{
		String campoNome = req.getParameter("input-name");
		Pessoa pessoa= new Pessoa(campoNome);
		new PessoaService().salva(pessoa);
		resp.sendRedirect(req.getServletContext().getContextPath() + "/entrada?acao=listarPessoas");
	}
}
