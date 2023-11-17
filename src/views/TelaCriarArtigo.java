package views;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.EventQueue;

import javax.swing.JButton;

public class TelaCriarArtigo {

    private JFrame frame;
    private JTextField textFieldTitulo;
    // Adicione outros campos necessários

    public TelaCriarArtigo() {
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
        frame.getContentPane().setLayout(null);

        JLabel lblTitulo = new JLabel("Título:");
        lblTitulo.setBounds(50, 50, 70, 20);
        frame.getContentPane().add(lblTitulo);

        textFieldTitulo = new JTextField();
        textFieldTitulo.setBounds(120, 50, 200, 20);
        frame.getContentPane().add(textFieldTitulo);
        textFieldTitulo.setColumns(10);

        // Adicione outros campos e botões conforme necessário

        JButton btnEnviarArtigo = new JButton("Enviar Artigo");
        btnEnviarArtigo.setBounds(150, 200, 150, 30);
        frame.getContentPane().add(btnEnviarArtigo);
        btnEnviarArtigo.addActionListener(e -> enviarArtigo());
    }

    private void enviarArtigo() {
        // Lógica para enviar o artigo
    }
}
