import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import org.junit.jupiter.api.Test;

public class JavaMaticTest {
	@Test
	public void testSetUp() {
		JavaMatic jm = new JavaMatic();
		int[] stock = jm.getInventory();
		for(int i=0;i<stock.length;i++) {
			assertEquals(10,stock[i]);
		}
 	
	}
	
	@Test
	public void testLowerQuit() {
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        String input = "q\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        
        JavaMatic.main(null);
        String display = "Inventory:\nCocoa,10\nCoffee,10\nCream,10\nDecaf Coffee,10\nEspresso,10\nFoamed Milk,10\n" + 
        		"Steamed Milk,10\nSugar,10\nWhipped Cream,10\nMenu:\n1,Caffe Americano,$3.30,true\n" + 
        		"2,Caffe Latte,$2.55,true\n3,Caffe Mocha,$3.35,true\n4,Cappuccino,$2.90,true\n5,Coffee,$2.75,true\n" +
        		"6,Decaf Coffee,$2.75,true\n";
        assertEquals(display, outContent.toString());
	}
	
	@Test
	public void testUpperQuit() {
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        String input = "Q\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        
        JavaMatic.main(null);
        String display = "Inventory:\nCocoa,10\nCoffee,10\nCream,10\nDecaf Coffee,10\nEspresso,10\nFoamed Milk,10\n" + 
        		"Steamed Milk,10\nSugar,10\nWhipped Cream,10\nMenu:\n1,Caffe Americano,$3.30,true\n" + 
        		"2,Caffe Latte,$2.55,true\n3,Caffe Mocha,$3.35,true\n4,Cappuccino,$2.90,true\n5,Coffee,$2.75,true\n" +
        		"6,Decaf Coffee,$2.75,true\n";
        assertEquals(display, outContent.toString());
	}
	
	@Test
	public void testLowerRestockCommand() {

		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        String input = "r\nq\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
  
        
        JavaMatic.main(null);
        
        String display = "Inventory:\nCocoa,10\nCoffee,10\nCream,10\nDecaf Coffee,10\nEspresso,10\nFoamed Milk,10\n" + 
        		"Steamed Milk,10\nSugar,10\nWhipped Cream,10\nMenu:\n1,Caffe Americano,$3.30,true\n" + 
        		"2,Caffe Latte,$2.55,true\n3,Caffe Mocha,$3.35,true\n4,Cappuccino,$2.90,true\n5,Coffee,$2.75,true\n" +
        		"6,Decaf Coffee,$2.75,true\n";

        assertEquals(display+""+display, outContent.toString());
        
	}
	
	@Test
	public void testUpperRestockCommand() {

		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        String input = "R\nq\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
  
        
        JavaMatic.main(null);
        
        String display = "Inventory:\nCocoa,10\nCoffee,10\nCream,10\nDecaf Coffee,10\nEspresso,10\nFoamed Milk,10\n" + 
        		"Steamed Milk,10\nSugar,10\nWhipped Cream,10\nMenu:\n1,Caffe Americano,$3.30,true\n" + 
        		"2,Caffe Latte,$2.55,true\n3,Caffe Mocha,$3.35,true\n4,Cappuccino,$2.90,true\n5,Coffee,$2.75,true\n" +
        		"6,Decaf Coffee,$2.75,true\n";

        assertEquals(display+""+display, outContent.toString());
        
	}
	
	@Test
	public void testMakeDrink1() {

		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        String input = "1\nq\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        
        JavaMatic.main(null);
        
        String display = "Inventory:\nCocoa,10\nCoffee,10\nCream,10\nDecaf Coffee,10\nEspresso,10\nFoamed Milk,10\n" + 
        		"Steamed Milk,10\nSugar,10\nWhipped Cream,10\nMenu:\n1,Caffe Americano,$3.30,true\n" + 
        		"2,Caffe Latte,$2.55,true\n3,Caffe Mocha,$3.35,true\n4,Cappuccino,$2.90,true\n5,Coffee,$2.75,true\n" +
        		"6,Decaf Coffee,$2.75,true\n";
        String drink1 = "Inventory:\nCocoa,10\nCoffee,10\nCream,10\nDecaf Coffee,10\nEspresso,7\nFoamed Milk,10\n" + 
        		"Steamed Milk,10\nSugar,10\nWhipped Cream,10\nMenu:\n1,Caffe Americano,$3.30,true\n" + 
        		"2,Caffe Latte,$2.55,true\n3,Caffe Mocha,$3.35,true\n4,Cappuccino,$2.90,true\n5,Coffee,$2.75,true\n" +
        		"6,Decaf Coffee,$2.75,true\n";
        assertEquals(display+"Dispensing: Caffe Americano\n"+drink1, outContent.toString());
         
	}
	
