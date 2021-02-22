package observer;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

/**
 * Einige einfache Testfälle für die Klasse Fruehwarnungen
 * @author Lisa Vittori
 * @
 */
public class FruehwarnungenTest {
	private Fruehwarnungen fw;
	
	@BeforeEach
	public void setUpFruehwarnung() {
		fw = new Fruehwarnungen();
	}

	@Test
	void addFruehwarnungTestBasic() { 
		assertTrue(fw.addFruehwarnung("mmuster", "SEW"));
		assertTrue(fw.getFruehwarnungen("mmuster").contains("SEW"));
		assertEquals(1, fw.getFruehwarnungen("mmuster").size());
	}
	
	@Test
	void addFruehwarnungTestVorhanden() { 
		assertTrue(fw.addFruehwarnung("mmuster", "SEW"));
		assertFalse(fw.addFruehwarnung("mmuster", "SEW"));
		assertTrue(fw.getFruehwarnungen("mmuster").contains("SEW"));
		assertEquals(1, fw.getFruehwarnungen("mmuster").size());
	}
	
	@Test
	void addFruehwarnungMehrere() { 
		assertTrue(fw.addFruehwarnung("mmuster", "SEW"));
		assertTrue(fw.addFruehwarnung("mmuster", "AM"));
		assertTrue(fw.addFruehwarnung("mmuster", "E"));
		assertTrue(fw.getFruehwarnungen("mmuster").contains("SEW"));
		assertTrue(fw.getFruehwarnungen("mmuster").contains("AM"));
		assertTrue(fw.getFruehwarnungen("mmuster").contains("E"));
		assertEquals(3, fw.getFruehwarnungen("mmuster").size());
	}
	
	@Test
	void deleteFruehwarnungMehrere() { 
		assertTrue(fw.addFruehwarnung("mmuster", "SEW"));
		assertTrue(fw.addFruehwarnung("mmuster", "AM"));
		assertTrue(fw.addFruehwarnung("mmuster", "E"));
		assertTrue(fw.deleteFruehwarnung("mmuster", "SEW"));
		assertFalse(fw.getFruehwarnungen("mmuster").contains("SEW"));
		assertTrue(fw.getFruehwarnungen("mmuster").contains("AM"));
		assertTrue(fw.getFruehwarnungen("mmuster").contains("E"));
		assertEquals(2, fw.getFruehwarnungen("mmuster").size());
	}
	
	@Test
	void deleteFruehwarnungNull() { 
		assertTrue(fw.addFruehwarnung("mmuster", "SEW"));
		assertTrue(fw.addFruehwarnung("mmuster", "AM"));
		assertTrue(fw.addFruehwarnung("mmuster", "E"));
		assertTrue(fw.deleteFruehwarnung("mmuster", "SEW"));
		assertTrue(fw.deleteFruehwarnung("mmuster", "E"));
		assertTrue(fw.deleteFruehwarnung("mmuster", "AM"));
		assertNull(fw.getFruehwarnungen("mmuster"));
	}
}
