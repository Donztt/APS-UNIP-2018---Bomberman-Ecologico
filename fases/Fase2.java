package fases;

import game.RegrasJogo;
import mapdesign.Fundos;
import mapdesign.Lixo;
import mapdesign.Obstaculo;

public class Fase2 extends RegrasJogo{

	public Fase2() {
		adicionarBomba(3);
		adicionarArvores();
		setPersonagem(800, 500);
		adicionarlixo();
		adicionarParede();
		new Fundos(this);
	}

	public void adicionarParede() {
		
		ParedeVertical(150, 0);
		ParedeVertical(150, 150);
		ParedeVertical(150, 300);
		
		ParedeVertical(450, 0);
		ParedeVertical(450, 150);
		ParedeVertical(450, 300);
		
		ParedeVertical(750, 0);
		ParedeVertical(750, 150);
		ParedeVertical(750, 300);
		
		paredeHorizontal(150, 450);
		paredeHorizontal(300, 450);
		paredeHorizontal(450, 450);
		paredeHorizontal(600, 450);
		
		paredePequena(930, 300);
		paredePequena(960, 300);
		paredeHorizontal(0, 300);
		paredeHorizontal(750, 300);

	}

	public void adicionarlixo() {

		adicionarLixo(new Lixo(180, 250, "lixo.png", this));
		adicionarLixo(new Lixo(180, 300, "lixo.png", this));
		adicionarLixo(new Lixo(180, 350, "lixo.png", this));
		
		adicionarLixo(new Lixo(425, 250, "lixo.png", this));
		adicionarLixo(new Lixo(425, 300, "lixo.png", this));
		adicionarLixo(new Lixo(425, 350, "lixo.png", this));
		
		adicionarLixo(new Lixo(480, 250, "lixo.png", this));
		adicionarLixo(new Lixo(480, 300, "lixo.png", this));
		adicionarLixo(new Lixo(480, 350, "lixo.png", this));
		
		adicionarLixo(new Lixo(725, 250, "lixo.png", this));
		adicionarLixo(new Lixo(725, 300, "lixo.png", this));
		adicionarLixo(new Lixo(725, 350, "lixo.png", this));
		
		adicionarLixo(new Lixo(700, 30, "lixo.png",  this));
		
		adicionarLixo(new Lixo(70, 100, "banana.png",this));
		
		adicionarLixo(new Lixo(860, 170, "maça.png", this));
		adicionarLixo(new Lixo(200, 520, "maça.png", this));

	}

	public void adicionarArvores() {
		
		adicionarObstaculos(new Obstaculo(130, 380,"arvore", this));
		adicionarObstaculos(new Obstaculo(230, 380,"arvore", this));
		adicionarObstaculos(new Obstaculo(330, 380,"arvore", this));
		adicionarObstaculos(new Obstaculo(430, 380,"arvore", this));
		adicionarObstaculos(new Obstaculo(530, 380,"arvore", this));
		adicionarObstaculos(new Obstaculo(630, 380,"arvore", this));
		
		adicionarObstaculos(new Obstaculo(750, 100,"arvore", this));
		adicionarObstaculos(new Obstaculo(850, 100,"arvore", this));
		
		adicionarObstaculos(new Obstaculo(500, -100,"casa", this));
		adicionarObstaculos(new Obstaculo(200, -100,"casa", this));

	}
}
