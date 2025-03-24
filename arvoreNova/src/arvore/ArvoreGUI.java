
package arvore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ArvoreGUI extends JFrame {

    private JTextField campoValor;
    private JTextArea areaSaida;
    private BArvore arvore;
    private PainelArvore painelArvore;

    public ArvoreGUI() {
        super("Gerenciador de Árvore Binária");
        arvore = new BArvore();

        campoValor = new JTextField(10);
        areaSaida = new JTextArea(5, 30);
        areaSaida.setEditable(false);

        JButton botaoInserir = new JButton("Inserir");
        JButton botaoBuscar = new JButton("Buscar");
        JButton botaoRemover = new JButton("Excluir");

        botaoInserir.addActionListener(e -> inserirValor());
        botaoBuscar.addActionListener(e -> buscarValor());
        botaoRemover.addActionListener(e -> excluirValor());

        JPanel painelEntrada = new JPanel();
        painelEntrada.add(new JLabel("Valor:"));
        painelEntrada.add(campoValor);
        painelEntrada.add(botaoInserir);
        painelEntrada.add(botaoBuscar);
        painelEntrada.add(botaoRemover);

        painelArvore = new PainelArvore(arvore.getRaiz());

        setLayout(new BorderLayout());
        add(painelEntrada, BorderLayout.NORTH);
        add(new JScrollPane(areaSaida), BorderLayout.SOUTH);
        add(painelArvore, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void inserirValor() {
        try {
            int valor = Integer.parseInt(campoValor.getText());
            if (arvore.buscar(valor)) {
                areaSaida.setText("Valor já existe na árvore!");
            } else {
                arvore.inserirNo(valor);
                areaSaida.setText("Valor inserido com sucesso!");
                painelArvore.atualizarRaiz(arvore.getRaiz());
            }
        } catch (NumberFormatException ex) {
            areaSaida.setText("Digite um número válido.");
        }
    }

    private void buscarValor() {
        try {
            int valor = Integer.parseInt(campoValor.getText());
            if (arvore.buscar(valor)) {
                areaSaida.setText("Valor encontrado!");
            } else {
                areaSaida.setText("Valor não encontrado.");
            }
        } catch (NumberFormatException ex) {
            areaSaida.setText("Digite um número válido.");
        }
    }

    private void excluirValor() {
        try {
            int valor = Integer.parseInt(campoValor.getText());
            if (arvore.buscar(valor)) {
                arvore.excluirNo(valor);
                areaSaida.setText("Valor removido com sucesso.");
                painelArvore.atualizarRaiz(arvore.getRaiz());
            } else {
                areaSaida.setText("Valor não encontrado para remoção.");
            }
        } catch (NumberFormatException ex) {
            areaSaida.setText("Digite um número válido.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ArvoreGUI());
    }
}
