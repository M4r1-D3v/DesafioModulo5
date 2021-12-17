package br.com.zup.ContaZup.dto;

import br.com.zup.ContaZup.enums.Status;
import br.com.zup.ContaZup.enums.Tipo;

public class ContaDto {

    private String nome;
    private Double valor;
    private Status status;
    private Tipo tipo;

    public ContaDto() {
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

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
}
