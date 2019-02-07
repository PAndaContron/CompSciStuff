package general;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Annotation;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLDecoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import javax.swing.ImageIcon;

/**
 * Holds static methods which are used in multiple places.
 */
public class Utils
{
	/** Contains every capital letter in the English alphabet in order. */
	public final static char[] ALPHABET = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
	
	/**
	 * Adds each element in <b>a</b> to each element in <b>b</b> into a third array of the same size.
	 * <br>
	 * This is most useful for adding vectors to calculate positions on a {@link Board}.
	 * 
	 * @param a The first array to add.
	 * @param b The second array to add.
	 * 
	 * @return A new array where the element at each index is the sum of the element at that index in <b>a</b> and <b>b</b>.
	 * 
	 * @throws IllegalArgumentException if <b>a</b> and <b>b</b> are not the same lengths.
	 */
	public static int[] add(int[] a, int[] b)
	{
		if(a.length != b.length)
			throw new IllegalArgumentException();
		int[] c = new int[a.length];
		for(int i=0; i<c.length; i++)
			c[i] = a[i] + b[i];
		return c;
	}
	
	/**
	 * Subtracts each element in <b>b</b> from each element in <b>a</b> into a third array of the same size.
	 * <br>
	 * This is most useful for subtracting vectors to calculate positions on a {@link Board}.
	 * 
	 * @param a The array to subtract from.
	 * @param b The array to subtract.
	 * 
	 * @return A new array where the element at each index is the difference between the element at that index
	 * in <b>a</b> and <b>b</b>.
	 * 
	 * @throws IllegalArgumentException if <b>a</b> and <b>b</b> are not the same lengths.
	 */
	public static int[] subtract(int[] a, int[] b)
	{
		if(a.length != b.length)
			throw new IllegalArgumentException();
		int[] c = new int[a.length];
		for(int i=0; i<c.length; i++)
			c[i] = a[i] - b[i];
		return c;
	}

	/**
	 * Appends <b>b</b> to the end of <b>a</b>.
	 * 
	 * @param a The first array.
	 * @param b The second array.
	 * 
	 * @return A new array containing each element of <b>a</b> in order followed by each element of <b>b</b> in order.
	 */
	public static int[] append(int[] a, int[] b)
	{
		int[] c = new int[a.length+b.length];
		
		int i=0;
		for(int aI : a)
		{
			c[i] = aI;
			i++;
		}
		for(int bI : b)
		{
			c[i] = bI;
			i++;
		}
		
		return c;
	}
	
	/**
	 * Splits an array of any length into a list of arrays of length 2.
	 * 
	 * @param a The array to split.
	 * 
	 * @return A list of arrays of length 2, containing the elements of <b>a</b> in the same order.
	 * 	If <b>a</b> has an odd number of elements an extra 0 will be added to the end.
	 */
	public static List<int[]> split(int[] a)
	{
		List<int[]> out = new ArrayList<>();
		if(a.length == 0)
			return out;
		out.add(Arrays.copyOf(a, 2));
		if(a.length > 2)
			out.addAll(split(Arrays.copyOfRange(a, 2, a.length)));
		return out;
	}
	
	public static int[] join(List<int[]> list)
	{
		if(list.size() == 0)
			return new int[0];
		int[] arr = list.get(0);
		for(int i=1; i<list.size(); i++)
		{
			arr = append(arr, list.get(i));
		}
		
		return arr;
	}
	
	/**
	 * Checks if a list contains an array using {@link Arrays#equals(int[], int[])}.
	 * 
	 * @param list The list to check.
	 * @param arr The array to search for.
	 * 
	 * @return The index of the array in the list, or -1 if it was not found.
	 */
	public static int indexOfArray(List<int[]> list, int[] arr)
	{
		for(int i = 0; i < list.size(); i++)
			if(Arrays.equals(list.get(i), arr))
				return i;
		return -1;
	}
	
	public static <T> int arrayIndexOf(T[] arr, T key)
	{
		for(int i=0; i<arr.length; i++)
		{
			if(arr[i] == key)
				return i;
		}
		return -1;
	}
	
