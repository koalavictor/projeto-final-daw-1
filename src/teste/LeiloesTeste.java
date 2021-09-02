package teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import leilao.Pessoa;
import repositorio.LeilaoRepositorio;
import service.LeilaoService;
import service.PessoaService;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import leilao.Lance;
import leilao.Leilao;

public class LeiloesTeste {



    @Before
    public void resetaBase(){
        new LeilaoService().resetaBase();
    }
 
    
	@Test
    public void criarLeilao(){
        List<Leilao> leiloes = new LeilaoService().consultaTodosLeiloes();
        assertEquals(0, leiloes.size());
        Leilao leilao = new Leilao("NITENDO", LocalDate.of(2021, Month.JULY, 12), 100);
        new LeilaoService().salva(leilao);
        leiloes = new LeilaoService().consultaTodosLeiloes();
        assertEquals(1, leiloes.size());
    }
    
    
    @Test
    public void leilaoInativo(){
       
        Leilao leilao = new Leilao("PS4", LocalDate.of(2021, Month.JULY, 12), 100);
        new LeilaoService().salva(leilao);
        assertEquals("INATIVO", leilao.getFiltroLeiloes());
    } 
    
    @Test
    public void abrirLeilao(){

        Leilao leilao = new Leilao("XBOX", LocalDate.of(2021, Month.JULY, 12), 100);
        new LeilaoService().salva(leilao);
        new LeilaoService().initLeilao(leilao);
        Leilao l = new LeilaoService().buscaLeilao(leilao.getItem());
        assertEquals("ABERTO", l.getFiltroLeiloes());
    }
    
    @Test
    public void fecharLeilao(){

        Leilao leilao = new Leilao("XBOX", LocalDate.of(2021, Month.JULY, 12), 100);
        new LeilaoService().salva(leilao);
        new LeilaoService().fimLeilao(leilao);
        Leilao l = new LeilaoService().buscaLeilao(leilao.getItem());
        assertEquals("FINALIZADO", l.getFiltroLeiloes());
    }
    
    @Test
    public void expirarLeilao(){

        Leilao leilao = new Leilao("XBOX", LocalDate.of(2023, Month.JULY, 12), 100);
        new LeilaoService().salva(leilao);
        new LeilaoService().expirarLeilao(leilao);
        Leilao l = new LeilaoService().buscaLeilao(leilao.getItem());
        assertEquals("EXPIRADO", l.getFiltroLeiloes());
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
        new LeilaoService().salva(leilao);

        Pessoa lucas = new Pessoa("Lucas");
        new PessoaService().salva(lucas);

        List<Lance> lances = new LeilaoService().consultaTodosLances();
        assertEquals(0, lances.size());

        Lance lance = new Lance(40.0, lucas, leilao);
        new LeilaoService().Lance(lance);

        lances = new LeilaoService().consultaTodosLances();
        assertEquals(1, lances.size());
    }


    @Test
    public void RetornarLance() {

        Leilao leilao = new Leilao("XBOX", LocalDate.of(2021, Month.JULY, 12), 100);
        new LeilaoService().salva(leilao);

        Pessoa Koala = new Pessoa("Koala");
        new PessoaService().salva(Koala);

        Pessoa joao = new Pessoa("Joao");
        new PessoaService().salva(joao);

        Pessoa kenyo = new Pessoa("Kenyo");
        new PessoaService().salva(kenyo);

        Lance lanceKoala = new Lance(50.0, Koala, leilao);
        new LeilaoService().Lance(lanceKoala);

        Lance lanceJoao = new Lance(55.0, joao, leilao);
        new LeilaoService().Lance(lanceJoao);

        Lance lanceKenyo = new Lance(35.0, kenyo, leilao);
        new LeilaoService().Lance(lanceKenyo);

        List<Lance> listaLances = new LeilaoService().retornaLances();

        assertEquals(35.0 , listaLances.get(2).getValor(), 0.0001);
        assertEquals(50.0 , listaLances.get(1).getValor(), 0.0001);
        assertEquals(55.0 , listaLances.get(0).getValor(), 0.0001);
    }


    @Test
    public void RetornarOMenorLance() {
        Leilao leilao = new Leilao("PC GAMER", LocalDate.of(2021, Month.JULY, 12), 100);
        new LeilaoService().salva(leilao);

        Pessoa lucas = new Pessoa("Lucas");
        new PessoaService().salva(lucas);

        Pessoa joao = new Pessoa("Joao");
        new PessoaService().salva(joao);

        Pessoa kenyo = new Pessoa("Kenyo");
        new PessoaService().salva(kenyo);

        Lance lanceLucas = new Lance(40.0, lucas,leilao);
        new LeilaoService().Lance(lanceLucas);

        Lance lanceJoao = new Lance(50.0, joao,leilao);
        new LeilaoService().Lance(lanceJoao);

        Lance lanceKenyo = new Lance(30.0, kenyo,leilao);
        new LeilaoService().Lance(lanceKenyo);

        List<Lance> menorLance = new LeilaoService().retornaOMenorValor();

        assertEquals(1, menorLance.size(), 0.0001);
        assertEquals(30.0, menorLance.get(0).getValor(), 0.0001);
    }

    @Test
    public void RetornarZeroQuandoMenorIgualAZero() {
        Leilao leilao = new Leilao("NITENDO", LocalDate.of(2021, Month.JULY, 12), 100);

        assertEquals(0, leilao.maiorLance(), 0.0001);
        assertEquals(0, leilao.menorLance(), 0.0001);
    }

    @Test
    public void ImpedirUmNovoLanceComValorMenorQueMaiorLance() {
        Leilao leilao = new Leilao("Betoneira amarela", LocalDate.of(2021, Month.JULY, 12), 100);

        Pessoa lucas = new Pessoa("Lucas");
        Pessoa Koala = new Pessoa("Koala");

        Lance lanceLucas = new Lance(35.0, lucas,leilao);
        Lance lanceKoala = new Lance(30.0, Koala,leilao);

        leilao.propoe(lanceLucas);

        try {
            leilao.propoe(lanceKoala);
            fail();
        } catch (RuntimeException e) {

        }
    }

    @Test
    public void ImpedirUmLanceDuasVezesDaMesmaPessoa() {
        Leilao leilao = new Leilao("roupas", LocalDate.of(2021, Month.JULY, 12), 100);

        Pessoa lucas = new Pessoa("Lucas");
        Pessoa Koala = new Pessoa("Koala");

        Lance lanceLucas = new Lance(35.0, lucas, leilao);
        Lance lanceKoala = new Lance(37.0, Koala, leilao);
        Lance outroLanceLucas = new Lance(40.0, lucas, leilao);

        leilao.propoe(lanceLucas);
        
        leilao.propoe(lanceKoala);
        
        leilao.propoe(outroLanceLucas);

        try {
            leilao.propoe(outroLanceLucas);
            fail();
        } catch (RuntimeException e) {

        }
    }
    @After
    public void resetaBase2(){
        new LeilaoService().resetaBase();
    }

}