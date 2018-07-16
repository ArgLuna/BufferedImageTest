import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class TimerEventListener implements ActionListener
{
	private JPanel panel;
	public TimerEventListener(Container container)
	{
		this.panel=(JPanel) container;
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		panel.repaint();
	}
}
