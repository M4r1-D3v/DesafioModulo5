package br.com.zup.ContaZup.dto;

import br.com.zup.ContaZup.enums.Status;
import br.com.zup.ContaZup.enums.Tipo;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class RespostaPagamentoDto {
    private Long id;
    private String nome;
    private Double valor;
    private Tipo tipo;
    private LocalDate dataDeVencimento;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataDePagamento;
    private Status status;

    public RespostaPagamentoDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public RespostaPagamentoDto(Long id, String nome, Double valor, Tipo tipo, LocalDate dataDeVencimento, LocalDateTime dataDePagamento, Status status) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.tipo = tipo;
        this.dataDeVencimento = dataDeVencimento;
        this.dataDePagamento = dataDePagamento;
        this.status = status;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public LocalDate getDataDeVencimento() {
        return dataDeVencimento;
    }

    public void setDataDeVencimento(LocalDate dataDeVencimento) {
        this.dataDeVencimento = dataDeVencimento;
    }

    public LocalDateTime getDataDePagamento() {
        return dataDePagamento;
    }

    public void setDataDePagamento(LocalDateTime dataDePagamento) {
        this.dataDePagamento = dataDePagamento;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
