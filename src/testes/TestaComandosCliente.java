package testes;

import comando.ComandosCliente;

import javax.swing.*;

public class TestaComandosCliente {
    public static void main(String[] args) {
        ComandosCliente cliente = new ComandosCliente();

        /*if (cliente.alterarCliente("UPDATE tb_cliente SET nome_cliente = 'Ricardo' , cpf_cliente = '333.111.222-44',data_nasc = '" , "04/08/2004" , "'WHERE id_cliente = 7;")){
            JOptionPane.showMessageDialog(null,"Cliente alterado com sucesso");

        }else {
            JOptionPane.showMessageDialog(null,"Cliente não alterado");
        }*/
        cliente.pesquisaCliente("SELECT * from tb_cliente");
    }
}
