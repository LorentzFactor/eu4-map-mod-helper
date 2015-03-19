package mapmakers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Province
{
	private int r;
	private int g;
	private int b;
	private int id;
	private ArrayList<Pixel> pixelsContained = new ArrayList<Pixel>();
	private Country c;
	private Culture cult;
	
	public Province(int inputr, int inputg, int inputb, int inputid)
	{
		r = inputr;
		g = inputg;
		b = inputb;
		id = inputid;
	}
	
	public void writeProvince(File f) throws IOException
	{
		MyWriter writer = new MyWriter(f);
		writer.write("#"+ id + " - " + c.getCode());
		writer.write(System.getProperty("line.separator"));
		writer.setEqual("owner", c.getCode());
		writer.setEqual("controller", c.getCode());
		writer.setEqual("culture", cult.getCulture());
	}
	
	public ArrayList<Pixel> getPixelsContained() {
		return pixelsContained;
	}

	public void setPixelsContained(ArrayList<Pixel> pixelsContained) {
		this.pixelsContained = pixelsContained;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Country getC() {
		return c;
	}

	public void setC(Country c) {
		this.c = c;
	}
	
	public void addPixel( Pixel p)
	{
		pixelsContained.add(p);
	}
}
