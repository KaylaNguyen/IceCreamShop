// IceCreamMakerApplication.java

// swing
import javax.swing.JFrame;

/** 
 * Main application to show an IceCreamFrame 
 **/
public class IceCreamMakerApplication
{
	/**
	 * pass an argument of "menu" to get the menu version
	 **/
	public static void main( String[] args )
	{
		// create a new JFrame to hold IceCreamPanel
		JFrame icFrame = new JFrame("Ice Cream Cone Maker");
		
		// set size
		icFrame.setSize( 600, 400 );

		// create an IceCreamMaker and add it
		icFrame.add( new IceCreamMaker() );
		// exit normally on closing the window
		icFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		// show frame
		icFrame.setVisible( true );
	}
}
