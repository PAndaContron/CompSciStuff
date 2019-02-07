package general;

import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;

/**
 * Used to get {@link ImageIcon}s from a filename without loading the image every time.
 */
public class ImageSystem 
{
	/** Holds a mapping of each filename to the {@link ImageIcon} created from that file. */
	private static Map<String, ImageIcon> map = new HashMap<>();
	
	/**
	 * If the image at <b>filename</b> has not been loaded yet, it will load it and store it in the {@link Map} for later use.
	 * If the image has already been loaded, it will be returned from the {@link Map} to save time.
	 * 
	 * @param filename The file where the image is stored in the <b>resources/images/</b> directory.
	 * 
	 * @return The image at that file.
	 * 
	 * @throws IllegalArgumentException if <b>filename</b> refers to a file outside of <b>resources/images/</b>.
	 */
	public static ImageIcon getIcon(String filename)
	{
		filename = "resources/images/"+filename;

		//Catches sneaky attempts to escape the images folder
		if(filename.contains("/../")
				|| filename.contains("\\..\\")
				|| filename.contains("/..\\")
				|| filename.contains("\\../")
				|| filename.contains(":/")
				|| filename.contains(":\\"))
			throw new IllegalArgumentException("Filename references file outside of \"resources/images/\"");
		
		//Return the already loaded image icon if there is one
		if(map.containsKey(filename))
			return map.get(filename);
		
		//If there isn't one, load it and add it to the map so it won't have to be loaded again.
		ImageIcon out = new ImageIcon(filename);
		map.put(filename, out);
		return out;
	}
}
