package br.com.zup.ContaZup.dto;

import br.com.zup.ContaZup.enums.Status;

public class PagamentoContaDto {
    private Status status;

    public PagamentoContaDto() {
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
