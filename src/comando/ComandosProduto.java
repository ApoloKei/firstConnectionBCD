package comando;

import conexao.ConectaMySql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ComandosProduto {

    public boolean inserirBD(String produto,String categoria,float preco){
        //Criação do comando a ser executado no banco de dados
        String comando = "INSERT INTO tb_produto" + " VALUES(null,?,?,?);";
        //conexao do banco de dados
        ConectaMySql conecta = new ConectaMySql();
        Connection conexao = conecta.iniciarConexao();
        //Preparar a conexão com o comando que será executado nela
        try {
            PreparedStatement ps = conecta.iniciarConexao().prepareStatement(comando);
            //Passagem de valores para cada ? do comando INSERT
            ps.setString(1,produto);
            ps.setString(2,categoria);
            ps.setFloat(3,preco);
            ps.execute();
            //Execução do comando no Banco de Dados e teste do que foi retornado
        } catch (SQLException e) {
            System.out.println("NAO");
            throw new RuntimeException("NAO DEU");
        }

        return false;
    }
}
