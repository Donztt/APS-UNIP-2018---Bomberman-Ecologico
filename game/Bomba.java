package game;

import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;
import musicas.Musicas;

public class Bomba {

	private ImageIcon bombaImg = new ImageIcon(getClass().getResource("bomba.gif"));
	private ImageIcon explosao = new ImageIcon(getClass().getResource("explosionF.gif"));
	private Musicas musica;
	private RegrasJogo jogo;
	private JLabel bomba;
	
	public void bob(int x,int y,RegrasJogo jogo) {
				colocarBomba(x, y, jogo);			
	}

	public void colocarBomba(int x, int y, RegrasJogo jogo) {
		this.jogo = jogo;
		Runnable r = new Runnable() {
		public void run() {
			bomba = new JLabel(bombaImg);
			jogo.add(bomba);
			jogo.ordem(bomba, 3);
			removerLista();
			bomba.setBounds(x, y+30, bombaImg.getIconWidth(), bombaImg.getIconHeight());
			
			Timer timer = new Timer(2000, evt -> detonar());
			timer.setRepeats(false);
			timer.start();
		
			}
		};
		new Thread(r).start();
	}

	private void detonar() {
		int larguraB = bomba.getWidth(); // Largura da bomba.
		int alturaB = bomba.getHeight(); // Altura da bomba.
		int larguraEx = explosao.getIconWidth(); // Largura da explosão.
		int alturaEx = explosao.getIconHeight(); // Altura da explosão.
		bomba.setIcon(explosao);
		bomba.setBounds((GetX() + larguraB / 2 - larguraEx / 2), (GetY() + alturaB / 2 - alturaEx / 2), larguraEx,alturaEx);
		jogo.isBombaColidindoParede(getExplosaoRecX(),getExplosaoRecY());
		this.musica = new Musicas("explosioneffect");
		Timer timer = new Timer(1200, evt -> remover());
		timer.setRepeats(false);
		timer.start();
	}

	public void remover() {
		this.musica.parar();
		jogo.removerOrdem(bomba);
		jogo.removerBomba(this);
		jogo.remove(bomba);
	}
	public void removerLista() {
		jogo.removerBomba(this);
		jogo.remove(bomba);	
	}

	private int GetX() {
		Point p = bomba.getLocation();
		int x = (int) p.getX();
		return x;
	}

	private int GetY() {
		Point p = bomba.getLocation();
		int y = (int) p.getY();
		return y;
	}

	private Rectangle getExplosaoRecX() {
		return new Rectangle(GetX(), GetY()+180, explosao.getIconWidth()-30, explosao.getIconHeight()-370);
	}

	private Rectangle getExplosaoRecY() {
		return new Rectangle(GetX()+180, GetY(), explosao.getIconWidth()-370, explosao.getIconHeight()-30);
	}

}
