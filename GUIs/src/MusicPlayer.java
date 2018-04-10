import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MusicPlayer 
{

	public static void main(String[] args) throws FileNotFoundException
	{
		File[] songs = new File("C:/Users/120rpatel/Music").listFiles();
		Random rng = new Random();
		rng.setSeed(System.currentTimeMillis());
		MediaPlayer song = new MediaPlayer(new Media(songs[rng.nextInt(songs.length)].toURI().toString()));
		song.play();
	}

}
