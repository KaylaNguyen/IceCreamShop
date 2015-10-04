// IceCreamMakerApplication.java

// swing
import javax.swing.JFrame;

/** 
 * Main application to show an IceCreamFrame 
 **/
public class IceCreamLineManagerApplication
{
	/**
	 * Main method
	 **/
	public static void main( String[] args )
	{
		// create a new JFrame to hold IceCreamPanel
		JFrame icFrame = new JFrame("Ice Cream Line Manager");
		// set size
		icFrame.setSize( 400, 1000 );
		// create an IceCreamMaker and add it
		icFrame.add( new IceCreamLineManager(null) );
		// exit normally on closing the window
		icFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		// show frame
		icFrame.setVisible( true );
	}
}
