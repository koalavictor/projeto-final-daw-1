package teste;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import leilao.Lance;
import leilao.Leilao;
import leilao.Pessoa;
import repositorio.LeilaoRepositorio;
import service.LeilaoService;
import service.PessoaService;

public class TestesUnitarios {

	@Before
    public void resetaBase(){
        new LeilaoService().resetaBase();
        
    }
	LeilaoRepositorio fakeRepositorio = Mockito.mock(LeilaoRepositorio.class);
	Leilao leilao = new Leilao("NITENDO", LocalDate.of(2021, Month.JULY, 12), 100);
	LeilaoService service = new LeilaoService(fakeRepositorio);
	
	@Test //(expected = RuntimeException.class)
    public void criarLeilao(){             
        service.salva(leilao);
        Mockito.verify(fakeRepositorio).salva(leilao);
    }
	
	@Test
    public void leilaoInativo(){
       
    }
	
	@Test
    public void criarPessoa(){
       
        List<Pessoa> pessoas = new PessoaService().consultaTodasPessoas();
        assertEquals(0, pessoas.size());
        Pessoa pessoa = new Pessoa("Koala");
        new PessoaService().salva(pessoa);

        pessoas = new PessoaService().consultaTodasPessoas();
        assertEquals(1, pessoas.size());
    }

    @Test
    public void ProporApenasUmLance() {

        Leilao leilao = new Leilao("eletronicos", LocalDate.of(2021, Month.JULY, 12), 100);
        service.salva(leilao);

        Pessoa lucas = new Pessoa("Lucas");
        new PessoaService().salva(lucas);

        List<Lance> lances = new LeilaoService().consultaTodosLances();
        assertEquals(0, lances.size());

        Lance lance = new Lance(40.0, lucas, leilao);
        service.Lance(lance);

        lances = service.consultaTodosLances();
        Mockito.verify(fakeRepositorio).Lance(lance);
        assertEquals(1, lances.size());
    }
	
	@Test
    public void abrirLeilao(){

        service.salva(leilao);
        service.initLeilao(leilao);
        Mockito.verify(fakeRepositorio).initLeilao(leilao);
    }
	
	 @Test
	    public void RetornarZeroQuandoMenorIgualAZero() {
	        Leilao leilao = new Leilao("NITENDO", LocalDate.of(2021, Month.JULY, 12), 100);

	        assertEquals(0, leilao.maiorLance(), 0.0001);
	        assertEquals(0, leilao.menorLance(), 0.0001);
	    }
	
	@After
    public void resetaBase2(){
        new LeilaoService().resetaBase();
        
    }
}
