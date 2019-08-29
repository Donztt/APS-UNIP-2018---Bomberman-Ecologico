package game;

import javax.swing.JLabel;
import carregando.TelaCarregamento;
import fases.Controller;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaInicial extends Janela{

	private final ImageIcon apresentacaoImg = new ImageIcon(getClass().getResource("apresentacao.jpg"));
	private final ImageIcon iniciarImg = new ImageIcon(getClass().getResource("Iniciar.jpg"));
	private final ImageIcon tutorialImg = new ImageIcon(getClass().getResource("tutorial.jpg"));
	private final ImageIcon sairImg = new ImageIcon(getClass().getResource("sair.jpg"));

	public TelaInicial() {

		Thread t = new Thread() {
			public void run() {
				adicionarMusica("TitleMusic");
				
				JButton iniciar = new JButton(iniciarImg);
				iniciar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
						Controller.AdicionarFases();
						new Controller();
						
					}
				});
				
				JButton tutorial = new JButton(tutorialImg);
				tutorial.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						new Tutorial();
						dispose();
					}
				});
				
				JButton sair = new JButton(sairImg);
				sair.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						RegrasJogo.pararMusica();
						dispose();
						System.exit(0);
					}
				});

				iniciar.setBounds(70, 530, 219, 100);
				iniciar.setOpaque(false);
				iniciar.setBorderPainted(false);
				iniciar.setContentAreaFilled(false);
				adicionar(iniciar);
				
				tutorial.setBounds(386, 530, 219, 100);
				tutorial.setOpaque(false);
				tutorial.setBorderPainted(false);
				tutorial.setContentAreaFilled(false);
				adicionar(tutorial);

				sair.setBounds(713, 530, 219, 100);
				sair.setOpaque(false);
				sair.setBorderPainted(false);
				sair.setContentAreaFilled(false);
				adicionar(sair);

				JLabel fundo = new JLabel(apresentacaoImg);
				fundo.setBounds(-5, -10, 1000, 700);
				adicionar(fundo);
			}
		};
		t.start();
	}
}
