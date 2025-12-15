package assign09;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class is a container that holds all of the graphical components
 * including a 4x4 grid of TileButtons.
 * 
 * @author Judy Ojewia
 * @version November 16, 2023
 */

public class SlidePuzzleFrame extends JFrame implements ActionListener {

	private TileButton[][] tiles = new TileButton[4][4];
	private TileButton emptyTile;

	private JButton shuffleTiles = new JButton("Shuffle Tiles");
	private JButton puzzleSolution = new JButton("Puzzle Solution");
	private JLabel message = new JLabel("");

	/**
	 * This constructor calls setDefaultCloseOperation to ensure the GUI closes when
	 * the red X is clicked. Constructs the 16 TileButtons. Creates a JPanel
	 * utilizing a 4x4 grid layout and preferred size of 720x720 which the 16 Tile
	 * Buttons are added to. Creates a second and third JPanel where the buttons for
	 * shuffling the tiles and showing the solution are added. Sets the content pane
	 * of 'this' frame to be the third panel, and calls the shuffle method.
	 */
	public SlidePuzzleFrame() {

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4, 4));
		panel.setPreferredSize(new Dimension(720, 720));

		int imageID = 0;
		for (int row = 0; row < 4; row++) {
			for (int col = 0; col < 4; col++) {
				this.tiles[row][col] = new TileButton("src/assign09/tile_" + row + "_" + col + ".png", row, col,
						imageID);
				imageID++;
				panel.add(tiles[row][col]);
				this.tiles[row][col].addActionListener(this);
			}
		}

		emptyTile = tiles[0][0];

		this.setTitle("Slide Puzzle");

		JPanel buttonPanel = new JPanel();
		this.setContentPane(buttonPanel);
		buttonPanel.setPreferredSize(new Dimension(720, 60));
		this.shuffleTiles.addActionListener(this);
		buttonPanel.add(shuffleTiles);
		this.puzzleSolution.addActionListener(this);
		buttonPanel.add(puzzleSolution);

		JPanel backPanel = new JPanel();
		backPanel.setLayout(new BorderLayout());
		backPanel.add(buttonPanel, BorderLayout.SOUTH);
		backPanel.add(panel, BorderLayout.CENTER);
		backPanel.add(message, BorderLayout.NORTH);
		this.setPreferredSize(new Dimension(720, 900));
		setContentPane(backPanel);
		this.pack();

		shuffle();

	}

	/**
	 * A private helper method that uses the TileButton's row and column as well as
	 * those of the empty tile to determine if the given tile is adjacent to the
	 * empty tile.
	 * 
	 * @param tile a Tile Button compared with the Empty Tile to see if the two are adjacent
	 * @return boolean value true if the two tiles are adjacent and false if they are not adjacent.
	 */
	private boolean adjacentToEmpty(TileButton tile) {
		if (Math.abs(tile.getRow() - emptyTile.getRow()) + Math.abs(tile.getColumn() - emptyTile.getColumn()) == 1)
			return true;
		else
		return false;
	}

	/**
	 * This method randomly swaps the empty tile with adjacent tiles many times to create a
	 * randomized configuration that has a solution. 
	 */
	public void shuffle() {

		for (int i = 0; i < 1000; i++) {
			int swapTileImgID = 0;
			
			Random rng = new Random();
			int direction = rng.nextInt(4);

			if (direction == 0 && emptyTile.getRow() > 0) {
				swapTileImgID = emptyTile.getImageID() - 4;
				emptyTile.swap(tiles[emptyTile.getRow() - 1][emptyTile.getColumn()]);
				emptyTile = tiles[emptyTile.getRow() - 1][emptyTile.getColumn()];
			} else if (direction == 1 && emptyTile.getRow() < 3) {
				swapTileImgID = emptyTile.getImageID() + 4;
				emptyTile.swap(tiles[emptyTile.getRow() + 1][emptyTile.getColumn()]);
				emptyTile = tiles[emptyTile.getRow() + 1][emptyTile.getColumn()];
			} else if (direction == 2 && emptyTile.getColumn() > 0) {
				swapTileImgID = emptyTile.getImageID() - 1;
				emptyTile.swap(tiles[emptyTile.getRow()][emptyTile.getColumn() - 1]);
				emptyTile = tiles[emptyTile.getRow()][emptyTile.getColumn() - 1];
			} else if (direction == 3 && emptyTile.getColumn() < 3) {
				swapTileImgID = emptyTile.getImageID() + 1;
				emptyTile.swap(tiles[emptyTile.getRow()][emptyTile.getColumn() + 1]);
				emptyTile = tiles[emptyTile.getRow()][emptyTile.getColumn() + 1];
			}
		}
	}

	/**
	 * This method solves the puzzle by putting the tiles back in the correct
	 * locations.
	 */
	public void solve() {
		int correctImgID = 0;
		for (int row = 0; row < 4; row++) {
			for (int col = 0; col < tiles[row].length; col++) {
				while (tiles[row][col].getImageID() != correctImgID) {
					tiles[row][col].swap(tiles[tiles[row][col].getImageID() / 4][tiles[row][col].getImageID() % 4]);
				}
				correctImgID++;
			}
		}
		emptyTile = tiles[0][0];
	}

	/**
	 *  This method checks each tile in the grid to see if the button coordinates and image ID
	 * match, which means that the puzzle is solved. If any of them do not match, the method returns false. If they all
	 * match, the puzzle has been solved and true is returned.
	 * 
	 * @return a boolean value true meaning that all of the button coordinates and image IDs are a match meaning the puzzle is solved
	 * or false meaning that one or more of the button coordinates and image IDs do not match.
	 */
	public boolean isSolved() {

		int correctImgID = 0;
		for (int row = 0; row < 4; row++) {
			for (int col = 0; col < tiles[row].length; col++) {
				while (tiles[row][col].getImageID() != correctImgID) {
					return false;
				}
				correctImgID++;
			}
		}
		return true;
	}

	/**
	 * This is the method that is invoked when a button is selected. When the shuffle, solve puzzle, or any of the tile buttons are selected
	 * certain actions using other methods are performed. 
	 * 
	 * @param e an Action Event object that represents the event of the button being selected.
	 */
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() instanceof TileButton) {
			TileButton button = (TileButton) e.getSource();
			if (adjacentToEmpty(button)) {
				emptyTile.swap(button);
				emptyTile = button;
				message.setText("");
			} else if (false == adjacentToEmpty(button)) {
				message.setText("This tile is not adjacent.");
				message.setFont(new Font("Dialog", Font.PLAIN, 20));
			}
			if (isSolved()) {
				message.setText("Congratulations! You solved it!2");
				message.setFont(new Font("Dialog", Font.PLAIN, 20));
			}
			
		} else if (e.getSource() instanceof JButton) {
			JButton button = (JButton) e.getSource();
			if (button.equals(shuffleTiles)) {
				shuffle();
			} else if (button.equals(puzzleSolution)) {
				solve();
				message.setText("Congratulations! You solved it!");
				message.setFont(new Font("Dialog", Font.PLAIN, 20));
			}
		}
	}

	private static final long serialVersionUID = 1L;
}
