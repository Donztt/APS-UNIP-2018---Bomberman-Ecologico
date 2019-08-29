package mapdesign;

import java.awt.Component;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

import game.RegrasJogo;

public class Paredes {

	private ImageIcon paredeImg = new ImageIcon(getClass().getResource("bloco.png"));
	private ImageIcon explosaoParedeImg = new ImageIcon(getClass().getResource("paredeExplodindo.gif"));
	private RegrasJogo jogo;
	private JLabel paredes;
	private final int largura = paredeImg.getIconWidth();
	private final int altura = paredeImg.getIconHeight();

	public Paredes(int x, int y, RegrasJogo jogo) {

		this.jogo = jogo;
		this.paredes = new JLabel(paredeImg);
		jogo.add(paredes);
		paredes.setBounds(x, y, largura, altura);
		colocarOrdem(paredes);
	}

	public void remover() {
		jogo.removerOrdem(paredes);
		jogo.removerParedes(this);
		jogo.remove(paredes);
	}

	public void explodirParede() {
		this.paredes.setIcon(explosaoParedeImg);
		this.paredes.setSize(explosaoParedeImg.getIconWidth(), explosaoParedeImg.getIconWidth());
		Timer timer = new Timer(800, evt -> remover());
		timer.setRepeats(false);
		timer.start();
	}

	public int GetX() {
		Point p = paredes.getLocation();
		int x = (int) p.getX();
		return x;
	}

	public int GetY() {
		Point p = paredes.getLocation();
		int y = (int) p.getY();
		return y;
	}

	public Rectangle getParedeRec() {
		return new Rectangle(GetX(), GetY(), 30, 30);
	}
	
	private void colocarOrdem(Component c) {
		jogo.ordem(c,GetY());
	}
}