	@Test
	public void testMakeDrink2() {

		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        String input = "2\nq\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        
        JavaMatic.main(null);
        
        String display = "Inventory:\nCocoa,10\nCoffee,10\nCream,10\nDecaf Coffee,10\nEspresso,10\nFoamed Milk,10\n" + 
        		"Steamed Milk,10\nSugar,10\nWhipped Cream,10\nMenu:\n1,Caffe Americano,$3.30,true\n" + 
        		"2,Caffe Latte,$2.55,true\n3,Caffe Mocha,$3.35,true\n4,Cappuccino,$2.90,true\n5,Coffee,$2.75,true\n" +
        		"6,Decaf Coffee,$2.75,true\n";
        String drink2 = "Inventory:\nCocoa,10\nCoffee,10\nCream,10\nDecaf Coffee,10\nEspresso,8\nFoamed Milk,10\n" + 
        		"Steamed Milk,9\nSugar,10\nWhipped Cream,10\nMenu:\n1,Caffe Americano,$3.30,true\n" + 
        		"2,Caffe Latte,$2.55,true\n3,Caffe Mocha,$3.35,true\n4,Cappuccino,$2.90,true\n5,Coffee,$2.75,true\n" +
        		"6,Decaf Coffee,$2.75,true\n";
        assertEquals(display+"Dispensing: Caffe Latte\n"+drink2, outContent.toString());
         
	}
	
	@Test
	public void testMakeDrink3() {

		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        String input = "3\nq\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        
        JavaMatic.main(null);
        
        String display = "Inventory:\nCocoa,10\nCoffee,10\nCream,10\nDecaf Coffee,10\nEspresso,10\nFoamed Milk,10\n" + 
        		"Steamed Milk,10\nSugar,10\nWhipped Cream,10\nMenu:\n1,Caffe Americano,$3.30,true\n" + 
        		"2,Caffe Latte,$2.55,true\n3,Caffe Mocha,$3.35,true\n4,Cappuccino,$2.90,true\n5,Coffee,$2.75,true\n" +
        		"6,Decaf Coffee,$2.75,true\n";
        String drink3 = "Inventory:\nCocoa,9\nCoffee,10\nCream,10\nDecaf Coffee,10\nEspresso,9\nFoamed Milk,10\n" + 
        		"Steamed Milk,9\nSugar,10\nWhipped Cream,9\nMenu:\n1,Caffe Americano,$3.30,true\n" + 
        		"2,Caffe Latte,$2.55,true\n3,Caffe Mocha,$3.35,true\n4,Cappuccino,$2.90,true\n5,Coffee,$2.75,true\n" +
        		"6,Decaf Coffee,$2.75,true\n";
        assertEquals(display+"Dispensing: Caffe Mocha\n"+drink3, outContent.toString());
         
	}
	
	@Test
	public void testMakeDrink4() {

		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        String input = "4\nq\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        
        JavaMatic.main(null);
        
        String display = "Inventory:\nCocoa,10\nCoffee,10\nCream,10\nDecaf Coffee,10\nEspresso,10\nFoamed Milk,10\n" + 
        		"Steamed Milk,10\nSugar,10\nWhipped Cream,10\nMenu:\n1,Caffe Americano,$3.30,true\n" + 
        		"2,Caffe Latte,$2.55,true\n3,Caffe Mocha,$3.35,true\n4,Cappuccino,$2.90,true\n5,Coffee,$2.75,true\n" +
        		"6,Decaf Coffee,$2.75,true\n";
        String drink4 = "Inventory:\nCocoa,10\nCoffee,10\nCream,10\nDecaf Coffee,10\nEspresso,8\nFoamed Milk,9\n" + 
        		"Steamed Milk,9\nSugar,10\nWhipped Cream,10\nMenu:\n1,Caffe Americano,$3.30,true\n" + 
        		"2,Caffe Latte,$2.55,true\n3,Caffe Mocha,$3.35,true\n4,Cappuccino,$2.90,true\n5,Coffee,$2.75,true\n" +
        		"6,Decaf Coffee,$2.75,true\n";
        assertEquals(display+"Dispensing: Cappuccino\n"+drink4, outContent.toString());
         
	}
	
	@Test
	public void testMakeDrink5() {

		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        String input = "5\nq\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        
        JavaMatic.main(null);
        
        String display = "Inventory:\nCocoa,10\nCoffee,10\nCream,10\nDecaf Coffee,10\nEspresso,10\nFoamed Milk,10\n" + 
        		"Steamed Milk,10\nSugar,10\nWhipped Cream,10\nMenu:\n1,Caffe Americano,$3.30,true\n" + 
        		"2,Caffe Latte,$2.55,true\n3,Caffe Mocha,$3.35,true\n4,Cappuccino,$2.90,true\n5,Coffee,$2.75,true\n" +
        		"6,Decaf Coffee,$2.75,true\n";
        String drink5 = "Inventory:\nCocoa,10\nCoffee,7\nCream,9\nDecaf Coffee,10\nEspresso,10\nFoamed Milk,10\n" + 
        		"Steamed Milk,10\nSugar,9\nWhipped Cream,10\nMenu:\n1,Caffe Americano,$3.30,true\n" + 
        		"2,Caffe Latte,$2.55,true\n3,Caffe Mocha,$3.35,true\n4,Cappuccino,$2.90,true\n5,Coffee,$2.75,true\n" +
        		"6,Decaf Coffee,$2.75,true\n";
        assertEquals(display+"Dispensing: Coffee\n"+drink5, outContent.toString());
         
	}
	
