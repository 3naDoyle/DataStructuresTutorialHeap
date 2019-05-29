package tdoyle.structures;

import java.util.LinkedList;

public class HashTable {

	LinkedList [] htbl;
	int size;
	
	//constructor
	HashTable(int setSize){
		size=setSize; //no of buckets
		htbl=new LinkedList[size];
		
		for (int i=0;i<htbl.length;i++){  //create linkedList for every bucket
			htbl[i]=new LinkedList();
		}
		
	}
	
	public void add(int value){
		
		int index=hashIndex(value);		  //calculate array index
		htbl[index].addFirst(value);	 //add to front of linked list in the array [index]
	}	
	
	public void remove(int value){
		
		if(this.isInTable(value)==true){
			
			this.search(value);	//to inform user of LOCATION
			htbl[this.hashIndex(value)].removeFirstOccurrence(value);
			System.out.println("Element Removed!");
			this.printContents();

		}
		
		else{
			
			System.out.println("Selcted Value IS NOT in Hash Table");
		}
		
	}
	
	public void search(int element){		//returns the location of the element
		
		int LLindex=0;
		int arIndex=0;
	
		for (int i=0;i<htbl.length;i++){
			
			LLindex = htbl[i].indexOf(element);
			arIndex=i;
			if(LLindex!=-1){
				break;
			}
		}
		
		if(LLindex==-1){
			System.out.println("Value Does not Exist In Table (index: -1) ");
		}
		
		else{
			System.out.println("The element "+element+" is at location ["+arIndex+","+LLindex+"]");
		}
		
	}

	public int hashIndex(int val){
		int key;
		key = val%size;
		return key;
	}
	
	public void printContents(){
		
		for(int i=0;i<htbl.length;i++){
			System.out.print(htbl[i].toString());
		}
		System.out.println("");
	}//close method
	
	public boolean isInTable(int elmt){
		int instanceCheck;
		boolean exist=false;
		
		for (int i=0;i<htbl.length;i++){
			instanceCheck = htbl[i].indexOf(elmt);
		
			if(instanceCheck!=-1){
				exist=true;
				break;
			}
		}
		
		return exist;
		
	}
	
}
