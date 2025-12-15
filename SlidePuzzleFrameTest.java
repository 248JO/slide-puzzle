package assign09;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * This class contains tests for the SlidePuzzleFrame class.
 * 
 * @author Prof. Heisler and Judy Ojewia
 * @version November 16, 2023
 */
public class SlidePuzzleFrameTest {  
	
	@Test
	public void testStartInUnsolvedState() { 
		SlidePuzzleFrame frame = new SlidePuzzleFrame();
		assertFalse(frame.isSolved());
	}
	
	@Test
	public void testShuffle() { 
		SlidePuzzleFrame frame = new SlidePuzzleFrame();
		frame.solve();
		frame.shuffle();
		assertFalse(frame.isSolved());	
	}
	
	@Test
	public void testSolveTrue() { 
		SlidePuzzleFrame frame = new SlidePuzzleFrame();
		frame.solve();
		assertTrue(frame.isSolved());
	}
	
	@Test
	public void testSolveFalse() {
		SlidePuzzleFrame frame = new SlidePuzzleFrame();
		frame.shuffle();
		assertFalse(frame.isSolved());
	}

	@Test
	public void testIsSolved() { 
		SlidePuzzleFrame frame = new SlidePuzzleFrame();
		assertFalse(frame.isSolved());
	}
}