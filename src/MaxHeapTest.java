import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MaxHeapTest {
	public static void main(String[]args) throws FileNotFoundException {
        MaxHeap heap = new MaxHeap();
        MaxHeap heap2 = new MaxHeap();
        File input = new File("data.txt");
        File output = new File("output.txt");
        try {
			output.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

        init1(heap, input);
        init2(heap2, input);
        
        
        
		try {
			FileWriter fw = new FileWriter(output.getName());
			fw.write("=====================================================================" + "\n");
	        fw.write("Heap built using sequential insertions: " + heap2.getHeap() + "\n");
	        fw.write("Number of swaps in the heap creation: " + heap2.getSwaps() + "\n");
	        heap2.removeTen();
	        fw.write("Heap after 10 removals: " + heap2.getHeap() + "\n");
	        fw.write("\n");
	        
	        fw.write("Heap build using the optimal method: " + heap.getHeap() + "\n");
	        fw.write("Number of swaps in the heap creation: " + heap.getSwaps() + "\n");
	        heap2.removeTen();
	        fw.write("Heap after 10 removals: " + heap.getHeap());
	        fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
    }
	
	public static void init1(MaxHeap heap, File file) {
		
		Scanner scan;
		try {
			scan = new Scanner(file);
			int value;
	        while(scan.hasNextInt()) {
	            value = scan.nextInt();
	            heap.insertSort(value);
	        }
	        scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
public static void init2(MaxHeap heap, File file) {
		
		Scanner scan;
		try {
			scan = new Scanner(file);
			int value;
	        while(scan.hasNextInt()) {
	            value = scan.nextInt();
	            heap.insert(value);
	        }
	        scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}