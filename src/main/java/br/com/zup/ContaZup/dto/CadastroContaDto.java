package br.com.zup.ContaZup.dto;

import br.com.zup.ContaZup.enums.Tipo;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class CadastroContaDto {
    @Size(min = 2, message = "O mínimo de caracteres permitido é 2")
    private String nome;
    @DecimalMin(value = "0.01", message = "Digite um valor maior que zero")
    private Double valor;
    @NotNull(message = "O tipo da conta não pode ser nulo")
    private Tipo tipo;
    @NotNull(message = "A data de vencimento precisa ser preenchida")
    private LocalDate dataDeVencimento;

    public CadastroContaDto() {
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

    public LocalDate getDataDeVencimento() {
        return dataDeVencimento;
    }

    public void setDataDeVencimento(LocalDate dataDeVencimento) {
        this.dataDeVencimento = dataDeVencimento;
    }
}
