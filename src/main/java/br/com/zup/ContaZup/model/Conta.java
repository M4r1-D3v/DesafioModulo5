package br.com.zup.ContaZup.model;

import br.com.zup.ContaZup.enums.Status;
import br.com.zup.ContaZup.enums.Tipo;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "contas")
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    private Double valor;
    @Column(nullable = false)
    private Tipo tipo;
    private Status status;
    private LocalDate dataDeVencimento;
    @Column(nullable = true)
    private LocalDateTime dataDePagamento;


    public Conta() {
    }

    public Long getId() {
        return
                id;
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

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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


}
