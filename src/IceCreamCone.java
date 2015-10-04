/**
* IceCreamCone class maintains a stack of ice cream scoop flavors
**/

// awt
import java.awt.Color;
import java.awt.Graphics;

// swing
import javax.swing.JComponent;

/**
 * IceCreamCone is a GUI element that draws an ice cream cone.
 **/
public class IceCreamCone extends JComponent
{
	// class properties
	public static final String[] FLAVORS = {"vanilla", "strawberry", "chocolate", "cherry"};
	public static final Color[] PAINT_COLORS = {Color.WHITE, Color.PINK, new Color( 102, 51, 0 ), Color.RED };
	public static final int CONE_WIDTH = 40;
	public static final int CONE_HEIGHT = 70;	
	public static final int SCOOP_DIAMETER = 60;	
	public static final int SCOOP_OVERLAP = 10;	
	private StackLL<String> mainStack;	// a stack to determine all the scoops to display

	// instance properties
	private int flavorIndex; // value must be -1 to indicate no scoop or in [0,FLAVORS.length)
	private int scoopNum;	// number of scoops
	
	/**
	 * constructor with specified flavor
	 **/
	public IceCreamCone ( String flavor )
	{
		// call superclass constructor
		super();
		// set the flavor
		setFlavor( flavor );		
		// initialize the stack
		mainStack = new StackLL<String>();
	}
	
	/**
	 * constructor with no parameters, default is no flavor
	 **/
	public IceCreamCone()
	{
		// call other constructor to default to no flavor
		this( "none" );
	}
	
	/**
	 * Given a flavor, set it as this ice cream cone's flavor.
	 * Valid parameter values: "none" or one of FLAVORS
	 * If invalid parameter is passed, defaults to "none"
	 **/
	public void setFlavor( String flavor )
	{
		flavorIndex = findFlavorIndex( flavor );
	}

	/** 
	 * Given a flavor, returns the corresponding index in FLAVORS.
	 * Valid parameter values: "none" or one of FLAVORS
	 * If invalid parameter is passed, defaults to -1
	 **/
	private int findFlavorIndex( String flavor )
	{
		// if none, ignoring case
		if ( flavor.toLowerCase().equals( "none" ) )
			// flag of -1 indicates none
			return -1;
		else
		{
			// for each allowed flavor
			for ( int i = 0; i < FLAVORS.length; i++ )
			{
				// if found a match, ignoring case
				if ( flavor.toLowerCase().equals( FLAVORS[i] ) )
					// found flavor index
					return i;
			}
			
			// if we get here, passed flavor did not match any element 
			// set to none
			return -1;
		}
	}
	
	/**
	 * Method to get the stack
	 */
	public StackLL<String> getStack()
	{
		return mainStack;
	}
	
	/**
	* Method drawIC for painting each scoop
	* takes a String indicating the flavor to be added
	**/
	public void drawIC( Graphics g )
	{
		// keep a temporary stack
		StackLL<String> tempStack = new StackLL<String>();
		// set number of scoop to be 0
		scoopNum = 0;
		//while there's still scoop on the mainStack
		while(!mainStack.isEmpty())
			//push all the scoop to the tempStack
			tempStack.push(mainStack.pop());
		//while push back, get the flavor and pain the scoop
		while(!tempStack.isEmpty())
		{
			//keep the current scoop
			String currentScoop = tempStack.pop();
			//set the flavor to the currentScoop
			setFlavor(currentScoop);
			//push it back to the mainStack
			mainStack.push(currentScoop);
			//increment the number of scoop by 1
			scoopNum++;
			//paint the scoop
			paintScoop( g );
		}
	}
	
	/**
	* Method getRandomIC for painting each scoop
	* takes no arguments and adds a scoop of a random flavor
	**/
	public StackLL<String> getRandomIC()
	{
		//set a random number of scoop
		int randomNumScoop = (int) Math.floor(Math.random()*3) + 1;
		//for each scoop
		for(int i = 0; i < randomNumScoop; i++){
			// set a random flavor
			int randomFlavorIndex = (int) Math.floor(Math.random()*FLAVORS.length);
			// set the flavor and push the scoop in the stack
			mainStack.push(FLAVORS[randomFlavorIndex]);
			//increment the number of scoop by 1
			scoopNum++;
		}
		return mainStack;
	}
	
	/**
	 * Override the paint method to draw an ice cream cone.
	 **/
	@Override
	public void paint( Graphics g )
	{
		// draw the cone
		paintCone( g );
		// draw the scoop
		drawIC( g );
	}

	/**
	 * paint the cone
	 **/
	public void paintCone( Graphics g )
	{
		int[] xPoints = new int[3];
		int[] yPoints = new int[3];
		
		// center bottom point
		xPoints[0] = getWidth() / 2;
		yPoints[0] = getHeight();
		// upper left point
		xPoints[1] = xPoints[0] - (CONE_WIDTH/2);
		yPoints[1] = yPoints[0] - CONE_HEIGHT;
		
		// upper right point
		xPoints[2] = xPoints[0] + (CONE_WIDTH/2);
		yPoints[2] = yPoints[0] - CONE_HEIGHT;
		
		// set the paint color
		g.setColor( Color.YELLOW );
		
		// draw triangle
		g.fillPolygon( xPoints, yPoints, 3 );
	}

	/**
	 * paint the scoop
	 **/
	private void paintScoop( Graphics g )
	{
		if ( flavorIndex != -1 )	// if there's flavor
		{
			// set the paint color based on the flavor
			g.setColor( PAINT_COLORS[ flavorIndex ] );
		
			// fill oval (upper left x, upper left y, width, height)
			g.fillOval( 
				// upper left x is center minus half diameter
				getWidth()/2 - SCOOP_DIAMETER/2,
				// upper left y accounts for cone height and a bit of overlap
				getHeight() - CONE_HEIGHT - SCOOP_DIAMETER*scoopNum + SCOOP_OVERLAP*scoopNum,
				SCOOP_DIAMETER, SCOOP_DIAMETER );
		}
	}
}