package fases;

import game.RegrasJogo;
import mapdesign.Fundos;
import mapdesign.Lixo;
import mapdesign.Obstaculo;

public class Fase1 extends RegrasJogo {

	public Fase1() {
			super();
			RegrasJogo.adicionarMusica("MusicaGame");
			adicionarBomba(2);
			adicionarArvores();
			setPersonagem(800, 500);
			adicionarlixos();
			adicionarParede();
			new Fundos(this);
	}

	public void adicionarParede() {
		paredeHorizontal(800, 100);
		paredeHorizontal(650, 100);
		paredeHorizontal(500, 100);
		paredeHorizontal(350, 100);
		paredeHorizontal(200, 100);
		paredeHorizontal(800, 500);
		paredeHorizontal(650, 500);
		paredeHorizontal(500, 500);
		paredeHorizontal(350, 500);
		paredeHorizontal(200, 500);
		paredeHorizontal(50, 400);
		paredeHorizontal(600, 400);
		paredePequena(570, 400);
		paredePequena(540, 400);
		paredePequena(510, 400);
		paredePequena(20, 400);
		paredePequena(-10, 400);
		ParedeVertical(200, 250);
		ParedeVertical(200, 100);
		ParedeVertical(500, 250);
		ParedeVertical(500, 100);
		ParedeVertical(750, 250);
		ParedeVertical(750, 100);
		ParedeVertical(200, 400);

	}

	public void adicionarlixos() {

		adicionarLixo(new Lixo(900, 50, "lixo.png", this));
		adicionarLixo(new Lixo(100, 100, "banana.png", this));
		adicionarLixo(new Lixo(850, 200, "maça.png", this));
		adicionarLixo(new Lixo(250, 300, "lixo.png", this));
		adicionarLixo(new Lixo(450, 300, "maça.png", this));
		adicionarLixo(new Lixo(630, 300, "banana.png", this));
		adicionarLixo(new Lixo(600, 530, "maça.png", this));

	}

	public void adicionarArvores() {
		adicionarObstaculos(new Obstaculo(800, 50, "arvore", this));
		adicionarObstaculos(new Obstaculo(850, 300, "arvore", this));
		adicionarObstaculos(new Obstaculo(750, 300, "arvore", this));
		adicionarObstaculos(new Obstaculo(500, 450, "arvore", this));
		adicionarObstaculos(new Obstaculo(250, -50, "casa", this));

	}
}
