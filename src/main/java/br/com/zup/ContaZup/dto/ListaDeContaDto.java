package br.com.zup.ContaZup.dto;

import br.com.zup.ContaZup.enums.Status;

public class ListaDeContaDto {
    private Long id;
    private String nome;
    private Double valor;
    private Status status;

    public ListaDeContaDto() {
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
