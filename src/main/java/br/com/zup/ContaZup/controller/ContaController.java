package br.com.zup.ContaZup.controller;

import br.com.zup.ContaZup.dto.*;
import br.com.zup.ContaZup.enums.Status;
import br.com.zup.ContaZup.enums.Tipo;
import br.com.zup.ContaZup.model.Conta;
import br.com.zup.ContaZup.service.ContaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/contas")
public class ContaController {
    @Autowired
    private ContaService contaService;
    @Autowired
    private ModelMapper modelMapper;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RespostaPagamentoDto cadastrarConta(@RequestBody @Valid CadastroContaDto cadastro) {
        Conta contaCadastrada = modelMapper.map(cadastro, Conta.class);
        return modelMapper.map(contaService.salvarConta(contaCadastrada), RespostaPagamentoDto.class);
        //return contaService.salvarConta(cadastro);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<RespostaPagamentoDto> mostrarListaDeContas(@RequestParam(required = false) Status status,
                                                      @RequestParam(required = false)Tipo tipo,
                                                      @RequestParam(required = false)Double valor){ //Implementar rota para exibir a lista de contas
        List<RespostaPagamentoDto> listaDeContaDto = new ArrayList<>();
        for (Conta conta : contaService.exibirTodasAsContas(status,tipo,valor)) {
            RespostaPagamentoDto listaDeContaDtoRequest = modelMapper.map(conta, RespostaPagamentoDto.class);
            listaDeContaDto.add(listaDeContaDtoRequest);
        }
        return listaDeContaDto;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public RespostaPagamentoDto mostrarContaDetalhada(@PathVariable Long id){
        Conta contapesquisada = contaService.pesquisarContaPorId(id);
        return modelMapper.map(contapesquisada,RespostaPagamentoDto.class);

    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RespostaPagamentoDto registrarPagamento(@PathVariable Long id, @RequestBody PagamentoContaDto pgtoContaDto){

        Conta contaPaga = contaService.alterarStatusPagamento(id);
        return modelMapper.map(contaPaga, RespostaPagamentoDto.class);


    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirConta (@PathVariable Long id){
        contaService.deletarConta(id);
    }


}


