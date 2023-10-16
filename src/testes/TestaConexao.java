package testes;

import conexao.ConectaMySql;

public class TestaConexao {
    public static void main(String[] args) {
        ConectaMySql novaConexao = new ConectaMySql();
        novaConexao.iniciarConexao();
        novaConexao.close();
    }
}