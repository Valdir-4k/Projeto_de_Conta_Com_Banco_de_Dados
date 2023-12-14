package aplicacao;

import controle_de_contas.Conta;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Conta conta = new Conta();
        Scanner ler = new Scanner(System.in);
        int continuar = 1;

        while (continuar == 1) {

            System.out.println("Programa de Conta de Banco usando banco de dados");
            System.out.println("Digite o que vc quer fazer");
            System.out.println("1-Ver todas as contas\n2-Ver saldo de alguma conta\n3-Criar Conta\n4-Fazer transferência para alguma conta\n5-Deletar alguma conta");
            int pergunta1 = ler.nextInt();

            if (pergunta1 == 1) {
                conta.amostrarContas();

            } else if (pergunta1 == 2) {
                System.out.print("Digite o id da conta que vc quer ver o saldo: ");
                int idDaConta = ler.nextInt();

                conta.verSaldo(idDaConta);

            } else if (pergunta1 == 3) {
                System.out.print("Digite o id da conta a ser cadastrada: ");
                int id = ler.nextInt();
                ler.nextLine();
                System.out.print("Digite o nome do titular da conta: ");
                String nomeTitular = ler.nextLine();

                System.out.print("Digite o saldo dessa conta: ");
                Double saldo = ler.nextDouble();

                conta.criarConta(id, nomeTitular, saldo);

            } else if (pergunta1 == 4) {
                //int seuId, int idDaOutraConta, Double valor)
                System.out.print("Digite o id da sua conta: ");
                int seuId = ler.nextInt();

                System.out.print("Digite o id da conta que vc quer tranferir: ");
                int idDaOutraConta = ler.nextInt();

                System.out.print("Digite o valor da transferência: ");
                Double valor = ler.nextDouble();

                conta.fazerTranferencia(seuId, idDaOutraConta, valor);

            } else if (pergunta1 == 5) {
                System.out.print("Digite o id da conta que você quer deletar: ");
                int id = ler.nextInt();

                conta.deletarConta(id);
            }

            System.out.print("Deseja continuar 1-Sim 2-Não: ");
            continuar = ler.nextInt();
        }

        ler.close();
    }
}
