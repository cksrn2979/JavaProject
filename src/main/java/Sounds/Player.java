package Sounds;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Player {
	public static void playSound(String fileName){
		String audioFile = "sounds/" + fileName+ ".wav";

		Clip clip;
		File soundFile = new File(audioFile);

		Line.Info linfo = new Line.Info(Clip.class);
		Line line;
		try {
			line = AudioSystem.getLine(linfo);
			clip = (Clip) line;
			AudioInputStream ais;
			ais = AudioSystem.getAudioInputStream(soundFile);		
			clip.open(ais);
			clip.start();
			Thread.sleep(10);
			
		} catch (LineUnavailableException | UnsupportedAudioFileException | IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
