package br.com.teste_tecnico.teste.Controller.Apolices;

import br.com.teste_tecnico.teste.domain.Apolices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ApolicesRepository extends JpaRepository<Apolices,Long> {

    Optional<Apolices> findBYNumeroapolice(Number numero_apolice);

    @Query("SELECT p.placa_veiculo, p.valor_apolice FROM Apolices p where p.placa_veiculo=?1")
    Optional<Apolices>Placa_Val_Apolice(String placa_veiculo);
}
