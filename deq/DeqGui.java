package deq;

/*
  By Roman Andronov
 */

import java.awt.Insets;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.RootPaneContainer;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JCheckBox;

class DeqGui
{
	DeqGui( DeqPanel pnldeq )
	{
		pnlDeq = pnldeq;
	}

	void
	init( RootPaneContainer rpc )
	{
		GridBagConstraints	gbc = new GridBagConstraints();
		Insets			dfltInsts = gbc.insets;

		gbc.gridx = gbc.gridy = 0;
		gbc.weightx = gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = INSETS;

		rpc.getContentPane().setLayout( new GridBagLayout() );

		pnlDeq.setLayout( new GridBagLayout() );
		pnlDeq.setBorder( BorderFactory.createLineBorder( CLRGRAY ) );
		pnlDeq.setBackground( BOARD_CLR );
		rpc.getContentPane().add( pnlDeq, gbc );

		pnlDeq.pnlMain = new JPanel();
		pnlDeq.pnlMain.setBorder( BorderFactory.createLineBorder( CLRGRAY ) );
		pnlDeq.pnlMain.setLayout( new GridBagLayout() );
		pnlDeq.pnlMain.setBackground( BOARD_CLR );
		pnlDeq.add( pnlDeq.pnlMain, gbc );

		pnlDeq.pnlBoard = new JPanel();
		pnlDeq.pnlBoard.setLayout( new GridBagLayout() );
		gbc.insets = dfltInsts;
		pnlDeq.pnlMain.add( pnlDeq.pnlBoard, gbc );
		gbc.insets = INSETS;
		mkBoardPnl();

		gbc.gridy = 1;
		gbc.weighty = 0.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		pnlDeq.pnlCtrls = new JPanel();
		pnlDeq.pnlCtrls.setBorder( BorderFactory.createLineBorder( CLRGRAY ) );
		pnlDeq.pnlCtrls.setLayout( new GridBagLayout() );
		pnlDeq.add( pnlDeq.pnlCtrls, gbc );
		mkCtrlsPnl();
	}

	private void
	mkBoardPnl()
	{
		SquareView		sv = null;
		GridBagConstraints	gbc = new GridBagConstraints();

		pnlDeq.pnlBoard.setBackground( BOARD_CLR );

		pnlDeq.board =
			new Square[ DeqPanel.BOARD_SIZE ][ DeqPanel.BOARD_SIZE ];

		gbc.weightx = gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;

		for ( int r = 0; r < DeqPanel.BOARD_SIZE; r++ )
		{
			for ( int c = 0; c < DeqPanel.BOARD_SIZE; c++ )
			{
				sv = new SquareView( pnlDeq );
				pnlDeq.board[ r ][ c ] = new Square( r, c, sv );
				sv.setSquare( pnlDeq.board[ r ][ c ] );
				gbc.gridx = c;
				gbc.gridy = r;
				pnlDeq.pnlBoard.add( sv, gbc );
			}
		}
	}

	private void
	mkCtrlsPnl()
	{
		GridBagConstraints	gbc = new GridBagConstraints();

		gbc.gridx = gbc.gridy = 0;
		gbc.insets = INSETS;

		pnlDeq.pnlCtrls.setBackground( BOARD_CLR );
		
		pnlDeq.jbNewGame = new JButton( "New Game" );
		pnlDeq.jbNewGame.setMnemonic( KeyEvent.VK_N );
		pnlDeq.jbNewGame.addActionListener( pnlDeq );
		pnlDeq.pnlCtrls.add( pnlDeq.jbNewGame, gbc );

		gbc.gridx = 1;
		pnlDeq.chkbShowClues = new JCheckBox( "Show Clues" );
		pnlDeq.chkbShowClues.setBackground( BOARD_CLR );
		pnlDeq.chkbShowClues.setMnemonic( KeyEvent.VK_C );
		pnlDeq.chkbShowClues.setSelected( false );
		pnlDeq.chkbShowClues.addActionListener( pnlDeq );
		pnlDeq.pnlCtrls.add( pnlDeq.chkbShowClues, gbc );

		gbc.gridx = 2;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		pnlDeq.lblGameState = new JLabel( "Game: on" );
		pnlDeq.pnlCtrls.add( pnlDeq.lblGameState, gbc );
	}


	DeqPanel				pnlDeq;

	static final Insets			INSETS = new Insets( 5, 5, 5, 5 );

	static final Color			CLRGRAY = Color.GRAY;
	static final Color			CLRLGRAY = Color.LIGHT_GRAY;
	private final Color			BOARD_CLR = new Color( 197, 213, 203 );
}