	@Test
	public void testMakeDrink6() {

		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        String input = "6\nq\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        
        JavaMatic.main(null);
        
        String display = "Inventory:\nCocoa,10\nCoffee,10\nCream,10\nDecaf Coffee,10\nEspresso,10\nFoamed Milk,10\n" + 
        		"Steamed Milk,10\nSugar,10\nWhipped Cream,10\nMenu:\n1,Caffe Americano,$3.30,true\n" + 
        		"2,Caffe Latte,$2.55,true\n3,Caffe Mocha,$3.35,true\n4,Cappuccino,$2.90,true\n5,Coffee,$2.75,true\n" +
        		"6,Decaf Coffee,$2.75,true\n";
        String drink6 = "Inventory:\nCocoa,10\nCoffee,10\nCream,9\nDecaf Coffee,7\nEspresso,10\nFoamed Milk,10\n" + 
        		"Steamed Milk,10\nSugar,9\nWhipped Cream,10\nMenu:\n1,Caffe Americano,$3.30,true\n" + 
        		"2,Caffe Latte,$2.55,true\n3,Caffe Mocha,$3.35,true\n4,Cappuccino,$2.90,true\n5,Coffee,$2.75,true\n" +
        		"6,Decaf Coffee,$2.75,true\n";
        assertEquals(display+"Dispensing: Decaf Coffee\n"+drink6, outContent.toString());
         
	}
	
	@Test
	public void testInvalidSelection() {

		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        String input = "hello\nq\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        
        JavaMatic.main(null);
        
        String display = "Inventory:\nCocoa,10\nCoffee,10\nCream,10\nDecaf Coffee,10\nEspresso,10\nFoamed Milk,10\n" + 
        		"Steamed Milk,10\nSugar,10\nWhipped Cream,10\nMenu:\n1,Caffe Americano,$3.30,true\n" + 
        		"2,Caffe Latte,$2.55,true\n3,Caffe Mocha,$3.35,true\n4,Cappuccino,$2.90,true\n5,Coffee,$2.75,true\n" +
        		"6,Decaf Coffee,$2.75,true\n";
        
        assertEquals(display+"Invalid selection: hello\n"+display, outContent.toString());
         
	}
	
	@Test
	public void testOutOfStock() {

		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        String input = "1\n1\n1\n1\nq\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        
        JavaMatic.main(null);
        
        String display = "Inventory:\nCocoa,10\nCoffee,10\nCream,10\nDecaf Coffee,10\nEspresso,10\nFoamed Milk,10\n" + 
        		"Steamed Milk,10\nSugar,10\nWhipped Cream,10\nMenu:\n1,Caffe Americano,$3.30,true\n" + 
        		"2,Caffe Latte,$2.55,true\n3,Caffe Mocha,$3.35,true\n4,Cappuccino,$2.90,true\n5,Coffee,$2.75,true\n" +
        		"6,Decaf Coffee,$2.75,true\n";
        String order1 = "Inventory:\nCocoa,10\nCoffee,10\nCream,10\nDecaf Coffee,10\nEspresso,7\nFoamed Milk,10\n" + 
        		"Steamed Milk,10\nSugar,10\nWhipped Cream,10\nMenu:\n1,Caffe Americano,$3.30,true\n" + 
        		"2,Caffe Latte,$2.55,true\n3,Caffe Mocha,$3.35,true\n4,Cappuccino,$2.90,true\n5,Coffee,$2.75,true\n" +
        		"6,Decaf Coffee,$2.75,true\n";
        String order2 = "Inventory:\nCocoa,10\nCoffee,10\nCream,10\nDecaf Coffee,10\nEspresso,4\nFoamed Milk,10\n" + 
        		"Steamed Milk,10\nSugar,10\nWhipped Cream,10\nMenu:\n1,Caffe Americano,$3.30,true\n" + 
        		"2,Caffe Latte,$2.55,true\n3,Caffe Mocha,$3.35,true\n4,Cappuccino,$2.90,true\n5,Coffee,$2.75,true\n" +
        		"6,Decaf Coffee,$2.75,true\n";
        String order3 = "Inventory:\nCocoa,10\nCoffee,10\nCream,10\nDecaf Coffee,10\nEspresso,1\nFoamed Milk,10\n" + 
        		"Steamed Milk,10\nSugar,10\nWhipped Cream,10\nMenu:\n1,Caffe Americano,$3.30,false\n" + 
        		"2,Caffe Latte,$2.55,false\n3,Caffe Mocha,$3.35,true\n4,Cappuccino,$2.90,false\n5,Coffee,$2.75,true\n" +
        		"6,Decaf Coffee,$2.75,true\n";
        assertEquals(display + "Dispensing: Caffe Americano\n" + order1 + "Dispensing: Caffe Americano\n" + order2 +
        		"Dispensing: Caffe Americano\n" + order3 + "Out of stock: Caffe Americano\n" + order3, outContent.toString());
                 
	}
}
