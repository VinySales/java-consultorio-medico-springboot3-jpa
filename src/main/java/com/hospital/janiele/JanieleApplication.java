package com.hospital.janiele;

import javax.swing.SwingUtilities;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hospital.janiele.views.CadastrarPaciente;
import com.hospital.janiele.views.MainMenu;

@SpringBootApplication
public class JanieleApplication implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		// Executa o formulário na Event Dispatch Thread (EDT)
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				//new CadastrarPaciente().setVisible(true);
				new MainMenu().setVisible(true);
			}
		});
	}
	
	public static void main(String[] args) {
		SpringApplication.run(JanieleApplication.class, args);
	}

}
