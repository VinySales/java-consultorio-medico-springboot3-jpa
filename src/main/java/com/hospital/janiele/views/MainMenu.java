package com.hospital.janiele.views;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

public class MainMenu extends JFrame {
    private static final long serialVersionUID = 1L;
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public MainMenu() {
        setTitle("Menu Principal");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        mainPanel.setBounds(0, 0, 400, 300);
        add(mainPanel);

        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(null);

        JButton pacienteButton = new JButton("Pacientes");
        pacienteButton.setBounds(150, 50, 100, 30);
        menuPanel.add(pacienteButton);

        JButton medicoButton = new JButton("Médicos");
        medicoButton.setBounds(150, 100, 100, 30);
        menuPanel.add(medicoButton);

        JButton especializacaoButton = new JButton("Especializações");
        especializacaoButton.setBounds(150, 150, 100, 30);
        menuPanel.add(especializacaoButton);

        mainPanel.add(menuPanel, "Menu");

        JPanel pacientePanel = createPanel("Pacientes");
        mainPanel.add(pacientePanel, "Pacientes");

        JPanel medicoPanel = createPanel("Médicos");
        mainPanel.add(medicoPanel, "Médicos");

        JPanel especializacaoPanel = createPanel("Especializações");
        mainPanel.add(especializacaoPanel, "Especializações");

        pacienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "Pacientes");
            }
        });

        medicoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "Médicos");
            }
        });

        especializacaoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "Especializações");
            }
        });

        cardLayout.show(mainPanel, "Menu");
    }

    private JPanel createPanel(String title) {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        JLabel label = new JLabel(title);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setBounds(150, 100, 200, 30);
        panel.add(label);

        JButton backButton = new JButton("Voltar");
        backButton.setBounds(150, 150, 100, 30);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "Menu");
            }
        });
        panel.add(backButton);

        return panel;
    }
}