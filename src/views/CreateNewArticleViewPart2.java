package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controllers.CreateNewArticleController;
import java.util.List;

public class CreateNewArticleViewPart2 extends JFrame {

    private JComboBox<String> authorsDropdown;
    private JTextField selectedAuthorsText;
    private JButton addButton;
    private JButton createArticleButton;

    public CreateNewArticleViewPart2( Integer articleId) {
    
        setTitle("Create new article");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        List<String> authors = CreateNewArticleController.listAllAuthorsToDropDown();
        authorsDropdown = new JComboBox<>(authors.toArray(new String[0]));

        selectedAuthorsText = new JTextField(20);
        selectedAuthorsText.setEditable(false);

        addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String selectedAuthor = (String) authorsDropdown.getSelectedItem();
                String[] selectedAuthorArray = selectedAuthor.split(" - ");
                String selectedAuthorCpf = selectedAuthorArray[selectedAuthorArray.length -1];
                String currentAuthors = selectedAuthorsText.getText();
                
                if (!currentAuthors.isEmpty()) {
                    currentAuthors += ", ";
                }

                currentAuthors += selectedAuthorCpf;

                selectedAuthorsText.setText(currentAuthors);
            }
        });

        createArticleButton = new JButton("Create article");
        createArticleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
                String selectedAuthors = selectedAuthorsText.getText();
                JOptionPane.showMessageDialog(CreateNewArticleViewPart2.this, "New article created with the following authors:\n" + selectedAuthors);
            }
        });

        // Layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2)); 
        panel.add(new JLabel("Authors:"));
        panel.add(authorsDropdown);
        panel.add(new JLabel("Selected Authors:"));
        panel.add(selectedAuthorsText);
        panel.add(new JLabel(""));
        panel.add(addButton);
        panel.add(new JLabel(""));
        panel.add(createArticleButton);

        add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CreateNewArticleViewPart2(null);
            }
        });
    }
}