package fases;

import game.RegrasJogo;
import mapdesign.Fundos;
import mapdesign.Lixo;
import mapdesign.Obstaculo;

public class Fase4 extends RegrasJogo {

	public Fase4() {
		adicionarBomba(5);
		adicionarArvores();
		setPersonagem(60, 100);
		adicionarlixo();
		adicionarParede();
		new Fundos(this);
	}

	public void adicionarParede() {

		paredeHorizontal(0, 230);
		paredeHorizontal(180, 230);
		paredeHorizontal(360, 230);
		paredeHorizontal(540, 230);
		paredeHorizontal(720, 230);
		paredeHorizontal(900, 230);
		paredeHorizontal(1080, 230);

		paredeHorizontal(0, 450);
		paredeHorizontal(180, 450);
		paredeHorizontal(360, 450);
		paredeHorizontal(540, 450);
		paredeHorizontal(720, 450);
		paredeHorizontal(900, 450);
		paredeHorizontal(1080, 450);

		ParedeVertical(700, 540);
		ParedeVertical(700, 720);

		ParedeVertical(280, 540);
		ParedeVertical(280, 720);

		ParedeVertical(500, 0);
		ParedeVertical(500, 180);
		ParedeVertical(500, 360);
		ParedeVertical(500, 540);
		ParedeVertical(500, 720);
	}

	public void adicionarlixo() {
		adicionarLixo(new Lixo(300, 80, "lixo.png", this));
		adicionarLixo(new Lixo(300, 110, "maça.png", this));

		adicionarLixo(new Lixo(600, 50, "banana.png", this));
		adicionarLixo(new Lixo(600, 100, "banana.png", this));

		adicionarLixo(new Lixo(600, 260, "lixo.png", this));
		adicionarLixo(new Lixo(630, 380, "lixo.png", this));
		adicionarLixo(new Lixo(690, 410, "lixo.png", this));
		adicionarLixo(new Lixo(570, 450, "lixo.png", this));
		adicionarLixo(new Lixo(650, 304, "lixo.png", this));
		adicionarLixo(new Lixo(610, 330, "lixo.png", this));
		adicionarLixo(new Lixo(900, 410, "lixo.png", this));
		adicionarLixo(new Lixo(850, 300, "lixo.png", this));
		adicionarLixo(new Lixo(730, 350, "lixo.png", this));

		adicionarLixo(new Lixo(780, 610, "lixo.png", this));
		adicionarLixo(new Lixo(180, 610, "lixo.png", this));

		adicionarLixo(new Lixo(400, 560, "lixo.png", this));
	}

	public void adicionarArvores() {

		adicionarObstaculos(new Obstaculo(380, 380, "arvore", this));
		adicionarObstaculos(new Obstaculo(310, 380, "arvore", this));
		adicionarObstaculos(new Obstaculo(250, 380, "arvore", this));

		adicionarObstaculos(new Obstaculo(640, 380, "arvore", this));
		adicionarObstaculos(new Obstaculo(500, 380, "arvore", this));

		adicionarObstaculos(new Obstaculo(380, 300, "arvore", this));
		adicionarObstaculos(new Obstaculo(380, 250, "arvore", this));
		adicionarObstaculos(new Obstaculo(380, 200, "arvore", this));
		adicionarObstaculos(new Obstaculo(380, 150, "arvore", this));

		adicionarObstaculos(new Obstaculo(500, 30, "arvore", this));
		adicionarObstaculos(new Obstaculo(500, -20, "arvore", this));
		adicionarObstaculos(new Obstaculo(500, -80, "arvore", this));

		adicionarObstaculos(new Obstaculo(60, 280, "casa", this));
		adicionarObstaculos(new Obstaculo(720, 280, "casa", this));
		adicionarObstaculos(new Obstaculo(750, -150, "casa", this));

	}

}
