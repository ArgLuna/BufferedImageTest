import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class Launcher
{
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Launcher window = new Launcher();
					window.frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Launcher()
	{
		initialize();
		// Set up a timer.
		Timer timer=new Timer(100, new TimerEventListener(frame.getContentPane()));
		timer.setRepeats(true);
		timer.start();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		TestPanel panel = new TestPanel();
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(null);
		panel.setVisible(true);
		frame.setContentPane(panel);
	}
}
