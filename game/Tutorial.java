package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Tutorial extends Janela{

	private ImageIcon fundoImg = new ImageIcon(getClass().getResource("tutorial.png"));
	private ImageIcon voltarImg = new ImageIcon(getClass().getResource("voltar.png"));
	
	public Tutorial() {

		Thread t = new Thread() {
			public void run() {

				JLabel fundo = new JLabel(fundoImg);
				fundo.setBounds(0, 0,getWidth(), getHeight());
				add(fundo);
				
				JButton voltar = new JButton(voltarImg);
				voltar.setBounds(713, 530, 219, 100);
				add(voltar);
				voltar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						new TelaInicial();
						dispose();
					}
				});
			}
		};
		t.start();
	}
}
