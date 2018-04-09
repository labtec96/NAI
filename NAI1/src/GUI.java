
import javax.swing.JFrame;

import javax.swing.BoxLayout;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class GUI extends JFrame
{

	public GridPane gridPane;
	private GridPane gridPane_1;

	public GUI()
	{
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 232, 249);
		setSize(960, 550);
		getContentPane().setLayout(null);
		gridPane = new GridPane("progowaUnipolarna");
		gridPane.setBounds(10, 46, 460, 460);
		gridPane.setLayout(new BoxLayout(gridPane, BoxLayout.X_AXIS));
		getContentPane().add(gridPane);
		gridPane_1 = new GridPane("sigmoidalnaUnipolarna");
		gridPane_1.setSize(460, 460);
		gridPane_1.setLocation(484, 46);
		gridPane_1.setLayout(new BoxLayout(gridPane_1, BoxLayout.X_AXIS));
		getContentPane().add(gridPane_1);
		
		JLabel lblNewLabel = new JLabel("Funkcja progowa unipolarna");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 460, 24);
		getContentPane().add(lblNewLabel);
		
		JLabel lblFunkcjaSigmoidalnaUnipolarna = new JLabel("Funkcja sigmoidalna unipolarna");
		lblFunkcjaSigmoidalnaUnipolarna.setHorizontalAlignment(SwingConstants.CENTER);
		lblFunkcjaSigmoidalnaUnipolarna.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFunkcjaSigmoidalnaUnipolarna.setBounds(484, 11, 460, 24);
		getContentPane().add(lblFunkcjaSigmoidalnaUnipolarna);
	}
}
