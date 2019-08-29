package musicas;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

public class Musicas{
	
	private String nomeMusica;
	private Thread t;
	private Runnable r;
	private AudioClip audio;
	
	public Musicas(String musica) {
		this.nomeMusica = musica;
		r = new Runnable() {
		public void run() {
			try {
				URL url = getClass().getResource(nomeMusica + ".wav");
				audio = Applet.newAudioClip(url);
				audio.loop();
				audio.play();
				Thread.sleep(500);
			}
			catch(NullPointerException | InterruptedException ex) {}	
			
			}
		};
		t = new Thread(this.r);
		t.start();
	}
	
	public void parar() {
		this.t.interrupt();
		this.audio.stop();
	}
	
	public String getMusica() {
		return this.nomeMusica;
	}
}
