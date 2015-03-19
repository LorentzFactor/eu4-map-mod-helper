package mapmakers;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PaintingTool extends JPanel implements MouseListener
{
	private BufferedImage image;  
    int x, y;
    boolean pressedDown = false;
    public PaintingTool(BufferedImage image, int x, int y) {  
        super();  
        this.image = image;  
        this.x = x;  
        this.y = y; 
        setVisible(true);
    }  
    
    @Override  
    protected void paintComponent(Graphics g) {  
        super.paintComponent(g);  
        g.drawImage(image, x, y, null);  
        setVisible(true);
    }  
    
    public static void saveImage(BufferedImage img, String ref) {  
        try {  
            String format = (ref.endsWith(".png")) ? "png" : "jpg";  
            ImageIO.write(img, format, new File(ref));  
        } catch (IOException e) {  
            e.printStackTrace();  
        }
    }

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) 
	{
		// TODO Auto-generated method stub
		pressedDown = true;
		while(pressedDown == true)
		{
			image.setRGB(arg0.getX(), arg0.getY(), Color.BLACK.getRGB());
			paintComponent(image.getGraphics());
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) 
	{
		// TODO Auto-generated method stub
		pressedDown = false;
	}
}
