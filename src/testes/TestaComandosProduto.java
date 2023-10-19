package testes;

import comando.ComandosCliente;

public class TestaComandosProduto {
    public static void main(String[] args) {
        //ComandosProduto produto = new ComandosProduto();
        //produto.inserirBD("Martelo","Ferramentas",32.90F);

        ComandosCliente cliente = new ComandosCliente();
        //cliente.inserirBD("Felipe","54834550940","04/04/2004");
        cliente.pesquisaCliente("SELECT * from tb_cliente");
    }
}
