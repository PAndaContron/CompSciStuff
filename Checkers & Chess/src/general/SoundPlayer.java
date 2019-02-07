package general;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Contains static methods for playing a sound synchronously or asynchronously.
 * <br>
 * Can also be instantiated to get an object to control the sound after it has started playing.
 * All sound played using an object will be played asynchronously.
 */
public class SoundPlayer {
	/** Used to control how much data is read at once by {@link playSound} */
	private final static int BUFFER_SIZE = 128000;
	
	/**
	 * Used to test features of this class.
	 * 
	 * @param args Unused
	 */
	public static void main(String[] args)
	{
		SoundPlayer audible = new SoundPlayer("music/opus.wav");
		audible.play();
		while(audible.isPlaying());
		audible.close();
	}

	/**
	 * Plays a sound synchronously, not returning until it has finished.
	 * 
	 * @param filename The location of the sound file within <b>resources/sound/</b>.
	 * 
	 * @throws IllegalArgumentException if <b>filename</b> refers to a file outside of <b>resources/sound/</b>.
	 */
	public static void playSound(String filename)
	{
		filename = "resources/sound/"+filename;

		//Catches sneaky attempts to escape the sound folder
		if(filename.contains("/../")
				|| filename.contains("\\..\\")
				|| filename.contains("/..\\")
				|| filename.contains("\\../")
				|| filename.contains(":/")
				|| filename.contains(":\\"))
			throw new IllegalArgumentException("Filename references file outside of \"resources/sound/\"");
		
		File soundFile = null;
		AudioInputStream audioStream = null;
		AudioFormat audioFormat = null;
		SourceDataLine sourceLine = null;

		String strFilename = filename;

		try
		{
			soundFile = new File(strFilename);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.exit(1);
		}

		try
		{
			audioStream = AudioSystem.getAudioInputStream(soundFile);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.exit(1);
		}

		audioFormat = audioStream.getFormat();

		DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
		try
		{
			sourceLine = (SourceDataLine) AudioSystem.getLine(info);
			sourceLine.open(audioFormat);
		}
		catch (LineUnavailableException e)
		{
			e.printStackTrace();
			System.exit(1);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.exit(1);
		}

		sourceLine.start();

		int nBytesRead = 0;
		byte[] abData = new byte[BUFFER_SIZE];
		while (nBytesRead != -1)
		{
			try
			{
				nBytesRead = audioStream.read(abData, 0, abData.length);
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			if (nBytesRead >= 0)
			{
				@SuppressWarnings("unused")
				int nBytesWritten = sourceLine.write(abData, 0, nBytesRead);
			}
		}

		sourceLine.drain();
		sourceLine.close();
	}
	
	/**
	 * Plays a sound asynchronously, returning as soon as it has been loaded.
	 * This means that the program can end before the sound is finished, in which case the sound will stop playing.
	 * 
	 * @param filename The location of the sound file within <b>resources/sound/</b>.
	 * 
	 * @throws IllegalArgumentException if <b>filename</b> refers to a file outside of <b>resources/sound/</b>.
	 */
	public static void playSoundAsync(String filename)
	{
		filename = "resources/sound/"+filename;

		//Catches sneaky attempts to escape the sound folder
		if(filename.contains("/../")
				|| filename.contains("\\..\\")
				|| filename.contains("/..\\")
				|| filename.contains("\\../")
				|| filename.contains(":/")
				|| filename.contains(":\\"))
			throw new IllegalArgumentException("Filename references file outside of \"resources/sound/\"");
		
		File audioFile = new File(filename);
		 
        try
        {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            Clip audioClip = (Clip) AudioSystem.getLine(info);
            audioClip.open(audioStream);
            audioClip.start();
        }
        catch (UnsupportedAudioFileException ex)
        {
            System.out.println("The specified audio file is not supported.");
            ex.printStackTrace();
        }
        catch (LineUnavailableException ex)
        {
            System.out.println("Audio line for playing back is unavailable.");
            ex.printStackTrace();
        }
        catch (IOException ex)
        {
            System.out.println("Error playing the audio file.");
            ex.printStackTrace();
        }
        
        System.out.println("Method finished");
	}
	
	/** The location of the sound file within <b>resources/sound/</b>. */
	private String filename;
	/** The Clip currently being played. */
	private Clip clip;
	/** The AudioInputStream the clip is being played from. */
	private AudioInputStream audioStream;
	
	/**
	 * Creates a new SoundPlayer.
	 * 
	 * @param fileName The location of the sound file within <b>resources/sound/</b>.
	 * 
	 * @throws IllegalArgumentException if <b>fileName</b> refers to a file outside of <b>resources/sound/</b>.
	 */
	public SoundPlayer(String fileName)
	{
		setFileName(fileName);
	}
	
	/**
	 * Opens the music file at <b>newFileName</b> and prepares it for playing.
	 * 
	 * @param newFileName The location of the sound file within <b>resources/sound/</b>.
	 * 
	 * @return true if the file was successfully opened, false if there was an error.
	 * 
	 * @throws IllegalArgumentException if <b>newFileName</b> refers to a file outside of <b>resources/sound/</b>.
	 */
	public boolean setFileName(String newFileName)
	{
		if(clip != null && isOpen())
			clip.close();
		filename = "resources/sound/"+newFileName;

		//Catches sneaky attempts to escape the sound folder
		if(filename.contains("/../")
				|| filename.contains("\\..\\")
				|| filename.contains("/..\\")
				|| filename.contains("\\../")
				|| filename.contains(":/")
				|| filename.contains(":\\"))
			throw new IllegalArgumentException("Filename references file outside of \"resources/sound/\"");
		
		try
		{
			File audioFile = new File(filename);
            audioStream = AudioSystem.getAudioInputStream(audioFile);
            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            clip = (Clip) AudioSystem.getLine(info);
            open();
		}
		catch(Exception e)
		{
			return false;
		}
		return true;
	}
	
	/**
	 * Tells whether or not the {@link Clip} is open. As long as {@link #close()} has not been called, this should return true.
	 * 
	 * @return whether or not the {@link Clip} is open.
	 */
	public boolean isOpen()
	{
		return clip.isOpen();
	}
	
	/**
	 * Opens the {@link Clip} so that it can be played.
	 * This should already be done by the constructor and {@link #setFileName(String)}, so this should only be used if {@link #close()} has been called.
	 */
	public void open()
	{
		try
		{
			clip.open(audioStream);
		}
		catch (LineUnavailableException | IOException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Closes the {@link Clip}, freeing up memory.
	 * This should be called when this object is no longer needed to prevent a memory leak.
	 */
	public void close()
	{
		clip.close();
	}
	
	/**
	 * Gets whether or not this object is currently playing sound.
	 * 
	 * @return whether or not this object is playing.
	 */
	public boolean isPlaying()
	{
		return clip.isActive();
	}
	
	/**
	 * Plays this sound a single time.
	 */
	public void play()
	{
		play(1);
	}
	
	/**
	 * Plays this sound multiple times.
	 * 
	 * @param times The number of times to play this sound.
	 */
	public void play(int times)
	{
		clip.loop(times-1);
		while(!isPlaying());
	}
	
	/**
	 * Loops this sound indefinitely.
	 */
	public void loop()
	{
		clip.loop(Clip.LOOP_CONTINUOUSLY);
		while(!isPlaying());
	}
	
	/**
	 * Temporarily pauses the sound playback, keeping it at the same position for when it is played again.
	 */
	public void pause()
	{
		clip.stop();
	}
	
	/**
	 * Stops the sound playback and resets it to the beginning.
	 */
	public void stop()
	{
		pause();
		clip.setMicrosecondPosition(0);
	}
}
