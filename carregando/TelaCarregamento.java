package carregando;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import game.Janela;

public class TelaCarregamento extends Janela {

	private static boolean pronto;
	private JProgressBar barra;
	private ImageIcon fundoImg = new ImageIcon(getClass().getResource("loading.png"));

	public TelaCarregamento() {
		setAlwaysOnTop(true);
		JLabel fundo = new JLabel(fundoImg);
		fundo.setBounds(0, 0, getWidth(), getHeight());
		adicionar(fundo);
		barra = new JProgressBar();
		adicionar(barra);
		barra.setBounds(15, 580, 940, 80);
		setVisible(true);
		for (int i = 0; i <= 100; i++) {
			barra.setValue(i);
			if (i == 100) {
				pronto = true;
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
			}
		}
		dispose();
	}

	public static boolean isPronto() {

		if (pronto == true) {
			return true;
		} else {
			return false;
		}
	}

}
