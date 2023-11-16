package testes;

import comando.ComandosCliente;
import comando.ComandosProduto;

import javax.swing.*;
import java.awt.*;

public class TestaComandosProduto {
    public static void main(String[] args) {
        ComandosProduto produto = new ComandosProduto();
        //produto.inserirBD("Martelo","Ferramentas",32.90F);

        /*if (produto.alterarProduto("UPDATE tb_produto SET nome_produto = 'Chave philips', categoria_produto = 'Ferramentas' WHERE id_produto=80;")){
            JOptionPane.showMessageDialog(null,"Produto alterado com sucesso");
        }else{
            JOptionPane.showMessageDialog(null,"Produto não alterado");
        }
*/
       /* ComandosCliente cliente = new ComandosCliente();
        //cliente.inserirBD("Felipe","54834550940","04/04/2004");
        cliente.pesquisaCliente("SELECT * from tb_cliente");
    */

        produto.pesquisarProduto("SELECT * from tb_produto");
    }

}
