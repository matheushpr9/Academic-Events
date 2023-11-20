package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NovaPaginaArtigo extends JFrame {

    private JComboBox<String> comboEventos;
    private JTextField txtTema;
    private JTextField txtPalavrasChave;
    private JComboBox<String> comboPesquisaEnvolveHumanos;
    private JTextField txtTituloEvento;
    private JTextArea txtResumo;
    private JButton btnUploadPdf;

    public NovaPaginaArtigo() {
        // Configuração do JFrame
        setTitle("Criar Novo Artigo");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Inicialização dos componentes
        String[] eventos = {"Evento 1", "Evento 2", "Evento 3"}; // Substitua com seus próprios eventos
        comboEventos = new JComboBox<>(eventos);

        txtTema = new JTextField(20);
        txtPalavrasChave = new JTextField(20);

        String[] opcoesPesquisa = {"Sim", "Não"};
        comboPesquisaEnvolveHumanos = new JComboBox<>(opcoesPesquisa);

        txtTituloEvento = new JTextField(20);
        txtResumo = new JTextArea(5, 20);
        JScrollPane scrollPane = new JScrollPane(txtResumo);

        btnUploadPdf = new JButton("Upload PDF");
        btnUploadPdf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para fazer o upload do PDF
                JOptionPane.showMessageDialog(NovaPaginaArtigo.this, "Lógica para fazer o upload do PDF aqui.");
            }
        });

        // Layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 2));
        panel.add(new JLabel("Evento:"));
        panel.add(comboEventos);
        panel.add(new JLabel("Tema:"));
        panel.add(txtTema);
        panel.add(new JLabel("Palavras-Chave:"));
        panel.add(txtPalavrasChave);
        panel.add(new JLabel("Pesquisa envolve humanos?"));
        panel.add(comboPesquisaEnvolveHumanos);
        panel.add(new JLabel("Título do Evento:"));
        panel.add(txtTituloEvento);
        panel.add(new JLabel("Resumo:"));
        panel.add(scrollPane);
        panel.add(new JLabel(""));
        panel.add(btnUploadPdf);

        // Adiciona o painel ao JFrame
        add(panel);

        // Exibição da tela
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new NovaPaginaArtigo();
            }
        });
    }
}