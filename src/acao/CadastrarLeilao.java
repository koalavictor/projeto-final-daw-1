package acao;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import leilao.Leilao;
import service.LeilaoService;


public class CadastrarLeilao {
	private HttpServletRequest req;
	private HttpServletResponse resp;

	public CadastrarLeilao(HttpServletRequest req, HttpServletResponse resp) {
		this.req=req;
		this.resp=resp;
		
	}
	
	public void executa() throws IOException{
		String campoNome = req.getParameter("input-name");
		String lanceMinimo = req.getParameter("input-valor");
		lanceMinimo = lanceMinimo.replaceAll(",", ".");
		Double valor = Double.parseDouble(lanceMinimo);
		Leilao leilao= new Leilao(campoNome, LocalDate.of(2021, Month.AUGUST, 5), valor);
		new LeilaoService().salva(leilao);
		resp.sendRedirect(req.getServletContext().getContextPath() + "/entrada?acao=listar");
	} 
}
