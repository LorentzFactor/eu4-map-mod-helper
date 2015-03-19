package mapmakers;

import java.awt.Color;
import java.util.ArrayList;

public class Pixel 
{
	private int red;
	private int green;
	private int blue;
	private int[] location;
	
	public Pixel(int inputRed, int inputGreen, int inputBlue, int[] inputLocation)
	{
		red = inputRed;
		green = inputGreen;
		blue = inputBlue;
		location = inputLocation;
	}
	
	public Pixel(int inputRGB, int[] inputLocation)
	{
		setRGB(inputRGB);
		location = inputLocation;
	}

	public Pixel(int inputRGB, int x, int y)
	{
		setRGB(inputRGB);
		location[0] = x;
		location[1] = y;
	}
	
	@Override
	public boolean equals(Object e)
	{
		Pixel p = (Pixel) e;
		if(p.getX() == getX() && p.getY() == getY() && p.getRGB() == getRGB())
		{
			return true;
		}
		return false;
	}
	
	public ArrayList<ArrayList<Integer>> getNeighbors()
	{
		ArrayList<ArrayList<Integer>> neighbors = new ArrayList<ArrayList<Integer>>();
		for(int x = -1; x <= 1; x++)
		{
			for(int y = -1; y <= 1; y++)
			{
				if(x != 0 || y != 0)
				{
					ArrayList<Integer> cordinate = new ArrayList<Integer>();
					cordinate.add(x);
					cordinate.add(y);
					neighbors.add(cordinate);
				}
			}
		}
		return neighbors;
	}
	
	public boolean isDark()
	{
		if(getGreyScale() < 128)
		{
			return true;
		}
		return false;
	}
	
	public int getRed() {
		return red;
	}

	public int getGreen() {
		return green;
	}

	public int getBlue() {
		return blue;
	}
	
	public int getGreyScale()
	{
		return (red + blue + green)/3;
	}
	
	public ArrayList<Integer> getRGB()
	{
		ArrayList<Integer> rgb = new ArrayList<Integer>();
		rgb.add(red);
		rgb.add(green);
		rgb.add(blue);
		return rgb;
	}
	
	public void setRGB(int input)
	{
		Color c = new Color(input);
		green = c.getGreen();
		red = c.getRed();
		blue = c.getBlue();
	}
	
	public void setGreen(int input)
	{
		green = input;
	}
	
	public void setBlue(int input)
	{
		blue = input;
	}
	
	public void setRed(int input)
	{
		red = input;
	}
	
	public void setLocation(int[] location) {
		this.location = location;
	}
	
	public int[] getLocation()
	{
		return location;
	}
	
	public void setX(int inputX)
	{
		location[0] = inputX;
	}
	
	public void setY(int inputY)
	{
		location[1] = inputY;
	}
	
	public int getX()
	{
		return location[0];
	}
	
	public int getY()
	{
		return location[1];
	}
}
