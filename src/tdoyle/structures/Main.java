
package tdoyle.structures;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {	
			
		question1();
		question2();

	}//close Main
	
	public static void question1(){
		
		System.out.println("******* MinHeap Implementation*******");
	
		Scanner scan = new Scanner(System.in);
		int [] userValues = new int [200];
		int elementCount=0;

		//take in user values
		System.out.println("Enter Values ! or enter ANY Letter to exit");
		
		System.out.print("Enter Value:");
		for(int i=0;i<userValues.length;i++){
			
			
			if(scan.hasNextInt()==true){
				System.out.print("Enter number Value:");
				userValues[i]=scan.nextInt();
				elementCount++;
			}else if (scan.next().equalsIgnoreCase("q")){
					break; 
			}
			else{	
					System.out.println("Incorrect input - Quitting input");
					break;  //if NOT an int
			}
			
		}
		
		//create HEAP
		MinHeap h1 = new MinHeap(elementCount); 
		
		//h1.printHeap();
		
		//add inputted values to HEAP
		for(int i=0;i<elementCount;i++){
			
			h1.add(userValues[i]);
		}
		
		System.out.println("VALUES added to HEAP !");
		h1.printHeap();

		int userPick;
		do{
			 userPick=menu();
			
			if(userPick==1){
				Scanner scan1 = new Scanner(System.in);
				System.out.println("Enter NEW value");
				int newValue = scan1.nextInt();
				h1.add(newValue);
				h1.printHeap();
			}
			if(userPick==2){
				System.out.println("BEFORE removal:");
				h1.printHeap();
				h1.remove();
				System.out.println("AFTER Removal (from Root)");
				h1.printHeap();
			}
			if(userPick==3){
				h1.printHeap();
			}
			
		}while(userPick!=4);
		
		scan.close();
	}// close q1
	
	public static void question2(){
		
	/*	MODULOUS calculator
	 http://www.calculatorpro.com/calculator/modulo-calculator/ 
	 */
		int noBuckets;
		
		System.out.println("*********HASHING**********");
		Scanner scan1 = new Scanner(System.in);
		System.out.println("Please Enter No Of Buckets (between 10 & 20)");
		noBuckets=scan1.nextInt();
		
		while(noBuckets <10 || noBuckets>20){
			System.out.println("Incorrect Value!");
			System.out.println("Please Enter No Of Buckets (between 10 & 20)");
			noBuckets=scan1.nextInt();
		}
		
		//create hash table
		HashTable h1 = new HashTable (noBuckets);
		
		Scanner scan2 = new Scanner(System.in);

		int userSelect;
		do{
			userSelect=menu();
			
			if(userSelect==1){
				System.out.println("Enter value to ADD to hash table");
				h1.add(scan2.nextInt());
				h1.printContents();
			}
			if(userSelect==2){
				System.out.println("Enter Value you wish to REMOVE");
				h1.remove(scan2.nextInt());
			}
			
			if(userSelect==3){
				h1.printContents();
			}
			
		}while(userSelect!=4);
		
	}//end of method
	
	public static int menu(){
		
		Scanner scanB = new Scanner(System.in);	
		
		System.out.println("****************************************");
		System.out.println("*     Enter 1 to ADD a value     	   *");
		System.out.println("*     Enter 2 to REMOVE a value        *");
		System.out.println("*     Enter 3 to view contents         *");
		System.out.println("*     Enter 4 to EXIT                  *");
		System.out.println("****************************************");
		
		int userChoice=scanB.nextInt();


		return userChoice;
		
		}
	
	
}//close class





