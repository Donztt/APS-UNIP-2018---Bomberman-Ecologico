package mapdesign;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import game.RegrasJogo;

public class MsgFinal {

	private final RegrasJogo jogo;
	private ImageIcon overImg;

	public MsgFinal(RegrasJogo jogo) {
		this.jogo = jogo;
		overImg = new ImageIcon(getClass().getResource("GameOver.gif"));
		JLabel over = new JLabel(overImg);
		over.setBounds(230,80,overImg.getIconWidth(),overImg.getIconHeight());
		over.setVisible(true);
		jogo.add(over);
		jogo.ordem(over, 2000);
	}
	
}
