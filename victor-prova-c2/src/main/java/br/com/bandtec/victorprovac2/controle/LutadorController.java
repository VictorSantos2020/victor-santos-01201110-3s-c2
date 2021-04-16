package br.com.bandtec.victorprovac2.controle;

import br.com.bandtec.victorprovac2.dominio.Lutadores;
import br.com.bandtec.victorprovac2.repositorio.LutadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/lutadores")
public class LutadorController {

    @Autowired
    private LutadorRepository repository;

    @PostMapping
    public ResponseEntity postLutador(@RequestBody @Valid Lutadores novoLutador){
        repository.save(novoLutador);
        return status(201).build();
    }

    @GetMapping
    public ResponseEntity getLutador()
    {
        return status(200).body(repository.findAll());
    }

    @GetMapping("/pegaVivos")
    public ResponseEntity getLutadoresVivos()
    {
        return status(200).body(repository.findAllPegaTodosVivos());
    }
}
