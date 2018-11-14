package TareaTest;

import junit.framework.JUnit4TestAdapter;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

public class TareaTest {
	
	TareaFixture1 fixture1 = new TareaFixture1();
	
	public TareaTest() {
		
	}
	
	/**
	 * Inicio Fixture
	 */
	
	@Before
	public void setUp() {
		fixture1.setUp();
	}
	
	
	
}
