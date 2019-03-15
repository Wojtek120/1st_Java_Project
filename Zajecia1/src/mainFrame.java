import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

@SuppressWarnings("serial")
public class mainFrame extends JFrame 
{
	private JButton button;
	private Timer timer  = new Timer();;
	

	
	
	mainFrame()
	{
		
		button = new JButton("Run");
		button.setBounds(130, 100, 200, 40);			
		add(button);
		
		Random generator = new Random(); //do generowania liczb losowych
		
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setUndecorated(true); //bez paska na gorze
		setBackground(new Color(1.0f,1.0f,1.0f,0f));

		setLayout(null);
		setAlwaysOnTop( true );
		setVisible(true);
		
		MouseListener mouseListener = new MouseListener() {
						
			@Override
			public void mouseEntered(MouseEvent e) {
				Rectangle sizeOfTheScreen = getBounds(); //wymiary ekranu
				int x = generator.nextInt(sizeOfTheScreen.width - 200 + 1);
				int y = generator.nextInt(sizeOfTheScreen.height - 40 + 1);
				button.setBounds(x, y, 200, 40);
				
				
				timer.scheduleAtFixedRate(new TimerTask() 
				{
					
					@Override
					public void run() 
					{	
							long time = this.scheduledExecutionTime();
							String nazwaString = Long.toString(time);
							
							button.setText(nazwaString);
					}
				}, 1000, 1000);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}			
			@Override
			public void mousePressed(MouseEvent e) {}			
			@Override
			public void mouseExited(MouseEvent e) {}
		};
		
		button.addMouseListener(mouseListener);
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Rectangle sizeOfTheScreen = getBounds(); //wymiary ekranu
				int x = generator.nextInt(sizeOfTheScreen.width - 100 + 1);
				int y = generator.nextInt(sizeOfTheScreen.height - 40 + 1);
				button.setBounds(x, y, 100, 40);
				
			}
		});
						
	}
	

	public static void main(String[] args) 
	{ 
		EventQueue.invokeLater(new Runnable() 
		{
			@Override
			public void run() 
			{
				new mainFrame();
			}
		});
	}

}

//Window Builder Editor