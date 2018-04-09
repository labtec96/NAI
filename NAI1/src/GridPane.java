import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class GridPane extends JPanel
{
	Graphics2D g2d;
	int diffrence;
	String funkcja;

	public GridPane(String funkcja)
	{
		this.funkcja = funkcja;
	}

	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g2d = (Graphics2D) g.create();
		g2d.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight());
		g2d.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
		setPreferredSize(new Dimension(460, 460));
		drawlines(g2d, 20);
		drawPoints();
		g2d.dispose();
	}

	private void drawlines(Graphics2D g2d, int amount)
	{
		diffrence = getWidth() / amount;
		System.out.println(diffrence);
		for (int i = 0; i < amount; i++)
		{
			g2d.drawLine(i * diffrence, getHeight() / 2 - 10, i * diffrence, getHeight() / 2 + 10);
			g2d.drawLine(getWidth() / 2 - 10, i * diffrence, getWidth() / 2 + 10, i * diffrence);
		}
		g2d.drawLine(599, getHeight() / 2 - 10, 599, getHeight() / 2 + 10);
		g2d.drawLine(getWidth() / 2 - 10, 599, getWidth() / 2 + 10, 599);
	}

	public void drawPoints()
	{
		if (funkcja.equals("progowaUnipolarna"))
		{
			setBackground(Color.RED);
			for (Punkt punkt : Service.tabPoints)
			{
				Service.progowaUnipolarna(punkt);
				if (Service.progowaUnipolarna(punkt) == 1)
					g2d.setColor(Color.BLACK);
				else
					g2d.setColor(Color.WHITE);
				g2d.fillOval((int) ((10 + punkt.x) * diffrence), (int) ((10 - punkt.y) * diffrence), 5, 5);
			}
		}
		else if (funkcja.equals("sigmoidalnaUnipolarna"))
		{
			setBackground(Color.BLACK);
			for (Punkt punkt : Service.tabPoints)
			{
				double sigmoidalnaUnipolarna = Service.sigmoidalnaUnipolarna(punkt);
				if(sigmoidalnaUnipolarna>0 && sigmoidalnaUnipolarna<0.25)
					g2d.setColor(Color.YELLOW);
				else if (sigmoidalnaUnipolarna>=0.25 && sigmoidalnaUnipolarna<0.5)
					g2d.setColor(Color.GREEN);
				else if (sigmoidalnaUnipolarna>=0.5 && sigmoidalnaUnipolarna<0.75)
					g2d.setColor(Color.BLUE);
				else if (sigmoidalnaUnipolarna>=0.75 && sigmoidalnaUnipolarna<=1)
					g2d.setColor(Color.RED);
				g2d.fillOval((int) ((10 + punkt.x) * diffrence), (int) ((10 - punkt.y) * diffrence), 5, 5);
				 
			}
		}
	}

}
