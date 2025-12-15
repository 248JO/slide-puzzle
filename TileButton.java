package assign09;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * This class holds the getter and swap methods that will be used when a tile displays an image 
 * and performs some action when clicked with a mouse.
 * 
 * @author Judy Ojewia
 * @version November 16, 2023
 */

public class TileButton extends JButton {

	private final int row;
	private final int column;
	private int imageID;
	
	/**
	 * This constructor calls that superclass constructor that takes 
	 * Icon as a parameter and uses filename to construct that icon. 
	 * It also sets the row column and image ID instance variables.
	 * 
	 * @param filename a string value representing the filename used to construct an icon.
	 * @param row an integer value representing the button's row in the grid.
	 * @param column an integer value representing the button's column in the grid.
	 * @param imageID an integer value representing the image id.
	 */
	public TileButton(String filename, int row, int column, int imageID) {
		super(new ImageIcon(filename));
		this.row = row;
		this.column = column;
		this.imageID = imageID;
		
	}
	
	/**
	 * This method gets the integer value row which represents the button's row in the grid.
	 * 
	 * @return row an integer value representing the button's row in the grid.
	 */
	public int getRow() {
		return this.row;
		
	}
	
	/**
	 * This method gets the integer value column which represents 
	 * the button's column in the grid.
	 * 
	 * @return column an integer value representing the button's column in the grid.
	 */
	public int getColumn() {
		return this.column;
		
	}
	
	/**
	 * This method gets the integer value imageID which represents the image id
	 * 
	 * @return imageID an integer value representing the image id.
	 */
	public int getImageID() {
		return this.imageID;
		
	}
		
	/**
	 * This method swaps the Icon and imageID between this and the other TileButton.
	 * 
	 * @param other a TileButton representing the other tile button used for swapping.
	 */
	public void swap(TileButton other) {

		Icon iconTemp;
		iconTemp= this.getIcon();
		Icon thisIcon = other.getIcon();
		other.setIcon(iconTemp);
		this.setIcon(thisIcon);

		int newTemp;
		newTemp = this.imageID;
		this.imageID = other.imageID;
		other.imageID = newTemp;
		
	}
	
	private static final long serialVersionUID = 1L;
	
}
