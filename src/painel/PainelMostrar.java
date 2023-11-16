package painel;

import classes.Produto;
import comando.ComandosProduto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

public class PainelMostrar extends JPanel {
    private JButton jbCliente, jbProduto, jbVenda;
    private JTextArea jtaMostrar;
    private JScrollPane jspMostrar;


    public PainelMostrar() {
        setLayout(null);
        setBackground(Color.CYAN);
        iniciarComponentes();
        criarEventos();

    }

    private void iniciarComponentes() {

        jbCliente = new JButton("Cliente");
        jbProduto = new JButton("Produto");
        jbVenda = new JButton("Venda");
        jtaMostrar = new JTextArea();
        jspMostrar = new JScrollPane(jtaMostrar);

        add(jbCliente);
        add(jbProduto);
        add(jbVenda);
        add(jspMostrar);

        jbCliente.setBounds(20, 20, 100, 20);
        jbProduto.setBounds(140, 20, 100, 20);
        jbVenda.setBounds(260, 20, 100, 20);
        jspMostrar.setBounds(20, 60, 340, 250);

    }
    private void criarEventos() {

        jbProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ComandosProduto product = new ComandosProduto();
                Set<Produto> produtinhos = product.pesquisarProduto("SELECT * from tb_produto;");
                jtaMostrar.setText("   *************PRODUTO*************   ");
                for (Produto p : produtinhos) {
                    jtaMostrar.append(p.mostrarDados() + "\n");
                }
            }
        });
    }
}
