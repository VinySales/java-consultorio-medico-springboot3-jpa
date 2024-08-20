package com.hospital.janiele.views;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastrarPaciente extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField nomeField;
	private JTextField cpfField;
	private JTextField telefoneField;
	private JTextField dataNascimentoField;

	public CadastrarPaciente() {
		setTitle("Cadastrar Cliente");
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);

		JLabel nomeLabel = new JLabel("Nome:");
		nomeLabel.setBounds(10, 10, 80, 25);
		add(nomeLabel);

		nomeField = new JTextField();
		nomeField.setBounds(100, 10, 160, 25);
		add(nomeField);

		JLabel cpfLabel = new JLabel("CPF:");
		cpfLabel.setBounds(10, 40, 80, 25);
		add(cpfLabel);

		cpfField = new JTextField();
		cpfField.setBounds(100, 40, 160, 25);
		add(cpfField);

		JLabel telefoneLabel = new JLabel("Telefone:");
		telefoneLabel.setBounds(10, 70, 80, 25);
		add(telefoneLabel);

		telefoneField = new JTextField();
		telefoneField.setBounds(100, 70, 160, 25);
		add(telefoneField);

		JLabel dataNascimentoLabel = new JLabel("Data de Nascimento:");
		dataNascimentoLabel.setBounds(10, 100, 150, 25);
		add(dataNascimentoLabel);

		dataNascimentoField = new JTextField();
		dataNascimentoField.setBounds(150, 100, 110, 25);
		add(dataNascimentoField);

		JButton cadastrarButton = new JButton("Cadastrar");
		cadastrarButton.setBounds(10, 140, 120, 25);
		add(cadastrarButton);

		cadastrarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					cadastrarPaciente();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
	}

	private void cadastrarPaciente() throws Exception {
		String nome = nomeField.getText();
		String cpf = cpfField.getText();
		String telefone = telefoneField.getText();
		String dataNascimento = dataNascimentoField.getText();

		String jsonInputString = String.format(
				"{\"nome\":\"%s\", \"cpf\":\"%s\", \"telefone\":%s, \"dataNascimento\":\"%s\"}", nome, cpf, telefone,
				dataNascimento);

		URL url = new URL("http://localhost:8080/api/clientes"); // URL da API para cadastrar cliente
		HttpURLConnection http = (HttpURLConnection) url.openConnection();
		http.setRequestMethod("POST");
		http.setDoOutput(true);
		http.setRequestProperty("Content-Type", "application/json");

		try (OutputStream os = http.getOutputStream()) {
			byte[] input = jsonInputString.getBytes("utf-8");
			os.write(input, 0, input.length);
		}

		int responseCode = http.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_CREATED) {
			JOptionPane.showMessageDialog(this, "Cliente cadastrado com sucesso!");
		} else {
			JOptionPane.showMessageDialog(this, "Erro ao cadastrar cliente.");
		}
	}
}
