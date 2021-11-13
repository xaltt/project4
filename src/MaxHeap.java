import java.util.Arrays;
import java.util.Collections;

public class MaxHeap {

    


    private  int[] theHeap;
    private  int capacity;
    private  int pos;
    private  int maxCapacity;
    private  int swaps;

    public MaxHeap() {
        pos = 1;
        capacity = 100;
        maxCapacity = 100;
        theHeap = new int[capacity];
    }

    public void removeTen() {
        int randomNumber;
        for(int i = 0; i < 10; i++) {
            randomNumber = ((int) Math.random() * capacity) + 1;
            //array = ArrayUtils.remove(array, index);
            theHeap = remove(randomNumber);

        }
    }

    public int[] remove(int index) {
        int[] copy = new int[theHeap.length - 1];
        for (int i = 0, j = 0; i < theHeap.length; i++) {
            if (i != index) {
                copy[j++] = theHeap[i];
            }
        }
        theHeap = copy;
        return theHeap;
    }


    public String getHeap() {
    	String heapStr = "";
        for(int i = 1; i < 11; i++) {
            heapStr += (theHeap[i] + " ");
        }
        heapStr += "...";
        return heapStr;

    }

    public void insertSort(int value) {
        if (pos == capacity) {

            // inc capacity
            //capacity = capacity * 2;
        } else {
            theHeap[pos++] = value;
            int child = pos - 1;
            int parent = child / 2;

            while (theHeap[parent] < theHeap[child] && parent > 0) {
                int tmp = theHeap[parent];
                theHeap[parent] = theHeap[child];
                theHeap[child] = tmp;
                child = parent;
                parent = child / 2;
                swaps++;
            }
        }
    }
    
    public void insert(int value) {
    	if(pos == capacity) {
    		
    	}else {
    		theHeap[pos++] = value;
    	}
    	if(pos == maxCapacity) {
    		sort();
    	}
    }
    
    public void sort() {
    	//selects index to be compared
    	for(int i = 0; i < theHeap.length; i++) {
    		//compares index to all elements in theHeap
    		for(int j = i + 1; j < theHeap.length; j++) {
    			int temp;
    			if(theHeap[i] < theHeap[j]) {
    				temp = theHeap[i];
    				theHeap[i] = theHeap[j];
    				theHeap[j] = temp;
    				swaps++;
    			}
    		}
    	}
    }

    public int getSwaps() {
    	return swaps;
    }
    public int getLength() {
    	return theHeap.length;
    }

}