package testes;

import comando.ComandosVenda;

public class TestaComandosVenda {
    public static void main(String[] args) {
        ComandosVenda venda = new ComandosVenda();
        venda.inserirBD(2,"20/10/2021",1,1);
    }
}
