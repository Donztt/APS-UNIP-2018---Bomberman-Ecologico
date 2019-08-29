package game;

import java.awt.Component;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import carregando.TelaCarregamento;
import fases.Controller;
import mapdesign.Avisos;
import mapdesign.Botao;
import mapdesign.InterfaceJogo;
import mapdesign.Lixo;
import mapdesign.Obstaculo;
import mapdesign.Paredes;

public class RegrasJogo extends Janela {

	private Personagem bomberman;

	public RegrasJogo() {
		new InterfaceJogo(this);
		Thread t = new Thread() {
			public void run() {
				verificarLixo();				
			}
		};
		t.start();
	}

	public void ordem(Component c, int i) {
		super.ordem(c, new Integer(i));
	}

	public void removerOrdem(Component c) {
		super.removerOrdem(c);
	}

	public void add(JLabel c) {
		adicionar(c);
	}

	public void remove(JLabel c) {
		super.remover(c);
	}

	public boolean isColidindoDir() {

		for (Paredes p : parede) {

			Rectangle parede = p.getParedeRec();

			if (bomberman.getPersonagemRecDir().intersects(parede)) {
				return true;
			}
		}
		return false;
	}

	public boolean isColidindoEs() {

		for (Paredes p : parede) {

			Rectangle parede = p.getParedeRec();

			if (bomberman.getPersonagemRecEs().intersects(parede)) {
				return true;
			}
		}
		return false;
	}

	public boolean isColidindoSubir() {

		for (Paredes p : parede) {

			Rectangle parede = p.getParedeRec();

			if (bomberman.getPersonagemRecSubir().intersects(parede)) {
				return true;
			}
		}
		return false;
	}

	public boolean isColidindoDescer() {

		for (Paredes p : parede) {

			Rectangle parede = p.getParedeRec();

			if (bomberman.getPersonagemRecDescer().intersects(parede)) {
				return true;
			}
		}
		return false;
	}

	public void isBombaColidindoParede(Rectangle bombax, Rectangle bombay) {
		Runnable r = new Runnable() {
			public void run() {
				try {
					for (Paredes p : parede) {
						Rectangle paredes = p.getParedeRec();
						if (bombax.intersects(paredes) || bombay.intersects(paredes)) {
							p.explodirParede();
						}
					}
				} catch (ConcurrentModificationException ex) {
				}

			}
		};
		new Thread(r).start();
	}

	public void isPegandoLixo() {
		try {
			for (Lixo l : lixo) {

				Rectangle lixo = l.getLixoRec();

				if (bomberman.getPersonagemRec().intersects(lixo)) {
					l.remover();
				}
			}
		} catch (ConcurrentModificationException ex) {
		}
	}

	public boolean isColidindoObstaculo() {

		for (Obstaculo p : obs) {

			Rectangle obs = p.getObstaculoRec();

			if (bomberman.getPersonagemRecSubir().intersects(obs)) {
				return true;
			}
		}
		return false;
	}

	public boolean isColidindoObstaculoDesc() {

		for (Obstaculo p : obs) {

			Rectangle obs = p.getObstaculoRec();

			if (bomberman.getPersonagemRecDescer().intersects(obs)) {
				return true;
			}
		}
		return false;
	}

	public boolean isColidindoObstaculoDir() {

		for (Obstaculo p : obs) {

			Rectangle obs = p.getObstaculoRec();

			if (bomberman.getPersonagemRecDir().intersects(obs)) {
				return true;
			}
		}
		return false;
	}

	public boolean isColidindoObstaculoEs() {

		for (Obstaculo p : obs) {

			Rectangle obs = p.getObstaculoRec();

			if (bomberman.getPersonagemRecEs().intersects(obs)) {
				return true;
			}
		}
		return false;
	}

	private void verificarLixo() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		while (true) {
			if (lixo.isEmpty()) {
				new Botao(this, "proximo");
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}

	}

	public void verificarBomba() {
		if (bombas.isEmpty()) {
			new Botao(this, "recomeçar");
		}
	}

	public void removerLixo(Lixo l) {
		lixo.remove(l);
	}

	public void removerParedes(Paredes l) {
		Runnable r = new Runnable() {
			public void run() {
				parede.remove(l);

			}
		};
		new Thread(r).start();
	}

	public void paredeHorizontal(int x, int y) {
		parede.add(new Paredes(0 + x, y, this));
		parede.add(new Paredes(30 + x, y, this));
		parede.add(new Paredes(60 + x, y, this));
		parede.add(new Paredes(90 + x, y, this));
		parede.add(new Paredes(120 + x, y, this));
		parede.add(new Paredes(150 + x, y, this));

	}

	public void ParedeVertical(int x, int y) {
		parede.add(new Paredes(x, 0 + y, this));
		parede.add(new Paredes(x, 30 + y, this));
		parede.add(new Paredes(x, 60 + y, this));
		parede.add(new Paredes(x, 90 + y, this));
		parede.add(new Paredes(x, 120 + y, this));
		parede.add(new Paredes(x, 150 + y, this));
	}

	public void paredePequena(int x, int y) {
		parede.add(new Paredes(0 + x, y, this));
	}

	public void setPersonagem(int x, int y) {
		this.bomberman = new Personagem(x, y, this);
	}

	public void removerBomba(Bomba b) {
		bombas.remove(b);
	}

	public void adicionarBomba(int qtdBomba) {
		for (int i = 0; i < qtdBomba; i++) {
			bombas.add(new Bomba());
		}
	}

	public void adicionarLixo(Lixo lixos) {
		lixo.add(lixos);
	}

	public void adicionarObstaculos(Obstaculo obss) {
		obs.add(obss);
	}

}
