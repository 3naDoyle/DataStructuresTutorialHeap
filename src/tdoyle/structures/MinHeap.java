package tdoyle.structures;

public class MinHeap {
	
	private int [] heap;
	private int noOfElements = 0;
	
	//constructor to initialise 
	public MinHeap(int noOfElements){
		int size=(noOfElements*2+1)+1;  //increase capacity (allowing for child nodes)
		heap= new int [size];
	}
	
	public int remove(){
		int removedElement = heap[1]; 	//copy root
		heap[1]=0;						//delete root
		
		if(this.isEmpty()==false){
			int parent,leftChild,rightChild;
			
			for (int i=1;i<=(this.nextAvailableIndex()-1)/2;i++){ //only loop to last parent = (i<length/2)
				 parent=i;
				 leftChild=i*2;
				 rightChild=i*2+1;
				 
				/* System.out.println("Check values of Parent and Children Before Removal");
				 System.out.println("\t Parent: "+heap[parent]+"\n"+"Left Child: "+heap[leftChild]+" \t right Child "+heap[rightChild]);
				*/
				if(heap[parent]==0){  //the moved or removed value will be ZERO
					
					if(heap[rightChild]==0 && heap[leftChild]>0){ //if right child is empty
						//System.out.println("Promoting Left Child ");
						heap[parent]=heap[leftChild];  //move left child into parent position
						heap[leftChild]=0;		//make left child space empty
					}
					
					else if (heap[leftChild]==0 && heap[rightChild]>0){ //if right child is empty
						//System.out.println("Promoting right Child ");
						heap[parent]=heap[rightChild];  //move left child into parent position
						heap[rightChild]=0;		//left child now empty
					}
		
					else if ( (heap[rightChild]!=0 || heap[leftChild]!=0) && (heap[rightChild]<heap[leftChild]) ){
						//System.out.println("Promoting Right Child ");
						heap[parent]=heap[rightChild];		//move right child up
						heap[rightChild]=0; 			//right-child now empty
					}
					
					//else if (heap[leftChild]<heap[rightChild]&&heap[leftChild]!=0){
					else if ((heap[rightChild]!=0||heap[leftChild]!=0) && (heap[leftChild]<heap[rightChild])){
						//System.out.println("Promoting Left Child ");
						heap[parent]=heap[leftChild];  //move left child into parent position
						heap[leftChild]=0;		//left child now empty
					}
					
					else if((heap[rightChild]!=0 || heap[leftChild]!=0) && (heap[rightChild]==heap[leftChild])){
						//System.out.println("Promoting Right Child ");
						heap[parent]=heap[rightChild];
						heap[rightChild]=0;
					}
					
				}//close if
					
			}//close forLoop
			
		}
		
		noOfElements--;
		return removedElement;
		
	}// close remove() method
	
	public void add(int input){
		
		heap[nextAvailableIndex()]=input; // add new value
		noOfElements++;				//increase element-count
		
		//swap-sort new inputed value to correct position - start Loop at last parent
		for(int i=noOfElements/2;i>0;i--){
			
			int parent=i;
			int leftChild= i*2;
			int rightChild= i*2+1;
			
			if (heap[leftChild]<heap[parent]&&heap[leftChild]!=0){		//swap with left child
				int temp=heap[parent];
				heap[parent]=heap[leftChild];
				heap[leftChild]=temp;
			}
			
			else if (heap[rightChild]<heap[parent]&&heap[rightChild]!=0){  //swap with right child
				int temp=heap[parent];
				heap[parent]=heap[rightChild];
				heap[rightChild]=temp;
			}
			
/*			else{
				System.out.println("no swap required");
			}
			*/
			
		}//close for	
	}
	
	public void printHeap(){
	
		System.out.print("[");
		for(int i=1;i<heap.length;i++){
			System.out.print(heap[i]+" ");
		}
		System.out.println("]");
		
	}
	
	
	public boolean isEmpty(){
		
		boolean check=true;
		for(int i=1;i<heap.length;i++){
			
			if(heap[i]>0){
				check=false;
			}
		}
		return check;
	}
	
	
	public int nextAvailableIndex(){
		
		int sizeCheck = 1;
		int lastElementIndex;
		
		for(int i=heap.length-1;i>0;i--){
			
			if(heap[i]==0){
				sizeCheck++;
			}
			else{  //if meets a value (stop count)
				
				break;
			}
		}
		lastElementIndex=heap.length-sizeCheck;  //end values
		return lastElementIndex+1;
	}
	
	
}
