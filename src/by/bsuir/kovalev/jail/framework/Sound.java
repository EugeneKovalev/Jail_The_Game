package by.bsuir.kovalev.jail.framework;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
	private Clip clip;
	public Sound(String path){
		try{
		    AudioInputStream audioInputStream =
		        AudioSystem.getAudioInputStream(
		            this.getClass().getResource(path));
		    clip = AudioSystem.getClip();
		    clip.open(audioInputStream);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void start(){
		clip.start();
	}
	
}
