package views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controllers.RevisorHomePageController;
import models.classes.Article;
import java.util.List;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AuthorHomePageView extends JFrame {

    private JButton newArticleButton;
    private JTable articlesTable;
    private DefaultTableModel tableModel;

    public AuthorHomePageView() {
        
        setTitle("Homepage");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        newArticleButton = new JButton("Create new Article");
        newArticleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new CreateNewArticleView().setVisible(true);
            }
        });

        //List <Article> articles = RevisorHomePageController.getAllArticleByAuthorDocument(document);


        articlesTable = new JTable();
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Title");
        tableModel.addColumn("Keywords");
        tableModel.addColumn("File path");

        //for(Article article: articles ){
        //    tableModel.addRow(new Object[]{article.getTitle(), article.getKeywords().toString().replace("[", "").replace("]", ""), article.getPdfFile()});
        //}

     
        JScrollPane scrollPane = new JScrollPane(articlesTable);

        // Layout
        setLayout(new BorderLayout());
        add(newArticleButton, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

}