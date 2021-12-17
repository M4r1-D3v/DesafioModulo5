package br.com.zup.ContaZup.service;

import br.com.zup.ContaZup.dto.ContaDto;
import br.com.zup.ContaZup.dto.PagamentoContaDto;
import br.com.zup.ContaZup.dto.RespostaPagamentoDto;
import br.com.zup.ContaZup.enums.Status;
import br.com.zup.ContaZup.enums.Tipo;
import br.com.zup.ContaZup.exception.ContaNaoExisteException;
import br.com.zup.ContaZup.exception.IdNaoEncontradoException;
import br.com.zup.ContaZup.model.Conta;
import br.com.zup.ContaZup.repository.ContaRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ContaService {
    @Autowired
    private ContaRepository contaRepository;


    public Conta verificarStatus(Conta conta) {
        if (conta.getDataDeVencimento().isBefore(LocalDate.now())) {
            conta.setStatus(Status.VENCIDA);
        } else {
            conta.setStatus(Status.AGUARDANDO);
        }
        return conta;
    }

    public Conta salvarConta(Conta conta) {

        verificarStatus(conta);
        contaRepository.save(conta);
        return conta;
    }

    public List<Conta> exibirTodasAsContas(Status status, Tipo tipo, Double valor) {
        if ((status != null)) {
            return contaRepository.findAllByStatus(status);
        } else if (tipo != null) {
            return contaRepository.findAllByTipo(tipo);
        } else if (valor != null) {
            return contaRepository.findAllByValor(valor);
        }
        List<Conta> contas = (List<Conta>) contaRepository.findAll();
        return contas;
    }


    public Conta pesquisarContaPorId(Long id) {
        Optional<Conta> contaPesquisada = contaRepository.findById(id);
        if (contaPesquisada.isPresent()) {

            return contaPesquisada.get();
        }
        throw new IdNaoEncontradoException("Id não encontrado");
    }

    public Conta alterarStatusPagamento(Long id) {
        Conta contaPaga = pesquisarContaPorId(id);
        contaPaga.setStatus(Status.PAGO);
        contaPaga.setDataDePagamento(LocalDateTime.now());
        contaRepository.save(contaPaga);
        return contaPaga;

    }

    public void deletarConta(Long id) {
        if (contaRepository.existsById(id)) {
            contaRepository.deleteById(id);
        } else {
            throw new ContaNaoExisteException("Conta inexistente no sistema");
        }
    }

}
