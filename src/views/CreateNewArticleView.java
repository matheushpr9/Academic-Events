package views;

import javax.swing.*;

import java.util.Arrays;
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
    private JTextField processNumberText;
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

        String[] searchOptions = {"Sim", "Não"};
        involveHumansDropBox = new JComboBox<>(searchOptions);

        titleText = new JTextField(20);
        processNumberText = new JTextField(20);
        summaryText = new JTextArea(5, 20);
        JScrollPane scrollPane = new JScrollPane(summaryText);

        uploadPdfButton = new JButton("Upload PDF");
        filePathTxt = new JTextField(20);
        filePathTxt.setEditable(false);

        JButton cancelButton = new JButton("Cancel");
        JButton nextButton = new JButton("Next");

        uploadPdfButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(CreateNewArticleView.this);

                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    String filePath = selectedFile.getAbsolutePath();
                    filePathTxt.setText(filePath);
                    JOptionPane.showMessageDialog(CreateNewArticleView.this, "Selected file:" + selectedFile.getName());
                    
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new AuthorHomePageView().setVisible(true);
            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String eventsString = eventsDropBox.getSelectedItem().toString();

                String[] eventId_x_eventName = eventsString.split(" - ");

                System.out.println(eventId_x_eventName[0]);

                Integer eventId = Integer.parseInt(eventId_x_eventName[0]);

                System.out.println(eventId);
                
                String title = titleText.getText();

                String summary = summaryText.getText();

                String keywordsString = keywordsText.getText();


                String  involveHumansString = involveHumansDropBox.getSelectedItem().toString(); 

                Boolean involveHumans =involveHumansString == "Sim" ? true:false;

                String processNumber = processNumberText.getText();

                String filePath = filePathTxt.getText();

                String subAreaString = subareasDropBox.getSelectedItem().toString();

                String[] id_x_name =  subAreaString.split(" - ");

                Integer subareaId = Integer.parseInt(id_x_name[0]);

                List<String> keywordsList = Arrays.asList(keywordsString.split(","));
                CreateNewArticleController.sendFirstForm(eventId, title, null,summary, keywordsList,involveHumans,processNumber, filePath, subareaId);
                setVisible(false);
                new CreateNewArticleViewPart2(null).setVisible(true);
            }
        });

        // Layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(12, 2));
        panel.add(new JLabel("Event:"));
        panel.add(eventsDropBox);
        panel.add(new JLabel("Theme:"));
        panel.add(themeText);
        panel.add(new JLabel("Subarea:"));
        panel.add(subareasDropBox);
        panel.add(new JLabel("keywords:"));
        panel.add(keywordsText);
        panel.add(new JLabel("Does research involve humans?"));
        panel.add(involveHumansDropBox);
        panel.add(new JLabel("Process number :"));
        panel.add(processNumberText);
        panel.add(new JLabel("Article title:"));
        panel.add(titleText);
        panel.add(new JLabel("Summary:"));
        panel.add(scrollPane);
        panel.add(new JLabel(""));
        panel.add(uploadPdfButton);
        panel.add(new JLabel("File path:"));
        panel.add(filePathTxt);   
        panel.add(cancelButton);
        panel.add(nextButton);

        add(panel);

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