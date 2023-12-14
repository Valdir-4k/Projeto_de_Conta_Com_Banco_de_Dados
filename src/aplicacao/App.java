package aplicacao;

import controle_de_contas.Conta;

public class App {
    public static void main(String[] args) {
        Conta conta = new Conta();


        //conta.criarConta(2, "João", 1000.00);
        //conta.amostrarContas();

        //conta.fazerTranferencia(1, 2, 500.00);

        conta.verSaldo(1);
        conta.verSaldo(2);

        conta.fazerTranferencia(2, 1, 1500.00);

        conta.verSaldo(1);
        conta.verSaldo(2);
    }
}
