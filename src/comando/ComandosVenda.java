package comando;

import conexao.ConectaMySql;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ComandosVenda {
    Connection conexao;
        public boolean inserirBD(int quantidade_prod ,String data_venda,int id_cliente,int id_produto) {
            //Criação do comando a ser executado no banco de dados
            String comando = "INSERT INTO tb_venda VALUES(null, ?, ?, ?, ?);";
            //conexao do banco de dados
            ConectaMySql conecta = new ConectaMySql();
            Connection conexao = conecta.iniciarConexao();
            //Preparar a conexão com o comando que será executado nela
            try {
                PreparedStatement ps = conecta.iniciarConexao().prepareStatement(comando);
                //tratando a variavel data de nascimento
                java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("dd/MM/yyyy");
                java.util.Date data = null;
                data = format.parse(data_venda);

                long millis = data.getTime(); //pegando a data em milisegundos(tipo long)
                Date sqlDate = new Date(millis); //O construtor Date passa um valor long


                //Passagem de valores para cada ? do comando INSERT

                ps.setInt(1, quantidade_prod);
                ps.setDate(2, sqlDate);
                ps.setInt(3, id_cliente);
                ps.setInt(4, id_produto);


                //Se alterou pelo menos 1 linha, então o INSERT deu certo
                if (ps.executeUpdate() != 0) {
                    conexao.close(); //Fecha a conexão e libera o recurso
                    return true;
                }
                //Execução do comando no Banco de Dados e teste do que foi retornado
            } catch (SQLException e) {
                throw   new RuntimeException(e);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

            return false;


        }
        public void pesquisarProduto(String comando) {
            //conexao do banco de dados
            Connection conexao;
            conexao = new ConectaMySql().iniciarConexao();

            //guardando o comando sql
            try {
                PreparedStatement ps = conexao.prepareStatement(comando);
                //ResultSet
                ResultSet resultado = ps.executeQuery();//import java.sql.ResultSet

                //Percorrer os valores que o SELECT buscou
                System.out.println("ID Venda \tQuantidade Produto \tCPF\tData Nascimento");
                while (resultado.next()) { //Enquanto tiverem linhas na tablea
                    SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
                    SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
                    String data = out.format(in.parse(resultado.getDate(4).toString()));
                    System.out.println(resultado.getInt(1) + "\t" + resultado.getString(2) + "\t\t" + resultado.getString(3) +
                            "\t" + data);
                    System.out.println();

                    //Fechar a conexão

                }
                conexao.close();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
}
