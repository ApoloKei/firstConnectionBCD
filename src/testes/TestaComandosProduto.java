package testes;

import comando.ComandosProduto;

public class TestaComandosProduto {
    public static void main(String[] args) {
        ComandosProduto produto = new ComandosProduto();
        produto.inserirBD("Martelo","Ferramentas",32.90F);
    }
}
