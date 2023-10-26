package comando;

import conexao.ConectaMySql;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ComandosCliente {
    Connection conexao;
    public boolean inserirBD(String nome,String cpf,String data_nasc){

        String comando = "INSERT INTO tb_cliente VALUES(null, ?, ?, ?);";
        ConectaMySql conecta = new ConectaMySql();
        conexao = conecta.iniciarConexao();

        try {
            PreparedStatement ps = conexao.prepareStatement(comando);//catch
            //tratando a variavel data de nascimento
            java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("dd/MM/yyyy");
            java.util.Date data = null;
            data = format.parse(data_nasc);

            long millis = data.getTime(); //pegando a data em milisegundos(tipo long)
            Date sqlDate = new Date(millis); //O construtor Date passa um valor long
            ps.setString(1, nome);
            ps.setString(2, cpf);
            ps.setDate(3,sqlDate);

            //Se alterou pelo menos 1 linha, então o INSERT deu certo
            if (ps.executeUpdate() != 0){
                conexao.close(); //Fecha a conexão e libera o recurso
                return true;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


        return false;
    }
    /*********Pesquisa**********/
    public void pesquisaCliente(String comando) {
        //conexao do banco de dados
        conexao = new ConectaMySql().iniciarConexao();

        //guardando o comando sql
        try {
            PreparedStatement ps = conexao.prepareStatement(comando);
        //ResultSet
            ResultSet resultado = ps.executeQuery();//import java.sql.ResultSet

            //Percorrer os valores que o SELECT buscou
            System.out.println("Código\tNome\tCPF\tData Nascimento");
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
    //Deletar Cliente rapaziada <3333333
    public boolean deletarVenda(String comandoSQL) {
        conexao = new ConectaMySql().iniciarConexao();

        try {
            PreparedStatement ps = conexao.prepareStatement(comandoSQL);
            if (ps.executeUpdate() != 0){
                conexao.close();
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }/*******************Alterar Cliente**************/
    public boolean alterarCliente(String comandoSQL, String dataNorm,String comando) {

        //conexão do banco de dados
        conexao = new ConectaMySql().iniciarConexao();
        try {
            SimpleDateFormat out = new SimpleDateFormat("yyyy-MM-dd");//Formato do BD
            SimpleDateFormat in = new SimpleDateFormat("dd/MM/yyyy");
            String data = out.format(in.parse(dataNorm));

            comandoSQL = comandoSQL + data + comando;

            PreparedStatement ps = conexao.prepareStatement(comandoSQL);
            if (ps.executeUpdate() != 0) {
                conexao.close(); //Fecha a conexão e libera o recurso
                return true;
            }

        } catch (ParseException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
            return false;
    }
}
