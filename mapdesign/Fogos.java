package mapdesign;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

import fases.GameOver;
import game.RegrasJogo;

public class Fogos {

	private ImageIcon obsImg;
	private final RegrasJogo jogo;
	private final JLabel fogos;
	private final int z;

	public Fogos(int x, int y, int z, RegrasJogo jogo) {
		this.z = z;
		this.jogo = jogo;
		obsImg = new ImageIcon(getClass().getResource("fogos" + this.z + ".gif"));
		this.fogos = new JLabel(obsImg);
		jogo.add(fogos);
		jogo.ordem(fogos, 1500);
		fogos.setBounds(x-obsImg.getIconWidth(), y-obsImg.getIconHeight(), obsImg.getIconWidth(), obsImg.getIconHeight());
		Timer timer = new Timer(3100, evt -> remover());
		timer.setRepeats(false);
		timer.start();
	}
	
	private void remover() {
		GameOver.limparFogos(this);
		jogo.removerOrdem(fogos);
		jogo.remove(fogos);
	}
	
}
