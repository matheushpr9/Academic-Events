package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controllers.LoginController;

public class LoginView extends JFrame {

    private JTextField documentField;
    //private JPasswordField passwordField;
    private JTextField passwordField;

    public LoginView() {
   
        setTitle("Academic Events");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));

        JLabel documentLabel = new JLabel("Document:");
        documentField = new JTextField();

        JLabel passwordLabel = new JLabel("password:");
        //passwordField = new JPasswordField();
        passwordField = new JPasswordField();

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    LoginController loginController = new LoginController();
                    String document = documentField.getText().toString();
                    String password = passwordField.getText().toString();
                    Boolean passwordIsRight = loginController.validateLogin(document , password);

                    if (passwordIsRight){
                        JOptionPane.showMessageDialog(LoginView.this, "Welcome " + "a" + "!\n");
                        setVisible(false);
                        new AuthorHomePageView().setVisible(true);


                    }else{
                        JOptionPane.showMessageDialog(LoginView.this, "Password invalid!");
                    }

                }catch(Exception exc){
                    JOptionPane.showMessageDialog(LoginView.this, "Document not found on system.");
                    exc.printStackTrace();
                }
                
            }
        });

        panel.add(documentLabel);
        panel.add(documentField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel()); 
        panel.add(loginButton);

        add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginView();
            }
        });
    }
}