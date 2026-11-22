package org.command;

public class EntradaVeiculoTarefa implements Tarefa {

    private Estoque estoque;

    public EntradaVeiculoTarefa(Estoque estoque) {
        this.estoque = estoque;
    }

    public void executar() {
        this.estoque.adicionarVeiculo();
    }

    public void cancelar() {
        this.estoque.retirarVeiculo();
    }
}
