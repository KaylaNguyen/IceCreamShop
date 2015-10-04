/**
* Design and implement a class that uses the ice cream cone class
* to add and remove scoops from a cone.
* Clicking on the flavor buttons should add a scoop of that flavor.
* If the wrong scoop is accidentally added,
* clicking the "trash the top scoop button" will remove it.
* This class represents an ice cream shop employee
* trying to fulfill a particular ice cream order.
**/

// awt
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;


// swing 
import javax.swing.JButton;
import javax.swing.JPanel;

/** 
 * IceCreamMaker encapsulates the GUI for IceCreamFrame and IceCreamPanel
 * It takes a flavor as input, then uses it to draw an ice cream cone.
 **/
public class IceCreamMaker extends JPanel implements ActionListener
{
	
	// instance variables
	private IceCreamCone iceCreamCone;
	// buttons
	private JButton vanilla;
	private JButton strawberry;
	private JButton chocolate;
	private JButton cherry;
	private JButton undo;

	// constructor
	public IceCreamMaker()
	{
		// call super constructor
		super();
		
		// call instance method to initialize the graphics
		initGUI();
	}
	
	// private method to create the GUI components
	// returns the created main panel
	private void initGUI()
	{
		// use a border layout
		setLayout( new BorderLayout() );
		
		// create panel for drawing the ice cream cone
		// and add to center
		add(  createIceCreamCone(), BorderLayout.CENTER );
		
		// create buttons for "ordering" the cone
		// and add to south
		add( createOrderButtons(), BorderLayout.NORTH );
	}
	
	// private method to create ice cream display
	// returns created IceCreamCone
	private IceCreamCone createIceCreamCone()
	{	
		iceCreamCone = new IceCreamCone();
		return iceCreamCone;
	}
	
	// method to get the ice cream
	public IceCreamCone getICCone()
	{
		return iceCreamCone;
	}
	
	// private method to create buttons
	// returns created buttons
	private JPanel createOrderButtons( )
	{
		// create a panel
		JPanel buttonPanel = new JPanel(new GridLayout(0, 4));

		// create a button
		vanilla = new JButton( "Vanilla" );
		//set color to the button
		vanilla.setBackground(Color.WHITE);
		vanilla.setOpaque(true);
		// add this as the action listener for button's action (click)
	    vanilla.addActionListener(this);

	    // create a button
		strawberry = new JButton( "Strawberry" );
		//set color to the button
		strawberry.setBackground(Color.PINK);
		strawberry.setOpaque(true);
		// add this as the action listener for button's action (click)
	    strawberry.addActionListener(this);

	    // create a button
		chocolate = new JButton( "Chocolate" );
		//set color to the button
		chocolate.setBackground(new Color( 102, 51, 0 ));
		chocolate.setOpaque(true);
		// add this as the action listener for button's action (click)
	    chocolate.addActionListener(this);

	    // create a button
		cherry = new JButton( "Cherry" );
		//set color to the button
		cherry.setBackground(Color.RED);
		cherry.setOpaque(true);
		// add this as the action listener for button's action (click)
	    cherry.addActionListener(this);

	   	// create a button
		undo = new JButton( "Trash the top scoop" );
		//set color to the button
		undo.setBackground(Color.BLUE);
		undo.setOpaque(true);
		// add this as the action listener for button's action (click)
	    undo.addActionListener(this);

	    // add to panel
	    buttonPanel.add(vanilla);
	    buttonPanel.add(strawberry);
	   	buttonPanel.add(chocolate);
	   	buttonPanel.add(cherry);
	   	buttonPanel.add(undo);

		// return the panel
		return buttonPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// check what button was clicked
		if(e.getSource() == vanilla)
		 	//push to stack 
			iceCreamCone.getStack().push("vanilla");
		if(e.getSource() == strawberry)
			//push to stack 
			iceCreamCone.getStack().push("strawberry");
		if(e.getSource() == chocolate)
			//push to stack 
			iceCreamCone.getStack().push("chocolate");
		if(e.getSource() == cherry)
			//push to stack 
			iceCreamCone.getStack().push("cherry");
		if(e.getSource() == undo){
			// if there's scoop on the ice cream
			if(!iceCreamCone.getStack().isEmpty()){
				//push to stack 
				iceCreamCone.getStack().pop();
			}
		}
		//repaint the cone
		repaint();
	}
}