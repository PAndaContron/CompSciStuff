import java.awt.Component;
import java.awt.Dimension;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PiCalc 
{
	public static void main(String[] args) 
	{
		BigDecimal piLieb = new BigDecimal(0);
		BigDecimal piRam = new BigDecimal(0);
		BigDecimal piChud = new BigDecimal(0);
		BigDecimal piPoly = new BigDecimal(0);
		
		ArrayList<JLabel> labels = new ArrayList<>();
		
		labels.add(new JLabel("Liebniz: " + piLieb.toPlainString()));
		labels.add(new JLabel("Ramanujan: " + piRam.toPlainString()));
		labels.add(new JLabel("Chudnovsky: " + piChud.toPlainString()));
		labels.add(new JLabel("Using n-sided polygon: " + piPoly.toPlainString()));
		
		JFrame frame = new JFrame("Pi Calculator");
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		for(JLabel l : labels)
		{
			l.setAlignmentX(Component.LEFT_ALIGNMENT);
			panel.add(l);
		}
		
		panel.setPreferredSize(new Dimension(500, 100));
		
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		MathContext mc = new MathContext(50, RoundingMode.HALF_UP);
		
		BigDecimal preRam = new BigDecimal(2).multiply(new BigDecimal(Math.sqrt(2))).divide(new BigDecimal(9801), mc);
		
		for(long i=0;;i++)
		{
			piLieb = piLieb.add(new BigDecimal(4).divide(new BigDecimal(i).multiply(new BigDecimal(2)).add(new BigDecimal(1)), mc).multiply(new BigDecimal(Math.pow(-1, i))));
			labels.get(0).setText("Liebniz: " + piLieb.toPlainString());
			
			piRam = piRam.add(new BigDecimal(factorial(4*i)).multiply(new BigDecimal(1103).add(new BigDecimal(26390).multiply(new BigDecimal(i)))).divide(new BigDecimal(Math.pow(factorial(i), 4)).multiply(new BigDecimal(396).pow(4*(int)i)), mc));
			labels.get(1).setText("Ramanujan: " + new BigDecimal(1).divide(preRam.multiply(piRam), mc).toPlainString());
			
			if(i>2)
			{
				piPoly = new BigDecimal(i * Math.sin(Math.PI/i));
				labels.get(3).setText("Using n-sided polygon: " + piPoly.toPlainString());
			}
		}
	}
	
	public static long factorial(long i)
	{
		if(i==0)
			return 1;
		return i*factorial(i-1);
	}
}
