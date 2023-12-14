package controle_de_contas;

import banco_de_dados.BD;
import banco_de_dados.BdException;

import java.sql.*;

public class Conta {

    private Connection conn = null;
    private Statement st = null;
    private ResultSet rs = null;
    private PreparedStatement ps = null;

    public Conta() {
        conn = BD.abrirConexao();
    }

    public void amostrarContas() {
        try {

            st = conn.createStatement();
            rs = st.executeQuery("select id, nomeTitular from conta");

            System.out.println("Contas Disponíveis para fazer pix:");
            while (rs.next()){

                System.out.println("Id: "+ rs.getInt("id") + " Titular: " + rs.getString("nomeTitular"));

            }

        } catch (SQLException e) {
            throw new BdException(e.getMessage());

        } finally {
            BD.fecharStatementAndResultSet(st,rs);
        }
    }

    public void verSaldo(int id) {
        try {
            st = conn.createStatement();
            rs = st.executeQuery("select nomeTitular, saldo from conta where id = " + id);

            while (rs.next()) {
                System.out.println("O saldo da conta de " + rs.getString("nomeTitular") + " tem saldo de " + String.format("%.2f", rs.getDouble("saldo")));
            }
        } catch (SQLException e) {
            throw new BdException(e.getMessage());

        } finally {
            BD.fecharStatementAndResultSet(st,rs);
        }
    }

    public void criarConta(int id, String nomeTitular, Double saldo) {
        try {
            ps = conn.prepareStatement("insert into conta (id, nomeTitular, saldo) values " +
                    "(?,?,?)");

            ps.setInt(1,id);
            ps.setString(2, nomeTitular);
            ps.setDouble(3,saldo);

            ps.executeUpdate();
            System.out.println("Conta criada e salva no banco de dados com sucesso!");


        } catch (SQLException e) {
            throw new BdException(e.getMessage());

        } finally {
            BD.fecharStatement(ps);
        }
    }

    public void fazerTranferencia(int seuId, int idDaOutraConta, Double valor) {
        try {
            diminuirSaldo(seuId, valor);
            ps = conn.prepareStatement("update conta set saldo = saldo + " + valor + " where id = " + idDaOutraConta);

            ps.executeUpdate();

            System.out.println("Transferência realizada com sucesso!");

        } catch (SQLException e) {
            throw new BdException(e.getMessage());

        } finally {
            BD.fecharStatement(ps);
        }
    }

    private void diminuirSaldo(int id, Double valor){
        try {
            ps = conn.prepareStatement("update conta set saldo = saldo - " + valor + "where id = " + id);

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new BdException(e.getMessage());

        } finally {
            BD.fecharStatement(ps);
        }
    }
}
