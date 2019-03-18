import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;



@SuppressWarnings("serial")
public class MainFrame extends JFrame 
{
	private JButton button;	
	private Random generator;
	private Rectangle buttonBounds;
	private Rectangle sizeOfTheScreen;
	private int x;
	private int y;
	private int delay = 50;

	
	
	MainFrame()
	{
		
		button = new JButton("Run");
		button.setBounds(130, 100, 200, 40);			
		add(button);

		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setUndecorated(true); //bez paska na gorze
		setBackground(new Color(1.0f,1.0f,1.0f,0f));

		setLayout(null);
		setAlwaysOnTop( true );
		setVisible(true);
		
		
		generator = new Random(); //do generowania liczb losowych
		buttonBounds = button.getBounds();
		sizeOfTheScreen = getBounds(); //wymiary ekranu
		x = generator.nextInt(sizeOfTheScreen.width - 200 + 1);
		y = generator.nextInt(sizeOfTheScreen.height - 40 + 1);

		
		
		
		ActionListener taskPerformer = new ActionListener() {
		      public void actionPerformed(ActionEvent evt) {
		    	
					int stepX, stepY;

					stepX = (x - buttonBounds.x)/60;
					stepY = (y - buttonBounds.y)/60;
		    	  
		    	  buttonBounds.x+=stepX;
					buttonBounds.y+=stepY;
					
					System.out.println(stepX);
					
					button.setBounds(buttonBounds.x, buttonBounds.y, 200, 40);
					
		      }
		  };
		  
		  Timer timer = new Timer(delay ,taskPerformer);
		
		
		MouseListener mouseListener = new MouseListener() {
						
			@Override
			public void mouseEntered(MouseEvent e) {
				
				 buttonBounds = button.getBounds();
				 sizeOfTheScreen = getBounds(); //wymiary ekranu
				 x = generator.nextInt(sizeOfTheScreen.width - 200 + 1);
				 y = generator.nextInt(sizeOfTheScreen.height - 40 + 1);
				
				  timer.stop();
				  timer.restart();
			}
			
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(delay > 1)
					delay *= 0.5;
				timer.setDelay(delay);
					
				button.setText("I need to be faster");
					
					
				
				Timer timer2 = new Timer(1000, new ActionListener() {
						
					@Override
					public void actionPerformed(ActionEvent e) {
						button.setText("Run");							
					}
				});
					
				timer2.setRepeats(false);
				timer2.start();
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {}			
			@Override
			public void mousePressed(MouseEvent e) {}			
			@Override
			public void mouseExited(MouseEvent e) {}
		};
		
		button.addMouseListener(mouseListener);					
	}
	

	public static void main(String[] args) 
	{ 
		EventQueue.invokeLater(new Runnable() 
		{
			@Override
			public void run() 
			{
				new MainFrame();
			}
		});
	}

}

//Window Builder Editor