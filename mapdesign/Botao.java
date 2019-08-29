package mapdesign;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import carregando.TelaCarregamento;
import fases.Controller;
import game.Janela;
import game.TelaInicial;

public class Botao extends JButton{
	
	private Janela jogo;
	
	public Botao(Janela jogo,String nomeBotao) {
		this.jogo = jogo;
		setBounds(713, 530, 219, 100);
		jogo.adicionar(this);
		setVisible(true);
		escolherBotao(nomeBotao);
	}
	
	private void escolherBotao(String nomeBotao) {
		if(nomeBotao == "proximo") {
			ImageIcon botaoImg = new ImageIcon(getClass().getResource("proximo.png"));
			setIcon(botaoImg);
			jogo.ordem(this, 1700);
			
			
			addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						new TelaCarregamento();
						jogo.zerar();
						Controller.proximaFase();
						new Controller();
						jogo.dispose();
					} catch (IndexOutOfBoundsException | NullPointerException ex) {
						jogo.pararMusica();
						new TelaInicial();
					}
				}
			});
			
		}
		if(nomeBotao == "recomeçar") {
				jogo.adicionarAviso(new Avisos(jogo));
				ImageIcon recomecarImg = new ImageIcon(getClass().getResource("recomecar.png"));
				setIcon(recomecarImg);
				jogo.ordem(this,1600);
				addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							new TelaCarregamento();
							jogo.zerar();
							jogo.dispose();
							new Controller();
						} catch (NullPointerException ex) {}
					}
				});
		}
	}
	
}
