package org.command;

public class Estoque {

    private int quantidade;
    private String situacao;

    public int getQuantidade() {
        return quantidade;
    }

    public String getSituacao() {
        return situacao;
    }

    public void adicionarVeiculo() {
        this.quantidade++;
        this.situacao = "Veículo adicionado ao estoque";
    }

    public void retirarVeiculo() {
        this.quantidade--;
        this.situacao = "Veículo retirado do estoque";
    }
}