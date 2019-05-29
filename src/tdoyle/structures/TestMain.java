
package tdoyle.structures;
import java.util.Random;

public class TestMain{

	public static void main(String[] args) {	
		
		//TESTING
		Random rand = new Random();
		MinHeap testHeap = new MinHeap(50);
		for(int i=0;i<50;i++){
			testHeap.add(rand.nextInt(1000));
		}
		testHeap.printHeap();
	
		for(int i=0;i<50;i++){
			testHeap.remove();
		}
		
		System.out.println("HeapValues");
		testHeap.printHeap();
		
		//test minimum values input
		
		
		//test medium quantity of values input
		
	
		//test large quantity of values input
		
	
	}
	

}