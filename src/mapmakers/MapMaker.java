package mapmakers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class MapMaker 
{
	protected BufferedImage map;
	protected BufferedImage finishedMap;
	public MapMaker(BufferedImage input)
	{
		map = input;
	}
	
	public MapMaker(String inputLocation) throws IOException
	{
		File f = new File(inputLocation);
		map = ImageIO.read(f);
	}
	
	protected abstract void processMap();
	
	public BufferedImage getFinishedMap()
	{
		processMap();
		return finishedMap;
	}
}
