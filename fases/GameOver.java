package fases;

import java.util.ArrayList;
import java.util.List;
import game.RegrasJogo;
import mapdesign.Fogos;
import mapdesign.Fundos;
import mapdesign.MsgFinal;
import java.util.Random;

public class GameOver extends RegrasJogo {

	private static List<Fogos> avs = new ArrayList<>();
	private Random rnd = new Random();

	public GameOver() {
		adicionarMusica("victory");
		adicionarBomba(99);
		setPersonagem(500, 350);
		new Fundos(this);
		new MsgFinal(this);

		Thread t = new Thread() {
			public void run() {
				dispararFogos();
			}
		};
		t.start();

	}

	private void dispararFogos() {
		while (true) {
			avs.add(new Fogos(rnd.nextInt(1000), rnd.nextInt(700), rnd.nextInt(4), this));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}

	public static void limparFogos(Fogos fogos) {
		avs.remove(fogos);
	}
}
