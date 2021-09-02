package service;

import leilao.Lance;
import leilao.Leilao;
import repositorio.LeilaoRepositorio;

import javax.management.RuntimeErrorException;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LeilaoService {

	private LeilaoRepositorio repositorio = new LeilaoRepositorio();
    
    public LeilaoService() {
    }
    
    public LeilaoService(LeilaoRepositorio repositorio) {
    	this.repositorio = repositorio;
	}
    
	public void resetaBase(){
        repositorio.resetaBase();
    }

    public void atualizar(String nomeLeilao){
    	repositorio.atualizar(nomeLeilao);
    }
    public void Lance(Lance lance){
    	repositorio.Lance(lance);
    }
    
    public void delete(String nomeLeilao){
    	repositorio.delete(nomeLeilao);
    }
    
    public void salva(Leilao leilao){
    	repositorio.salva(leilao);
    }
    
    public List<Leilao> consultaTodosLeiloes(){
        List<Leilao> leiloes = repositorio.consultaTodosLeiloes();
        return leiloes;
    }
    
    public Leilao buscaLeilao(String nomeLeilao){
    	Leilao leilao = repositorio.buscaLeilao(nomeLeilao);
    	return leilao;
    }
    
    public List<Lance> consultaTodosLances() {
        List<Lance> lances = repositorio.consultaTodosLances();
        return lances;
    }
    
    public void initLeilao(Leilao leilao) {
    	repositorio.initLeilao(leilao);
    }
    
    public void fimLeilao(Leilao leilao) {
    	repositorio.fimLeilao(leilao);
    }
    
    public void expirarLeilao(Leilao leilao) {
    	repositorio.expirarLeilao(leilao);
    }
    
    public List<Lance> retornaLances(){
    	List<Lance> listaLances = repositorio.retornaLances();
        return listaLances;
    }

    public List<Lance> retornaOMenorValor(){
    	List<Lance> lances = repositorio.retornaOMenorValor();
        return lances;
    }
}