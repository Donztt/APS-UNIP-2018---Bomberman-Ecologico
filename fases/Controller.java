package fases;

import java.util.ArrayList;

import carregando.TelaCarregamento;
import game.RegrasJogo;

public class Controller {

	private static ArrayList<Integer> fases = new ArrayList<>();

	public Controller() {
		Thread t = new Thread() {
			public void run() {
				new TelaCarregamento();
				try {
					if (fases.get(0) == 1) {
						new Fase1();
					} else if (fases.get(0) == 2) {
						new Fase2();
					} else if (fases.get(0) == 3) {
						new Fase3();
					} else if (fases.get(0) == 4) {
						new Fase4();
					}

				} catch (IndexOutOfBoundsException ex) {new GameOver();}
			}
		};
		t.start();
	}

	public static void AdicionarFases() {
		fases.add(1);
		fases.add(2);
		fases.add(3);
		fases.add(4);
	}

	public static void proximaFase() {
		fases.remove(0);
	}
	
	public static boolean v() {
		if(fases.isEmpty()) {
			return true;
		}
		else
			return false;
	}
	
}
