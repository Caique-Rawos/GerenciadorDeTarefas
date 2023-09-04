package org.example.view;

import org.example.control.UsuarioControl;
import org.example.model.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Caique Rawos.
 */

public class FrmTarefas extends JFrame{

    private JLabel label1;
    private JTextField textLogin;
    private JPanel mainPanel;
    private JPasswordField textSenha;
    private JButton btnEntrar;
    private JLabel lblLogin;
    private JLabel lblSenha;

    public FrmTarefas () {
        setContentPane(mainPanel);
        setTitle("Teste");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);
        btnEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UsuarioControl uControl = new UsuarioControl();
                Usuario u = new Usuario(textLogin.getText(), new String(textSenha.getPassword()));

                if(uControl.buscarUsuario(u) > 0){
                    System.out.println("Sucesso");
                }else{
                    System.out.println("Usuario não encontrado!");
                }
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public static void main(String[] args){

        new FrmTarefas();

    }
}
