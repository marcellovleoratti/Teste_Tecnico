package br.com.teste_tecnico.teste.Controller.Clientes;

import br.com.teste_tecnico.teste.domain.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryClientes extends JpaRepository<Clientes,Long> {

}
