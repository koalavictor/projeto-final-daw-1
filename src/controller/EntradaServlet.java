package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import acao.AtualizarLeilao;
import acao.AtualizarPessoa;
import acao.CadastrarLeilao;
import acao.CadastrarPessoa;
import acao.DeletarLeilao;
import acao.DeletarPessoa;
import acao.ListarLancesLeilao;
import acao.ListarLeiloes;
import acao.ListarPessoas;
import acao.Login;
import acao.Logout;
import acao.NovaPessoa;
import acao.NovoLance;
import acao.NovoLeilao;
import acao.PropoeLance;

@WebServlet(urlPatterns = "/entrada")
public class EntradaServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		if(session.getAttribute("usuarioLogado") ==  null) {
			Login login = new Login(req, resp);
			login.executa();
			return;
		}
		
		String acao = req.getParameter("acao");
		if(acao.equals("novo")) {
			NovoLeilao novoLeilao = new NovoLeilao(req, resp);
			novoLeilao.executa();
			System.out.println("novo acionado");
		}else if(acao.equals("cadastrar")) {
			CadastrarLeilao cadastrarLeilao = new CadastrarLeilao(req, resp);
			cadastrarLeilao.executa();
			System.out.println("cadastrar acionado");
		}else if(acao.equals("excluir")) {
			 DeletarLeilao deletarLeilao= new DeletarLeilao(req, resp);
			 deletarLeilao.executa();
			System.out.println("excluir acionado");
		}else if(acao.equals("listar")) {
			ListarLeiloes listarLeiloes = new ListarLeiloes(req, resp);
			listarLeiloes.executa(req, resp);
			System.out.println("listar acionado");
		}else if(acao.equals("login")) {
			Login login = new Login(req, resp);
			login.executa();
			System.out.println("login acionado");
		}else if(acao.equals("logout")) {
			Logout logout = new Logout(req, resp);
			logout.executa();
			System.out.println("logout acionado");
		}else if(acao.equals("atualizar")) {
			AtualizarLeilao atualizarLeilao = new AtualizarLeilao(req, resp);
			atualizarLeilao.executa();
			System.out.println("atualizar acionado");
		}
		
		else if(acao.equals("lance")) {
			NovoLance novoLance = new NovoLance(req, resp);
			novoLance.executa();
			System.out.println("lance acionado");
		}else if(acao.equals("propoeLance")) {
			PropoeLance propoeLance = new PropoeLance(req, resp);
			propoeLance.executa();
			System.out.println("propoeLance acionado");
		}else if(acao.equals("listarLances")) {
			ListarLancesLeilao listarLancesLeilao = new ListarLancesLeilao(req, resp);
			listarLancesLeilao.executa(req, resp);
			System.out.println("listarLances acionado");
		}
		
		else if(acao.equals("listarPessoas")) {
			ListarPessoas listarPessoas = new ListarPessoas(req, resp);
			listarPessoas.executa(req, resp);
			System.out.println("listarPessoas acionado");
		}else if(acao.equals("atualizarPessoa")) {
			AtualizarPessoa atualizarPessoa = new AtualizarPessoa(req, resp);
			atualizarPessoa.executa();
			System.out.println("atualizarPessoa acionado");
		}else if(acao.equals("excluirPessoa")) {
			 DeletarPessoa deletarPessoa= new DeletarPessoa(req, resp);
			 deletarPessoa.executa();
			System.out.println("excluirPessoa acionado");
		}else if(acao.equals("cadastrarPessoa")) {
			CadastrarPessoa cadastrarPessoa = new CadastrarPessoa(req, resp);
			cadastrarPessoa.executa();
			System.out.println("cadastrarPessoa acionado");
		}else if(acao.equals("novaPessoa")) {
			NovaPessoa novaPessoa = new NovaPessoa(req, resp);
			novaPessoa.executa();
			System.out.println("novaPessoa acionado");
		}
	}
}
 