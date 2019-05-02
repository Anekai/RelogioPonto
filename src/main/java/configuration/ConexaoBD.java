
package configuration;

import java.sql.*;

public class ConexaoBD {

    private static ConexaoBD instancia = null;
    private Connection conexao = null;

    public ConexaoBD() {
        try {
            // Carrega Driver do Banco de Dados
            Class.forName("org.postgresql.Driver");

            conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/relogio", "postgres", "postgres");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    // Retorna instância
    public static ConexaoBD getInstance() {
        if (instancia == null) {
            instancia = new ConexaoBD();
        }
        return instancia;
    }

    // Retorna conexão
    public Connection getConnection() {
        if (conexao == null) {
            throw new RuntimeException("conexao==null");
        }
        return conexao;
    }

    // Efetua fechamento da conexão
    public void shutDown() {
        try {
            conexao.close();
            instancia = null;
            conexao = null;
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}