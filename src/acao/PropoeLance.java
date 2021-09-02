package acao;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import leilao.Lance;
import leilao.Leilao;
import leilao.Pessoa;
import service.LeilaoService;
import service.PessoaService;

public class PropoeLance {
	private HttpServletRequest req;
	private HttpServletResponse resp;

	public PropoeLance(HttpServletRequest req, HttpServletResponse resp) {
		this.req=req;
		this.resp=resp;	
	}
	
	public void executa() throws IOException{
		String nomeLeilao = req.getParameter("leilao");
		Leilao leilao=new LeilaoService().buscaLeilao(nomeLeilao);
		String nomePessoa = req.getParameter("pessoa");
		String valorLance = req.getParameter("lance");
		valorLance = valorLance.replaceAll(",", ".");
		Double valor = Double.parseDouble(valorLance);
		Pessoa pessoa = new PessoaService().buscaPessoa(nomePessoa);
		Lance lance = new Lance(valor, pessoa, leilao);
		new LeilaoService().Lance(lance);
		resp.sendRedirect(req.getServletContext().getContextPath() + "/entrada?acao=listarLances");
	}  
}
