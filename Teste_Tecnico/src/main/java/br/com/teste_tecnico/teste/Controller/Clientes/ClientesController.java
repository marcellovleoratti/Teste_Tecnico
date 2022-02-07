package br.com.teste_tecnico.teste.Controller.Clientes;


import br.com.teste_tecnico.teste.domain.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@ComponentScan(basePackages = "br.com.desafiovr.Domain")
@RestController
@RequestMapping(path = "/cadastroCliente")
public class ClientesController {
    
    @Autowired
    RepositoryClientes rp;

    @PostMapping(value="/salvar")
    public Clientes gravar(@RequestBody Clientes novoCliente){
        rp.save(novoCliente);
        return novoCliente;
    }

    @GetMapping(value="buscar/{id}")
    public ResponseEntity<Clientes> getById(@PathVariable long id) {
        Optional<Clientes> pr = rp.findById(id);
        if (pr.isPresent()) {
            return new ResponseEntity<>(pr.get(), HttpStatus.OK);
        }else
        {
            return new ResponseEntity<>(pr.get(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value="/apagar/item/{id}")
    public void apagarItem(@PathVariable Long id){
        rp.deleteById(id);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Clientes> updateUser(@PathVariable(value = "id") Long Id,
                                              @Validated @RequestBody Clientes Clientes) throws ResourceNotFoundException {
        Clientes prod = rp.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Clientes Não encontrado:: "+ Clientes));

        final Clientes updatedProd = rp.save(prod);
        return ResponseEntity.ok(updatedProd);
    }
    
    
}
