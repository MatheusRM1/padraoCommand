package org.command;

public class SaidaVeiculoTarefa implements Tarefa {

    private Estoque estoque;

    public SaidaVeiculoTarefa(Estoque estoque) {
        this.estoque = estoque;
    }

    public void executar() {
        this.estoque.retirarVeiculo();
    }

    public void cancelar() {
        this.estoque.adicionarVeiculo();
    }
}
