package assign09;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * This class contains tests for the TileButton class.
 * 
 * @author Prof. Heisler and Judy Ojewia
 * @version November 16, 2023
 */
public class TileButtonTest {
	private TileButton button1;
	private TileButton button2;
	private TileButton button3;
	// This code executes before each test.
	// You can reference button1 and button2 in your tests without having to create them.
	@BeforeEach
	public void setup(){
		button1 = new TileButton("src/assign09/tile_1_2.png", 1, 2, 6);
		button2 = new TileButton("src/assign09/tile_2_2.png", 2, 2, 10);
		button3 = new TileButton("src/assign09/tile_0_1.png", 0, 1, 12);
	}
	
	@Test
	public void testConstructorRow() {
		assertEquals(1, button1.getRow());
	}
	
	@Test
	public void testConstructorCol() {
		assertEquals(2, button2.getColumn());
	}
	
	@Test
	public void testConstructorImgId() {
		assertEquals(12, button3.getImageID());
	}
	
	@Test
	public void testConstructorSwap() {
		button3.swap(button2);
		assertEquals(10,button3.getImageID() );
	}
	
	@Test
	public void testGetRow() {
		assertEquals(1, button1.getRow());
	}
	
	@Test
	public void testGetRow2() {
		assertEquals(0, button3.getRow());
	}

	
	@Test
	public void testGetColumn() {
		assertEquals(2, button1.getColumn());
	}
	
	@Test
	public void testGetColumn2() {
		assertEquals(1, button3.getColumn());
	}
	
	@Test
	public void testGetImageID() {
		assertEquals(6, button1.getImageID());
	}	
	
	@Test
	public void testGetImageID2() {
		assertEquals(10, button2.getImageID());
	}
	
	@Test
	public void testSwap() {
		button1.swap(button2);
		assertEquals(10, button1.getImageID());
	}	
	
	@Test
	public void testSwap2() {
		button3.swap(button2);
		assertEquals(10, button3.getImageID());
	}
	
	@Test
	public void testSwapNoSwapRow() {
		button3.swap(button2);
		assertEquals(0, button3.getRow());
	}
	
	@Test
	public void testSwapNoSwapColumn() {
		button3.swap(button2);
		assertEquals(1, button3.getColumn());
	}
}