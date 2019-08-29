package mapdesign;

import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import game.RegrasJogo;

public class Obstaculo {

	private ImageIcon obsImg;
	private final RegrasJogo jogo;
	private final JLabel obstaculo;
	private final String obs;

	public Obstaculo(int x, int y,String obs, RegrasJogo jogo) {
		this.obs = obs;
		this.jogo = jogo;
		obsImg = new ImageIcon(getClass().getResource(this.obs +".png"));
		this.obstaculo = new JLabel(obsImg);
		jogo.add(obstaculo);
		controlarOrdem();
		obstaculo.setBounds(x, y, obsImg.getIconWidth(), obsImg.getIconHeight());

	}
	
	private int GetX() {
		Point p = obstaculo.getLocation();
		int x = (int) p.getX();
		return x;
	}

	private int GetY() {
		Point p = obstaculo.getLocation();
		int y = (int) p.getY();
		return y;
	}
	
	public Rectangle getObstaculoRec() {
		if(this.obs.equals("arvore")) {
			return getArvore();
		}
		if(this.obs.equals("casa")) {
			return getCasa();
		}
		else
			return null;
	}
	private Rectangle getCasa() {
		return new Rectangle(GetX(), GetY()+210, obsImg.getIconWidth(), obsImg.getIconHeight()-200);
	}
	private Rectangle getArvore() {
		return new Rectangle(GetX()+25, GetY()+100, obsImg.getIconWidth()-obsImg.getIconWidth()/2, obsImg.getIconHeight()/6+obsImg.getIconHeight()/6);
	}
	
	private void controlarOrdem() {
		if(this.obs.equals("arvore")) {
			this.jogo.ordem(obstaculo,1100);
		}
		if(this.obs.equals("casa")) {
			this.jogo.ordem(obstaculo,1200);
		}
	}
	
}
