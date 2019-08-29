package mapdesign;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import game.Janela;

public class InterfaceJogo {

	private final JLabel lixoImg = new JLabel(new ImageIcon(getClass().getResource("/mapdesign/banana.png")));
	private final JLabel bombaImg = new JLabel(new ImageIcon(getClass().getResource("/game/bomba.gif")));
	private final JLabel painelImg = new JLabel(new ImageIcon(getClass().getResource("painel.png")));
	private ImageIcon sairImg = new ImageIcon(getClass().getResource("x.png"));
	private JTextField bombat;
	private JTextField lixot;

	
	private final Janela jogo;

	public InterfaceJogo(Janela jogo) {
		this.jogo = jogo;
		Thread t = new Thread() {
			public void run() {
				contadorBombas();
				contadorLixo();
				botaoFechar();

				while (true) {
					bombat.setText("" + jogo.bombas.size());
					lixot.setText("" + jogo.lixo.size());
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
					}
				}
			}
		};
		t.start();
	}
	
	private void contadorBombas() {
		bombat = new JTextField();
		bombaImg.setBounds(0, 0, 50, 50);
		jogo.ordem(bombaImg, 3000);
		painelImg.setBounds(0, 0, 241, 80);
		jogo.ordem(painelImg, 2999);
		bombat.setEditable(false);
		bombat.setBounds(50, 0, 50, 50);
		bombat.setVisible(true);
		bombat.setFocusable(false);
		bombat.setFont(new Font("arial", Font.BOLD, 32));
		bombat.setOpaque(false);
		bombat.setBorder(null);
		jogo.adicionar(bombat);
		jogo.ordem(bombat, 3000);
		
	}
	
	private void contadorLixo() {
		lixot = new JTextField();
		lixoImg.setBounds(100, 0, 50, 50);
		jogo.ordem(lixoImg, 3000);
		lixot.setEditable(false);
		lixot.setBounds(150, 0, 50, 50);
		lixot.setVisible(true);
		lixot.setFocusable(false);
		lixot.setFont(new Font("arial", Font.BOLD, 32));
		lixot.setOpaque(false);
		lixot.setBorder(null);
		jogo.adicionar(lixot);
		jogo.ordem(lixot, 3000);
		
	}
	
	private void botaoFechar() {
		JButton sair = new JButton(sairImg);
		jogo.ordem(sair, 3000);
		sair.setBorderPainted(false);
		sair.setContentAreaFilled(false);
		sair.setBounds(930, 0, sairImg.getIconWidth(), sairImg.getIconHeight());
		sair.setFocusable(false);
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jogo.dispose();
				System.exit(0);
				jogo.pararMusica();
			}
		});
		
	}
}
