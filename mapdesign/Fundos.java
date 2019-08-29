package mapdesign;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import game.RegrasJogo;

public class Fundos {
	private JLabel fundo;
	private RegrasJogo jogo;
	private ImageIcon grama = new ImageIcon(getClass().getResource("fundo2.png"));
	
	public Fundos(RegrasJogo jogo) {
		this.jogo = jogo;
		this.fundo = new JLabel(grama);
		jogo.add(fundo);
		jogo.ordem(fundo, 0);
		fundo.setBounds(-10, 0, grama.getIconWidth(), grama.getIconHeight());
	}

	public JLabel getFundo() {
		return fundo;
	}

}
