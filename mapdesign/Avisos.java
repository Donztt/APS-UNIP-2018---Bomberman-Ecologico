package mapdesign;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;
import game.Janela;

public class Avisos {
	
	private ImageIcon semBomba = new ImageIcon(getClass().getResource("semBomba.gif"));
	private JLabel aviso;
	private final Janela jogo;
	
	public Avisos(Janela jogo) {
		this.jogo = jogo;
		aviso = new JLabel(semBomba);
		aviso.setBounds(this.jogo.getX()/2,this.jogo.getY()/2 , semBomba.getIconWidth(), semBomba.getIconHeight());
		jogo.add(aviso);
		jogo.ordem(aviso, 2000);
		Timer timer = new Timer(6200, evt -> remover());
		timer.setRepeats(false);
		timer.start();
	}
	
	private void remover() {
		jogo.removerOrdem(aviso);
		jogo.remove(aviso);
		jogo.repaint();
	}
}