	/**
	 * Computes the average of each element of <b>a</b> and <b>b</b> into a new array of the same size.
	 * <br>
	 * If the arrays represent points, this can be used to find the midpoint between them.
	 * 
	 * @param a The first array.
	 * @param b The second array.
	 * 
	 * @return A new array where the element at each index is the average of the element at that index in <b>a</b> and <b>b</b>.
	 * 
	 * @throws IllegalArgumentException if <b>a</b> and <b>b</b> are not the same lengths.
	 */
	public static int[] average(int[] a, int[] b)
	{
		if(a.length != b.length)
			throw new IllegalArgumentException();
		int[] out = new int[a.length];
		for(int i=0; i<out.length; i++)
		{
			out[i] = (a[i]+b[i])/2;
		}
		return out;
	}
	
	/**
	 * Computes the average between each pair of consecutive arrays in <b>list</b> using {@link #average(int[], int[])}.
	 * 
	 * @param list The list of arrays.
	 * 
	 * @return A new list containing the averages between each pair of consecutive arrays in <b>list</b>.
	 * 
	 * @throws IllegalArgumentException if all of the arrays in <b>list</b> are not the same length.
	 */
	public static List<int[]> seqAverage(List<int[]> list)
	{
		List<int[]> out = new ArrayList<>();
		int[] previous = null;
		for(int[] current : list)
		{
			if(previous != null)
				out.add(average(current, previous));
			previous = current;
		}
		return out;
	}
	
	public static <T> T[][] arrayCopy2D(T[][] original)
	{
		T[][] newArray = Arrays.copyOf(original, original.length);
		for(int i=0; i<original.length; i++)
		{
			newArray[i] = Arrays.copyOf(original[i], original[i].length);
		}
		return newArray;
	}
	
	/**
	 * Converts a series of Chess coordinates into indexes for an array.
	 * <br>
	 * Chess coordinates consist of a letter representing a column number followed by the row number,
	 * where A1 is the top left corner.
	 * 
	 * @param s The String to parse.
	 * 
	 * @return An array of coordinates: {row, column, row, column,...}
	 */
	public static int[] parseCoords(String s)
	{
		String[] terms = s.toUpperCase().split("\\s+");
		int[] out = {};
		
		for(String term : terms)
		{
			out = append(out, parseCoord(term));
		}
		
		return out;
	}
	
	/**
	 * Converts a single Chess coordinate into indexes for an array.
	 * <br>
	 * Chess coordinates consist of a letter representing a column number followed by the row number,
	 * where A1 is the top left corner.
	 * 
	 * @param s The String to parse.
	 * 
	 * @return An array with the row and column the Chess coordinates represent.
	 */
	public static int[] parseCoord(String s)
	{
		int x = s.charAt(0)-65;
		int y = Integer.parseInt(s.substring(1)) - 1;
		return new int[] {y, x};
	}
	
	public static String getDateTime()
	{
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy HH.mm.ss");
		return dateFormat.format(date);
	}
	
	public static Set<Class<? extends Object>> getClassesWith(Class<? extends Annotation> annotation)
	{
		Set<Class<? extends Object>> classes = new HashSet<>();
		for(Class<? extends Object> clazz : getAllClasses())
		{
			if(clazz.isAnnotationPresent(annotation))
			{
				classes.add(clazz);
			}
		}
		return classes;
	}
	
	public static Set<Class<? extends Object>> getAllClasses()
	{
		URLClassLoader uc = (URLClassLoader) Utils.class.getClassLoader();
		URL[] urls = uc.getURLs();
		Set<Class<? extends Object>> classes = new HashSet<>();
		Set<String> packages = new HashSet<>();
		
		for(URL url : urls)
		{
			File path = null;
			try
			{
				path = new File(URLDecoder.decode(url.getPath(), "UTF-8"));
			}
			catch (UnsupportedEncodingException e)
			{
				//Should never happen but it won't compile if there's no catch statement
				e.printStackTrace();
			}
			if(path.isDirectory())
			{
				packages.addAll(getPackages(path));
			}
			else
			{
				try
				{
					classes.addAll(getClassesFromJar(path));
				}
				catch (IOException e)
				{
					//Should never happen but it won't compile if there's no catch statement
					e.printStackTrace();
				}
			}
		}
		
		for(String pack : packages)
		{
			try
			{
				classes.addAll(getClassesForPackage(pack));
			}
			catch (ClassNotFoundException e)
			{
				//Should never happen but it won't compile if there's no catch statement
				e.printStackTrace();
			}
		}
		
		return classes;
	}
	
