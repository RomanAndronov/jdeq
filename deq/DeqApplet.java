package deq;

/*
  By Roman Andronov
*/

import javax.swing.JApplet;
import javax.swing.SwingUtilities;

public
class DeqApplet
	extends JApplet
{
	public void
	init()
	{
		SwingUtilities.invokeLater( new Runnable()
		{
			public void
			run()
			{
				createAppletGui();
			}
		});
	}

	private void
	createAppletGui()
	{
		if ( deqpnl == null )
		{
			deqpnl = new DeqPanel( this );
		}
	}

	private DeqPanel		deqpnl = null;
}
