package telas;

import painel.PainelMostrar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaLojinha extends JFrame {

    private static final long serialVersionUID = 1L;
    private Container contentPane;
    private JMenuBar mnbBarra;
    private JMenu mnArquivo, mnSobre, mnCadastro, mnMostrar;
    private JMenuItem mniCredito, mnisair, mniCliente, mniCarro, mniVendedor, mniRelatorio, mniCalculo, mniDados;

    // Construtor
    public TelaLojinha() {
        setTitle("Lojinha");
        inicializarComponentes();
        definirEventos();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void inicializarComponentes() {
        setSize(400, 400);
        contentPane = getContentPane(); //classe  que permite que outros elementos sejam add a ela como fila.

        /*******************************Criando Objetos ****************************/

        mnbBarra = new JMenuBar();
        mnArquivo = new JMenu("Arquivo");
        mnSobre = new JMenu("Sobre");
        mnMostrar = new JMenu("Exibir");
        mnCadastro = new JMenu("Cadastro");
        mniCredito = new JMenuItem("Credito");
        mnisair = new JMenuItem("Sair");
        mniCliente = new JMenuItem("Cliente");
        mniCarro = new JMenuItem("Produto");
        mniVendedor = new JMenuItem("Venda");
        mniRelatorio = new JMenuItem("Relatório");
        mniCalculo = new JMenuItem("Calculo do Valor");
        mniDados = new JMenuItem("Dados");

        /********************************Adicionando no Frame********************/
        setJMenuBar(mnbBarra);// adiciona a barra ao frame
        mnbBarra.add(mnArquivo);// adiciona um menu a barra
        mnbBarra.add(mnCadastro);
        mnbBarra.add(mnMostrar);
        mnbBarra.add(mnSobre);
        mnArquivo.add(mniCalculo);
        mnArquivo.add(mniRelatorio);
        mnArquivo.add(mnisair);//adiciona um item ao menu
        mnSobre.add(mniCredito);
        mnCadastro.add(mniCliente);
        mnCadastro.add(mniCarro);
        mnCadastro.add(mniVendedor);
        mnMostrar.add(mniDados);


    }

    private void definirEventos() {

        //saindo do programa
        mnisair.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                System.exit(0);
            }
        });

        //mostrando os creditos
        mniCredito.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                JOptionPane.showMessageDialog(null, "Autor: Renato Onofre\nAno: 2016");
				/*for (int i = 0; i < cli.size(); i++) {
				System.out.println(cli.get(i).getNomeCliente()+"\t"+ cli.get(i).getCidadeCliente()+ "\t"+cli.get(i).getEstadoCliente()+"\n");
			}*/
            }
        });

        mniCliente.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setTitle("Cadastro Cliente");
                /*CadastroCliente cadcli = new CadastroCliente();
                contentPane.removeAll();
                contentPane.add(cadcli);
                contentPane.validate();
                */

            }
        });

        mniVendedor.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setTitle("Cadastro Vendedor");
				/*CadastroVendedor cadvend = new CadastroVendedor(vend);
				contentPane.removeAll();
				contentPane.add(cadvend);
				contentPane.validate();*/
            }
        });

        mniRelatorio.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
				/*RelatorioVenda rel = new RelatorioVenda(cli,vend,car);
				contentPane.removeAll();
				contentPane.add(rel);
				contentPane.validate();*/
            }
        });
        mniDados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PainelMostrar mostrar = new PainelMostrar();
                contentPane.removeAll();
                contentPane.add(mostrar);
                contentPane.validate();
            }
        });

    }

    public static void abrir() {
        TelaLojinha frame = new TelaLojinha();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((tela.width - frame.getSize().width) / 2,
                (tela.height - frame.getSize().height) / 2);
        frame.setVisible(true);
    }
}
