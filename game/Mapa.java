package game;

public class Mapa {
	// colocar tamanho da janela aqui dentro//
	private static int[][] mapa = new int[925][585];
	// private importação imagem de fundo

	// mapa[][] = 1 // parede
	// mapa[][] = 2 // lixo
	// mapa[][] = 0// espaço livre
	public Mapa() {

		for (int i = 0; i < 925; i++) {
			for (int k = 0; k < 585; k++) {
				mapa[i][k] = 0;
			}
		}
	}

	public int[][] getMapa() {
		return mapa;
	}

	public boolean isLivre(int x, int y) {
		if (mapa[x][y] == 0) {
			return true;
		} else {
			return false;
		}
	}

}