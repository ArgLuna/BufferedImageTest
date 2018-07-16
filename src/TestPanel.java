import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TestPanel extends JPanel
{
	protected File			backGround	= new File("back.jpg");
	protected File			body		= new File("body.png");
	// Panel's buffer.
	protected BufferedImage	bufferedCanvas;
	protected Graphics		canvasGraphics;
	// Background image's buffer
	protected BufferedImage	bufferedBackGround;
	// Object image's buffer
	protected BufferedImage	bufferedBody;
	protected int			counter		= 0;

	public TestPanel()
	{
		try
		{
			// Load images.
			bufferedBackGround = ImageIO.read(backGround);
			bufferedBody = ImageIO.read(body);
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
		// Adjust the panel's buffer.
		bufferedCanvas = new BufferedImage(bufferedBackGround.getWidth(),
				bufferedBackGround.getHeight(), BufferedImage.TYPE_INT_ARGB);
		canvasGraphics = bufferedCanvas.getGraphics();
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		// Paint the background.
		canvasGraphics.drawImage(bufferedBackGround, 0, 0, null);
		// Paint the first object.
		canvasGraphics.drawImage(bufferedBody, 0 + counter * 10,
				0 + counter * 10, null);
		// Paint the second object.
		canvasGraphics.drawImage(bufferedBody, 500 - counter * 5,
				500 - counter * 5, null);
		// Paint a white line.
		canvasGraphics.drawLine(0, 0, 500 - counter * 2, 500);
		// Flush to the panel.
		g.drawImage(bufferedCanvas, 0, 0, null);
		counter ++;
		if (counter >= 10)
		{
			counter = 0;
		}
	}
}
