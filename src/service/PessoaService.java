package service;

import leilao.Leilao;
import leilao.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Optional;

public class PessoaService {

    private EntityManager em = Persistence.createEntityManagerFactory("postgres-leilao").createEntityManager();;

    public void salva(Pessoa pessoa) {
    	if(pessoa.getNome().isEmpty()) {
			 throw new RuntimeException("O campo nome deve ser inserido");
		 }
        em.getTransaction().begin();
        em.persist(pessoa);
        em.getTransaction().commit();
    }

    public List<Pessoa> consultaTodasPessoas(){
        List<Pessoa> pessoas = em.createQuery("SELECT c FROM Pessoa c").getResultList();
        return pessoas;
    }
    public Pessoa buscaPessoa(String nomePessoa){
    	List<Pessoa> pessoas = consultaTodasPessoas();
		Optional<Pessoa> pessoa = pessoas.stream().filter(p -> p.getNome().equals(nomePessoa)).findAny();
		Pessoa pessoaExistente= pessoa.get();
        return pessoaExistente;
    }
    public void delete(String nomePessoa){
		 List<Pessoa> pessoas = consultaTodasPessoas();
		 Optional<Pessoa> pessoa = pessoas.stream().filter(p -> p.getNome().equals(nomePessoa)).findAny();
		 Pessoa pessoaExistente= pessoa.get();
		 em.getTransaction().begin();
		 em.remove(pessoaExistente);
		 em.getTransaction().commit();
	 }
	 
	 public void atualizar(String nomePessoa){
		 List<Pessoa> pessoas = consultaTodasPessoas();
		 Optional<Pessoa> pessoa = pessoas.stream().filter(p -> p.getNome().equals(nomePessoa)).findAny();
		 Pessoa pessoaExistente= pessoa.get();
		 em.getTransaction().begin();
		 pessoaExistente.setNome("tarley juju");
		 em.getTransaction().commit();        
	 }
}
