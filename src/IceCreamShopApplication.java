//swing
import javax.swing.JFrame;

/** 
* Main application to show an IceCreamFrame 
**/
public class IceCreamShopApplication 
{
	/**
	 * Main method
	 **/
	public static void main( String[] args )
	{
		// create a new JFrame to hold IceCreamPanel
		JFrame icFrame = new JFrame("Ice cream Line");
		
		// set size
		icFrame.setSize( 1000, 1000 );

		// create an IceCreamMaker and add it
		icFrame.add( new IceCreamShop() );
		// exit normally on closing the window
		icFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		// show frame
		icFrame.setVisible( true );
	}
}
