package fases;

import game.RegrasJogo;
import mapdesign.Fundos;
import mapdesign.Lixo;
import mapdesign.Obstaculo;

public class Fase3 extends RegrasJogo {

	public Fase3() {
		this.adicionarBomba(3);
		adicionarArvores();
		this.setPersonagem(800, 500);
		adicionarlixo();
		adicionarParede();
		new Fundos(this);

	}

	public void adicionarParede() {
		ParedeVertical(150, 400);
		ParedeVertical(150, 500);
		ParedeVertical(800, 250);
		ParedeVertical(300, 0);
		ParedeVertical(250, 250);
		ParedeVertical(250, 150);
		ParedeVertical(650, 500);
		paredeHorizontal(0, 150);
		paredeHorizontal(0, 500);
		paredeHorizontal(150, 150);
		paredeHorizontal(300, 150);
		paredeHorizontal(150, 400);
		paredeHorizontal(300, 400);
		paredeHorizontal(450, 400);
		paredeHorizontal(630, 400);
		paredeHorizontal(800, 250);
		paredeHorizontal(800, 500);
		paredeHorizontal(650, 500);
	}

	public void adicionarlixo() {
		adicionarLixo(new Lixo(50, 80, "lixo.png", this));
		adicionarLixo(new Lixo(300, 230, "banana.png", this));
		adicionarLixo(new Lixo(50, 230, "banana.png", this));
		adicionarLixo(new Lixo(50, 600, "lixo.png", this));
		adicionarLixo(new Lixo(890, 350, "maça.png", this));
		adicionarLixo(new Lixo(890, 600, "banana.png", this));
	}

	public void adicionarArvores() {
		adicionarObstaculos(new Obstaculo(800, 50, "arvore", this));
		adicionarObstaculos(new Obstaculo(150, 350, "arvore", this));
		adicionarObstaculos(new Obstaculo(0, 450, "arvore", this));
		adicionarObstaculos(new Obstaculo(100, 0, "arvore", this));

	}

}
