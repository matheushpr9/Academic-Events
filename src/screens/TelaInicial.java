package screens;
import javax.swing.*;

import java.awt.*;

public class TelaInicial {

    private JFrame frame;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                TelaInicial window = new TelaInicial();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public TelaInicial() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JButton btnCriarArtigo = new JButton("Criar Artigo");
        btnCriarArtigo.setBounds(50, 50, 150, 30);
        frame.getContentPane().add(btnCriarArtigo);
        btnCriarArtigo.addActionListener(e -> abrirTelaCriarArtigo());

        JButton btnAvaliarArtigo = new JButton("Avaliar Artigo");
        btnAvaliarArtigo.setBounds(250, 50, 150, 30);
        frame.getContentPane().add(btnAvaliarArtigo);
        btnAvaliarArtigo.addActionListener(e -> abrirTelaAvaliarArtigo());
    }

    private void abrirTelaCriarArtigo() {
        SwingUtilities.invokeLater(() -> {
            TelaCriarArtigo telaCriarArtigo = new TelaCriarArtigo();
            telaCriarArtigo.mostrarTela();
        });
    }

    private void abrirTelaAvaliarArtigo() {
        SwingUtilities.invokeLater(() -> {
            TelaAvaliarArtigo telaAvaliarArtigo = new TelaAvaliarArtigo();
            telaAvaliarArtigo.mostrarTela();
        });
    }
}
