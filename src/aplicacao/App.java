package aplicacao;

import controle_de_contas.Conta;

public class App {
    public static void main(String[] args) {
        Conta conta = new Conta();

        conta.amostrarContas();
        conta.verSaldo(1);
    }
}
