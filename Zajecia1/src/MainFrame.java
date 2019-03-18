import java.awt.EventQueue;




public class MainFrame 
{


	
	
	MainFrame()
	{
		
						
	}
	

	public static void main(String[] args) 
	{ 
		EventQueue.invokeLater(new Runnable() 
		{
			@Override
			public void run() 
			{
				new ButtonRun();
			}
		});
	}

}

//Window Builder Editor