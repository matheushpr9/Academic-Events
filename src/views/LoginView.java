package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controllers.LoginController;

public class LoginView extends JFrame {

    private JTextField campoDocumento;
    //private JPasswordField campoSenha;
    private JTextField campoSenha;

    public LoginView() {
   
        setTitle("Academic Events");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 

        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(3, 2, 10, 10));

        JLabel rotuloDocumento = new JLabel("Document:");
        campoDocumento = new JTextField();

        JLabel rotuloSenha = new JLabel("password:");
        //campoSenha = new JPasswordField();
        campoSenha = new JPasswordField();

        JButton botaoLogin = new JButton("Login");
        botaoLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginController loginController = new LoginController();
                String document = campoDocumento.getText().toString();
                String password = campoSenha.getText().toString();
                Boolean passwordIsRight = loginController.validateLogin(document , password);

                if (passwordIsRight){
                    System.out.println("The password is right!");
                }else{
                    System.out.println("The password is wrong!");
                }

            }
        });

        // Adiciona componentes ao painel
        painel.add(rotuloDocumento);
        painel.add(campoDocumento);
        painel.add(rotuloSenha);
        painel.add(campoSenha);
        painel.add(new JLabel()); // Espaço em branco para alinhar corretamente
        painel.add(botaoLogin);

        // Adiciona o painel à janela
        add(painel);

        // Torna a janela visível
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