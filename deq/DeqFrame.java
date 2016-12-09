package deq;

/*
  By Roman Andronov
 */

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

/*
   This will execute deq as a stand-alone
   Java program.

   To execute it as a Java applet consult the
   DeqApplet class in this package
*/

public
class DeqFrame
	extends JFrame
{
	public
	DeqFrame()
	{
		super();
		setTitle( "Digi Equus" );
		setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
	}

	public static void
	main( String[] args )
	{
		SwingUtilities.invokeLater( new Runnable()
		{
			public void
			run()
			{
				DeqFrame		deqfrm = new DeqFrame();

				deqfrm.deqpnl = new DeqPanel( deqfrm );
				deqfrm.pack();
				deqfrm.setLocationRelativeTo( null );
				deqfrm.setVisible( true );
			}
		});

	}

	private DeqPanel		deqpnl = null;
}
