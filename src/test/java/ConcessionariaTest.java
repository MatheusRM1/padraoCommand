import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.command.*;

class ConcessionariaTest {

    Concessionaria concessionaria;
    Estoque estoque;

    @BeforeEach
    void setUp() {
        concessionaria = new Concessionaria();
        estoque = new Estoque();
    }

    @Test
    void deveAdicionarVeiculoEstoque() {
        Tarefa entradaVeiculo = new EntradaVeiculoTarefa(estoque);
        concessionaria.executarTarefa(entradaVeiculo);

        assertEquals(1, estoque.getQuantidade());
        assertEquals("Veículo adicionado ao estoque", estoque.getSituacao());
    }

    @Test
    void deveRetirarVeiculoEstoque() {
        estoque.adicionarVeiculo();

        Tarefa saidaVeiculo = new SaidaVeiculoTarefa(estoque);
        concessionaria.executarTarefa(saidaVeiculo);

        assertEquals(0, estoque.getQuantidade());
        assertEquals("Veículo retirado do estoque", estoque.getSituacao());
    }

    @Test
    void deveCancelarSaidaVeiculoEstoque() {
        estoque.adicionarVeiculo();

        Tarefa entradaVeiculo = new EntradaVeiculoTarefa(estoque);
        Tarefa saidaVeiculo = new SaidaVeiculoTarefa(estoque);

        concessionaria.executarTarefa(entradaVeiculo);
        concessionaria.executarTarefa(saidaVeiculo);

        concessionaria.cancelarUltimaTarefa();

        assertEquals(2, estoque.getQuantidade());
        assertEquals("Veículo adicionado ao estoque", estoque.getSituacao());
    }

}
