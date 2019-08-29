package game;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.event.KeyAdapter;

public class Personagem {

	private static final int VelP = 12;
	private final ImageIcon persoImg = new ImageIcon(getClass().getResource("personagem.gif"));
	private final ImageIcon persoImgVol = new ImageIcon(getClass().getResource("personagemVol.gif"));
	private final ImageIcon persoImgParado = new ImageIcon(getClass().getResource("personagemParado.gif"));
	private final RegrasJogo jogo;
	private JLabel player;
	private Mapa map;
	private Thread t;

	public Personagem(int x, int y, RegrasJogo jogo) {
		map = new Mapa();
		this.jogo = jogo;
		this.player = new JLabel(persoImgParado);
		jogo.add(player);
		jogo.ordem(player, 1000);
		player.setBounds(x, y, persoImg.getIconWidth(), persoImg.getIconHeight());

		Runnable r = new Runnable() {
			public void run() {
				jogo.addKeyListener(new KeyAdapter() {
					public void keyReleased(KeyEvent e) {
						parado();
					}

					public void keyTyped(KeyEvent e) {
						
						switch(e.getKeyChar()) {
						case 'w':
							if(jogo.isColidindoSubir() || jogo.isColidindoObstaculo()) {}
							else
							subir();
							break;
						case 's':
							if(jogo.isColidindoDescer()|| jogo.isColidindoObstaculoDesc()) {}
							else
							descer();
							break;
						case 'a':
							if(jogo.isColidindoEs()|| jogo.isColidindoObstaculoEs()) {}
							else
							esquerda();
							break;
						case 'd':
							if(jogo.isColidindoDir()|| jogo.isColidindoObstaculoDir()) {}
							else
							direita();
							break;
						case 'e':
							try {jogo.bombas.get(0).colocarBomba(GetX(), GetY(), jogo);}
							catch (IndexOutOfBoundsException ex) {jogo.verificarBomba();}
							break;
						}
					}
				});
			}
		};
		this.t = new Thread(r);
		this.t.start();
	}
	
	private final void parado() {
		player.setIcon(persoImgParado);
	}

	private final void subir() {
		try {
			player.setIcon(persoImg);
			if (!map.isLivre(player.getX(), player.getY() - VelP)) {
			} else {
				posicionar(0, -VelP);
			}
		} catch (ArrayIndexOutOfBoundsException ex) {
		}

	}

	private final void descer() {
		try {
			player.setIcon(persoImgVol);
			if (!map.isLivre(player.getX(), player.getY() + VelP)) {
			} else {
				posicionar(0, VelP);
			}
		} catch (ArrayIndexOutOfBoundsException ex) {
		}
	}

	private final void direita() {
		try {
			player.setIcon(persoImg);
			if (!map.isLivre(player.getX() + VelP, player.getY())) {
			} else {
				posicionar(VelP, 0);
			}
		} catch (ArrayIndexOutOfBoundsException ex) {
		}
	}

	private final void esquerda() {
		try {
			player.setIcon(persoImgVol);
			if (!map.isLivre(player.getX() - VelP, player.getY())) {
			} else {
				posicionar(-VelP, 0);
			}
		} catch (ArrayIndexOutOfBoundsException ex) {
		}
	}

	private void posicionar(int dx, int dy) {
		jogo.isPegandoLixo();
		player.setLocation(GetX() + dx, GetY() + dy);
	}

	public int GetX() {
		Point p = player.getLocation();
		int x = (int) p.getX();
		return x;
	}

	public int GetY() {
		Point p = player.getLocation();
		int y = (int) p.getY();
		return y;
	}

	public Rectangle getPersonagemRecSubir() {
		return new Rectangle(GetX() + 37, GetY() + 20, persoImg.getIconWidth() - 65, persoImg.getIconHeight() - 70);
	}

	public Rectangle getPersonagemRecDescer() {
		return new Rectangle(GetX() + 37, GetY() + 75, persoImg.getIconWidth() - 65, persoImg.getIconHeight() - 70);
	}

	public Rectangle getPersonagemRecDir() {
		return new Rectangle(GetX() + 55, GetY() + 37, persoImg.getIconWidth() - 70, persoImg.getIconHeight() - 50);
	}

	public Rectangle getPersonagemRecEs() {
		return new Rectangle(GetX(), GetY() + 37, persoImg.getIconWidth() - 70, persoImg.getIconHeight() - 50);
	}

	public Rectangle getPersonagemRec() {
		return new Rectangle(GetX() + 20, GetY() + 10, persoImg.getIconWidth() - 20, persoImg.getIconHeight() + 10);
	}

}
