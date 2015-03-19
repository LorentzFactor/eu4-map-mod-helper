package mapmakers;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class ProvinceMapMaker extends MapMaker
{
	ArrayList<Pixel> addedPixels = new ArrayList<Pixel>();
	ArrayList<Province> provs = new ArrayList<Province>();
	public ProvinceMapMaker(BufferedImage input)
	{
		super(input);
	}

	@Override
	protected void processMap()
	{
		int i = 0;
		for(int y = 0; y < super.map.getHeight(); y++)
		{
			for(int x = 0; x < super.map.getWidth(); x++)
			{
				 Pixel p = new Pixel(super.map.getRGB(x, y), x, y);
				 if(!addedPixels.contains(p))
				 {
					 Province prov = new Province(i, i / 256, (i / 256)/256, i);
					 provs.add(prov);
					 expand(p, prov);
					 i++;
				 }
			}
		}
	}
	
	private boolean expand(Pixel p, Province prov)
	{
		if(addedPixels.contains(p))
		{
			return false;
		}
		
		else
		{
			addedPixels.add(p);
			if(p.isDark())
			{
				return false;
			}
			
			else
			{
				prov.addPixel(p);
				ArrayList<ArrayList<Integer>> neighbors = p.getNeighbors();
				for(ArrayList<Integer> location : neighbors)
				{
					int x = location.get(0);
					int y = location.get(1);
					expand(new Pixel(super.map.getRGB(x, y), x, y), prov);
				}
				return true;
			}
		}
	}
}
