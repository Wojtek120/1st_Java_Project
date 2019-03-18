import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class ButtonRun extends JFrame {
	
	private JButton button = new JButton("Run");	
	private Rectangle buttonBounds;
	private Rectangle sizeOfTheScreen;
	private int x, y;
	private int delay = 50;
	Timer timer;
	
	public ButtonRun() {
		setScreenSettings();
		
		button.setBounds(130, 100, 200, 40);			
		add(button);
		
		
		getNewButtonCoordinates();		
		setTimerTasks();
		setMouseListener();		
	}
	
	
	private void setScreenSettings() {
		
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setUndecorated(true);
		setBackground(new Color(1.0f,1.0f,1.0f,0f));
		setLayout(null);
		setAlwaysOnTop( true );
		setVisible(true);
	}
	
	
	private void getNewButtonCoordinates() {
		
		Random generator = new Random();
		buttonBounds = button.getBounds();
		sizeOfTheScreen = getBounds();
		x = generator.nextInt(sizeOfTheScreen.width - 200 + 1);
		y = generator.nextInt(sizeOfTheScreen.height - 40 + 1);
	}
	
	
	private void setTimerTasks() {
		
		timer = new Timer(delay , new ActionListener() {
		      public void actionPerformed(ActionEvent evt) {
		    	
					int stepX, stepY;

					stepX = (x - buttonBounds.x)/60;
					stepY = (y - buttonBounds.y)/60;
		    	  
					buttonBounds.x+=stepX;
					buttonBounds.y+=stepY;
					
					button.setBounds(buttonBounds.x, buttonBounds.y, 200, 40);
					
		      }
		  });
		
	}
	
	
	private void setMouseListener() {
		MouseListener mouseListener = new MouseListener() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				getNewButtonCoordinates();
				
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

}
