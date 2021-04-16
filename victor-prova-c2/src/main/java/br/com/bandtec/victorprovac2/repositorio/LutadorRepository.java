package br.com.bandtec.victorprovac2.repositorio;

import br.com.bandtec.victorprovac2.dominio.Lutadores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LutadorRepository extends JpaRepository<Lutadores, Integer> {

    //List<Lutadores> findByConcentracoes();

    @Query("select l from Lutadores l")
    List<Lutadores> findAllPegaTodos();

    @Query("select l from Lutadores l where vivo > 0")
    List<Lutadores> findAllPegaTodosVivos();
}
