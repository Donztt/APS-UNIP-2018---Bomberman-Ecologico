package game;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import carregando.TelaCarregamento;
import mapdesign.Avisos;
import mapdesign.Lixo;
import mapdesign.Obstaculo;
import mapdesign.Paredes;
import musicas.Musicas;

public class Janela extends JFrame {

	private JLayeredPane lp;
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private static final List<Musicas> musica = new ArrayList<>();
	public List<Lixo> lixo = new ArrayList<>();
	protected List<Paredes> parede = new ArrayList<>();
	protected List<Obstaculo> obs = new ArrayList<>();
	private List<Avisos> avs = new ArrayList<>();
	public final List<Bomba> bombas = new ArrayList<>();

	public Janela() {
		setResizable(false);
		setLayout(null);
		setUndecorated(true);
		if (!(TelaCarregamento.isPronto())) {
			setVisible(false);
		} else
			lp = getLayeredPane();
		setBounds(screenSize.width / 2 - 980 / 2, screenSize.height / 2 - 680 / 2, 980, 680);
		setVisible(true);

	}
	
	public void adicionarAviso(Avisos aviso) {
		avs.add(aviso);
	}

	public void adicionar(Component c) {
		add(c);
		repaint();
	}

//	private void ajustarJanela() {
//		addMouseListener(new MouseAdapter() {
//			public void mousePressed(MouseEvent e) {
//				setLocation(getX() + e.getX() - getWidth() / 2, getY() + e.getY() - getHeight() / 2);
//			}
//		});
//	}
	public void remover(Component c) {
		remove(c);
		repaint();
	}

	public void ordem(Component c, int i) {
		try {
		lp.add(c, new Integer(i));
		}
		catch(NullPointerException ex) {}
	}

	public void removerOrdem(Component c) {
		lp.remove(c);
	}

	protected void removerTudo() {
		lp.removeAll();
		removeAll();
		repaint();
	}

	public static void adicionarMusica(String nomeMusica) {
		if (musica.isEmpty()) {
			musica.add(new Musicas(nomeMusica));
		} else
			for (Musicas m : musica) {
				if (m.getMusica().equals(nomeMusica)) {} 
				else if (!m.getMusica().equals(nomeMusica)) {
					musica.remove(0);
					musica.add(new Musicas(nomeMusica));
				} else
					musica.add(new Musicas(nomeMusica));
			}
	}

	public static void pararMusica() {
		try {
			musica.clear();
		} catch (IndexOutOfBoundsException | NullPointerException ex) {
		}
	}

	public void zerar() {
		removeAll();
		repaint();
		avs.clear();
		lixo.clear();
		parede.clear();
		obs.clear();
		bombas.clear();
	}
}
