package teste;
import java.time.LocalDateTime;
    	import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import leilao.Lance;
import leilao.Leilao;
import leilao.Pessoa;
import service.LeilaoService;
import service.PessoaService;

public class Principal {
    public static void main(String[] args) {
        //propoeApenasUmLance();
    	new LeilaoService().resetaBase();
        //propooeVariosLances();
    }

    private static void propooeVariosLances() {
    	    }

    /*private static void propoeApenasUmLance() {
        Leilao leilao = new Leilao("roupas", LocalDate.of(2021, Month.JULY, 12));
        Pessoa lucas = new Pessoa("Lucas");
        Lance lance = new Lance(30.0, lucas);
        if(leilao.getLances().size() == 0){
            leilao.propoe(lance);
            if (leilao.getLances()s.size() >0){
                System.out.println("Funcionou Propoe Apenas Um Lance");
                System.out.println("Maior Lance e: " + leilao.getMaiorLance() + "\n");
            }
        }
    }*/
}