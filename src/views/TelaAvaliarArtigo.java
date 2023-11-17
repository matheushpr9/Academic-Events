package views;
import javax.swing.*;
import java.awt.*;

public class TelaAvaliarArtigo {

    private JFrame frame;
    private JTextArea textAreaListaArtigos;

    public TelaAvaliarArtigo() {
        initialize();
    }

    public void mostrarTela() {
        EventQueue.invokeLater(() -> {
            try {
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        JLabel lblListaArtigos = new JLabel("Lista de Artigos:");
        frame.getContentPane().add(lblListaArtigos, BorderLayout.NORTH);

        textAreaListaArtigos = new JTextArea();
        textAreaListaArtigos.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textAreaListaArtigos);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        JButton btnAvaliarArtigo = new JButton("Avaliar Artigo");
        btnAvaliarArtigo.addActionListener(e -> avaliarArtigo());
        frame.getContentPane().add(btnAvaliarArtigo, BorderLayout.SOUTH);

        // Adicione lógica para carregar a lista de artigos a serem avaliados
        carregarListaArtigos();
    }

    private void carregarListaArtigos() {
        // Adicione lógica para carregar a lista de artigos do banco de dados
        // Exemplo de preenchimento fictício:
        textAreaListaArtigos.append("1. Título do Artigo 1\n");
        textAreaListaArtigos.append("2. Título do Artigo 2\n");
        // ...
    }

    private void avaliarArtigo() {
        // Lógica para abrir tela de avaliação detalhada do artigo selecionado
        String artigoSelecionado = JOptionPane.showInputDialog(frame, "Digite o número do artigo que deseja avaliar:");
        if (artigoSelecionado != null && !artigoSelecionado.isEmpty()) {
            int numeroArtigo = Integer.parseInt(artigoSelecionado);
            abrirTelaAvaliacaoDetalhada(numeroArtigo);
        }
    }

    private void abrirTelaAvaliacaoDetalhada(int numeroArtigo) {
        // Adicione lógica para abrir a tela de avaliação detalhada
        // Exemplo:
        JOptionPane.showMessageDialog(frame, "Abrir tela de avaliação detalhada para o artigo " + numeroArtigo);
    }
}
