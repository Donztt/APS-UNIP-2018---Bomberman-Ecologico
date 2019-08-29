package mapdesign;

import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import game.RegrasJogo;

public class Lixo {
	private RegrasJogo jogo;
	private final JLabel lixo;
	ImageIcon lixofoto;

	public Lixo(int x, int y, String lixoImg, RegrasJogo jogo) {
		this.jogo = jogo;
		lixofoto = new ImageIcon(getClass().getResource(lixoImg));
		this.lixo = new JLabel(lixofoto);
		lixo.setBounds(x, y, 25, 38);
		jogo.add(lixo);
		jogo.ordem(lixo, 4);
		
	}

	public void remover() {
		jogo.removerOrdem(lixo);
		jogo.removerLixo(this);
		jogo.remove(lixo);
	}
	
	private int GetX() {
		Point p = lixo.getLocation();
		int x = (int) p.getX();
		return x;
	}

	private int GetY() {
		Point p = lixo.getLocation();
		int y = (int) p.getY();
		return y;
	}
	
	public Rectangle getLixoRec() {
		return new Rectangle(GetX(), GetY(), lixofoto.getIconWidth(), lixofoto.getIconHeight());
	}

}
