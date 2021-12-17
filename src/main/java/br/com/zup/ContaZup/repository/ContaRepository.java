package br.com.zup.ContaZup.repository;

import br.com.zup.ContaZup.enums.Status;
import br.com.zup.ContaZup.enums.Tipo;
import br.com.zup.ContaZup.model.Conta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContaRepository extends CrudRepository<Conta, Long> {

    List<Conta> findAllByStatus(Status status);

    List<Conta> findAllByTipo(Tipo tipo);

    @Query(value = "SELECT * FROM contas u WHERE u.valor BETWEEN ?1 * 0.8 AND ?1 * 1.2", nativeQuery = true)
    List<Conta> findAllByValor(Double valor);

}
