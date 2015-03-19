package mapmakers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Tester 
{
	/** this main method is just to test what I've already done, hence the sloppiness
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the location of a file:");
		String string = s.next();
		File f = new File(string);
		BufferedImage  b = ImageIO.read(f);
		JFrame frame = new JFrame();
		frame.add(new PaintingTool(b, 0, 0));
		frame.setBounds(0, 0, 500, 500);
		frame.setVisible(true);
	}
}