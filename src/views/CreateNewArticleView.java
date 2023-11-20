package views;

import javax.swing.*;

import java.util.List;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import controllers.CreateNewArticleController;

public class CreateNewArticleView extends JFrame {

    private JComboBox<String> eventsDropBox;
    private JTextField themeText;
    private JComboBox<String> subareasDropBox;
    private JTextField keywordsText;
    private JComboBox<String> involveHumansDropBox;
    private JTextField titleText;
    private JTextArea summaryText;
    private JButton uploadPdfButton;
    private JTextField filePathTxt;

    public CreateNewArticleView() {

        setTitle("Create new Article");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        List<String> events = CreateNewArticleController.listEventsToDropDown();
        System.out.println(events);
        eventsDropBox = new JComboBox<>(events.toArray(new String[0]));

        List<String> subareas = CreateNewArticleController.listSubareasToDropDown();
        subareasDropBox = new JComboBox<>(subareas.toArray(new String[0]));

        themeText = new JTextField(20);
        keywordsText = new JTextField(20);

        String[] opcoesPesquisa = {"Sim", "Não"};
        involveHumansDropBox = new JComboBox<>(opcoesPesquisa);

        titleText = new JTextField(20);
        summaryText = new JTextArea(5, 20);
        JScrollPane scrollPane = new JScrollPane(summaryText);

        uploadPdfButton = new JButton("Upload PDF");
        filePathTxt = new JTextField(20);
        filePathTxt.setEditable(false); // Para evitar a edição manual

        JButton btnCancelar = new JButton("Cancelar");
        JButton btnProximo = new JButton("Próximo");

        uploadPdfButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para fazer o upload do PDF
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(CreateNewArticleView.this);

                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    String filePath = selectedFile.getAbsolutePath();
                    filePathTxt.setText(filePath);
                    JOptionPane.showMessageDialog(CreateNewArticleView.this, "Arquivo selecionado: " + selectedFile.getName());
                    
                    // Aqui você pode adicionar a lógica para lidar com o arquivo PDF selecionado
                    // Por exemplo, você pode armazenar o caminho do arquivo, fazer o upload para um servidor, etc.
                }
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para fechar a janela
                dispose();
            }
        });

        btnProximo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para ação do botão "Próximo"
                JOptionPane.showMessageDialog(CreateNewArticleView.this, "Ação do botão Próximo aqui.");
            }
        });

        // Layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(11, 2));
        panel.add(new JLabel("Evento:"));
        panel.add(eventsDropBox);
        panel.add(new JLabel("Tema:"));
        panel.add(themeText);
        panel.add(new JLabel("Subárea:"));  // Adicionando a label para a subárea
        panel.add(subareasDropBox);
        panel.add(new JLabel("Palavras-Chave:"));
        panel.add(keywordsText);
        panel.add(new JLabel("Pesquisa envolve humanos?"));
        panel.add(involveHumansDropBox);
        panel.add(new JLabel("Título do Evento:"));
        panel.add(titleText);
        panel.add(new JLabel("Resumo:"));
        panel.add(scrollPane);
        panel.add(new JLabel(""));
        panel.add(uploadPdfButton);
        panel.add(new JLabel("Caminho do Arquivo:"));
        panel.add(filePathTxt);   
        panel.add(btnCancelar);
        panel.add(btnProximo);
        

        // Adiciona o painel ao JFrame
        add(panel);

        // Exibição da tela
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CreateNewArticleView();
            }
        });
    }
}