package org.example.view;

import org.example.model.Tarefas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Caique Rawos.
 */
public class FrmTarefas extends JFrame{

    private JLabel label1;
    private JTextField textField1;

    public FrmTarefas () {
        setTitle("Teste");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public static void main(String[] args) {
        long epochSeconds = 1692586800;
        Tarefas t = new Tarefas();

        System.out.println(t.epochParaData(epochSeconds, "dd/MM/yyyy"));

        new FrmTarefas();


    }
}
