package views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controllers.RevisorHomePageController;
import models.classes.Article;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class RevisorHomePageView extends JFrame {

    private JButton choosePreferredAreaButton;
    private JButton listArticlesButton;
    private JTable articlesTable;
    private DefaultTableModel tableModel;

    public RevisorHomePageView() { 
        setTitle("Revisor Homepage");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        choosePreferredAreaButton = new JButton("Define Areas of Interest");
        choosePreferredAreaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(RevisorHomePageView.this, "Logic to define areas of interest.");
            }
        });

        listArticlesButton = new JButton("List Articles to Review");
        listArticlesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(RevisorHomePageView.this, "Logic for listing articles to review.");
            }
        });

        List <Article> articles = RevisorHomePageController.getAllArticle();

        articlesTable = new JTable();
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Title");
        tableModel.addColumn("Keywords");
        tableModel.addColumn("File path");
        
        for(Article article: articles ){
            tableModel.addRow(new Object[]{article.getTitle(), article.getKeywords().toString().replace("[", "").replace("]", ""), article.getPdfFile()});
        }

        articlesTable.setModel(tableModel);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(choosePreferredAreaButton, BorderLayout.NORTH);
        panel.add(listArticlesButton, BorderLayout.SOUTH);

        JScrollPane scrollPane = new JScrollPane(articlesTable);
        panel.add(scrollPane, BorderLayout.CENTER);

        add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RevisorHomePageView();
            }
        });
    }
}
