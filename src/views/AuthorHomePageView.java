package views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AuthorHomePageView extends JFrame {

    private JButton newArticleButton;
    private JTable articleTable;
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

        tableModel = new DefaultTableModel();
        articleTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(articleTable);

        // Layout
        setLayout(new BorderLayout());
        add(newArticleButton, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AuthorHomePageView();
            }
        });
    }
}