	public static Set<Class<? extends Object>> getClassesFromJar(File jarFile) throws IOException
	{
		Set<Class<? extends Object>> classes = new HashSet<>();
		JarFile jar = new JarFile(jarFile);
		Enumeration<JarEntry> entries = jar.entries();
		while(entries.hasMoreElements())
		{
			JarEntry entry = entries.nextElement();
			String name = entry.getName();
			if(name.endsWith(".class"))
			{
				String className = name.substring(0, name.length()-6).replace('/', '.');
				try
				{
					classes.add(Utils.class.getClassLoader().loadClass(className));
				}
				catch (ClassNotFoundException e)
				{
					//Should never happen but it won't compile if there's no catch statement
					e.printStackTrace();
				}
			}
		}
		jar.close();
		return classes;
	}
	
	public static Set<String> getPackages(File dir)
	{
		return getPackages(dir, "");
	}
	
	public static Set<String> getPackages(File dir, String parent)
	{
		if(!dir.isDirectory() || !dir.exists())
			return null;
		
		Set<String> packages = new HashSet<>();
		for(File f : dir.listFiles())
		{
			if(f.isDirectory())
			{
				String name = f.getName();
				if(!parent.equals(""))
					name = parent + "." + name;
				packages.add(name);
				packages.addAll(getPackages(f, name));
			}
		}
		
		return packages;
	}
	
	public static List<Class<? extends Object>> getClassesForPackage(String packName) throws ClassNotFoundException
	{
		ArrayList<File> directories = new ArrayList<File>();
		try
		{
			ClassLoader cld = Thread.currentThread().getContextClassLoader();
			if (cld == null)
			{
				throw new ClassNotFoundException("Can't get class loader.");
			}
			String path = packName.replace('.', '/');
			Enumeration<URL> resources = cld.getResources(path);
			while (resources.hasMoreElements())
			{
				directories.add(new File(URLDecoder.decode(resources.nextElement().getPath(), "UTF-8")));
			}
		}
		catch (NullPointerException x)
		{
			throw new ClassNotFoundException(packName + " does not appear to be a valid package (Null pointer exception)");
		}
		catch (UnsupportedEncodingException encex)
		{
			throw new ClassNotFoundException(packName + " does not appear to be a valid package (Unsupported encoding)");
		}
		catch (IOException ioex)
		{
			throw new ClassNotFoundException("IOException was thrown when trying to get all resources for " + packName);
		}

		ArrayList<Class<? extends Object>> classes = new ArrayList<>();
		for (File directory : directories)
		{
			if (directory.exists())
			{
				String[] files = directory.list();
				for (String file : files)
				{
					if (file.endsWith(".class"))
					{
						try
						{
							classes.add(Class.forName(packName + '.' + file.substring(0, file.length() - 6)));
						}
						catch (NoClassDefFoundError e)
						{
							//Do nothing
						}
					}
				}
			}
		}
		return classes;
	}
	
	/**
	 * Scales an ImageIcon.
	 * 
	 * @param original The icon to scale.
	 * @param width The width to scale to.
	 * @param height The height to scale to.
	 * 
	 * @return A new ImageIcon with the specified dimensions,
	 * or the original ImageIcon if either <b>width</b> or <b>height</b> is 0.
	 */
	public static ImageIcon scale(ImageIcon original, int width, int height)
	{
		if(width * height == 0)
			return original;
		return new ImageIcon(original.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
	}
	
	public static void noOp(Object o)
	{
		
	}
}
