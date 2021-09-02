package repositorio;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import leilao.Lance;
import leilao.Leilao;

public class LeilaoRepositorio {
	 private EntityManager em = Persistence.createEntityManagerFactory("postgres-leilao").createEntityManager();
	 
	 public void salva(Leilao leilao){
		 if(leilao.getItem().isEmpty()) {
			 throw new RuntimeException("O campo nome nao pode estar vazio");
		 }
         try {
        	 em.getTransaction().begin();
             em.persist(leilao);
             em.getTransaction().commit();
             em.close(); 
	    	}catch(Exception ex) {
	    		System.out.println(ex);
	    		System.out.println(ex.getMessage());
	    }
	 }
	 
	 public void delete(String nomeLeilao){
		 List<Leilao> leiloes = consultaTodosLeiloes();
		 Optional<Leilao> leilao = leiloes.stream().filter(l -> l.getItem().equals(nomeLeilao)).findAny();
		 Leilao leilaoExistente= leilao.get();
		 em.getTransaction().begin();
		 em.remove(leilaoExistente);
		 em.getTransaction().commit();
	 }
	 
	 public void atualizar(String nomeLeilao){
		 List<Leilao> leiloes = consultaTodosLeiloes();
		 Optional<Leilao> leilao = leiloes.stream().filter(l -> l.getItem().equals(nomeLeilao)).findAny();
		 Leilao leilaoExistente= leilao.get();
		 em.getTransaction().begin();
		 leilaoExistente.setItem("tarley juju");
		 em.getTransaction().commit();        
	 }
	 
	 public void Lance(Lance lance){
		 if(lance.getValor()>lance.getLeilao().getValor()) {
			 throw new RuntimeException("O valor do lance deve ser maior que o lance minimo");
		 }
		 try {
			 em.getTransaction().begin();
			 em.persist(lance);
			 em.getTransaction().commit();
			 em.close();
		 }catch(Exception ex) {
			 System.out.println(ex);
			 System.out.println(ex.getMessage());
		 }
	 }
	 
	 public List<Leilao> consultaTodosLeiloes(){
		 List<Leilao> leiloes = em.createQuery("SELECT c FROM Leilao c").getResultList();
		 return leiloes;
	 }
	 
	 public Leilao buscaLeilao(String nomeLeilao){
		 List<Leilao> leiloes = consultaTodosLeiloes();
		 Optional<Leilao> leilao = leiloes.stream().filter(l -> l.getItem().equals(nomeLeilao)).findAny();
		 Leilao leilaoExistente= leilao.get();
		 return leilaoExistente;
	 }
	 
	 public void resetaBase(){
		 Query queryLance = em.createQuery("Delete from Lance ");
		 Query queryLeilao = em.createQuery("Delete from Leilao");
		 Query queryPessoa = em.createQuery("Delete from Pessoa ");
		 em.getTransaction().begin();
		 queryLance.executeUpdate();
		 queryLeilao.executeUpdate();
		 queryPessoa.executeUpdate();
		 em.getTransaction().commit();
	 }
	 
	 public List<Lance> consultaTodosLances() {
		 List<Lance> lances = em.createQuery("SELECT c FROM Lance c").getResultList();
		 return lances;
	 }
	 	
	 public void initLeilao(Leilao leilao) {
		 if(leilao.getFiltroLeiloes().equals("EXPIRADO")) {
			 throw new RuntimeException("Um leilao expirado não pode ser aberto");
		 }
		 try {
        	 List<Leilao> leiloes = consultaTodosLeiloes();
			 Optional<Leilao> le = leiloes.stream().filter(l -> l.getItem().equals(leilao.getItem())).findAny();
			 Leilao leilaoExistente= le.get();
			 em.getTransaction().begin();
			 leilaoExistente.setFiltroLeiloes("ABERTO");
			 em.getTransaction().commit();
	    	}catch(Exception ex) {
	    		System.out.println(ex);
	    		System.out.println(ex.getMessage());
	    }
	 }
	 
	 public void fimLeilao(Leilao leilao) {
		 try {
        	 List<Leilao> leiloes = consultaTodosLeiloes();
			 Optional<Leilao> le = leiloes.stream().filter(l -> l.getItem().equals(leilao.getItem())).findAny();
			 Leilao leilaoExistente= le.get();
			 em.getTransaction().begin();
			 leilaoExistente.setFiltroLeiloes("FINALIZADO");
			 em.getTransaction().commit();
	    	}catch(Exception ex) {
	    		System.out.println(ex);
	    		System.out.println(ex.getMessage());
	    }
	 }
	 
	 public void expirarLeilao(Leilao leilao) {
		 //LocalDate localDateAtual = LocalDate.of(2022, Month.JULY, 12);
		 //LocalDate localDateExpirado = leilao.getDataExpiracao();
		
			try {
        	 List<Leilao> leiloes = consultaTodosLeiloes();
			 Optional<Leilao> le = leiloes.stream().filter(l -> l.getItem().equals(leilao.getItem())).findAny();
			 Leilao leilaoExistente= le.get();
			 em.getTransaction().begin();
			 leilaoExistente.setFiltroLeiloes("EXPIRADO");
			 em.getTransaction().commit();
	    	}catch(Exception ex) {
	    		System.out.println(ex);
	    		System.out.println(ex.getMessage());
	    }
		 
	 }
	 
	 public List<Lance> retornaLances(){
		 List<Lance> lances = em.createQuery("FROM Lance c ORDER BY c.valor DESC").getResultList();
		 List<Lance> listaLances = null;
	
		 int tamanho = lances.size();
		 listaLances = lances.subList(0, tamanho);
	
		 return listaLances;
	 }

	 public List<Lance> retornaOMenorValor(){
		 String sql = "SELECT c FROM Lance as c WHERE c.valor = (SELECT min(cc.valor) FROM Lance cc)";
		 List<Lance> lances = em.createQuery(sql).getResultList();
		 return lances;
	 }
	   
}
