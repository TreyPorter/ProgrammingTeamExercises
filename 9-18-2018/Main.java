import java.util.*;
import java.lang.*;

class Main
{
	public static void main (String[] args)	{
		Scanner in = new Scanner(System.in);
		PriorityQueue<Value> priorityQueue = new PriorityQueue<Value>();
		while(in.hasNext()) {
			int totalRows = in.nextInt();
			int totalCols = in.nextInt();
			int[] usedColNum = new int[totalCols];
			System.out.println(totalCols + " " + totalRows);
			for(int i = 0; i < totalRows; ++i) {
				int usedCols = in.nextInt();
				if(usedCols == 0) {
					continue;
				}
				int[] nValues = new int[usedCols];
				//String nStr = in.nextLine();
				//String vStr = in.nextLine();
				for(int j = 0; j < usedCols; ++j) {
					//int endN = nStr.indexOf(" ");
					//int endV = nStr.indexOf(" ");
					//nValues[j] = Integer.parseInt(nStr.substring(0, endN));
					//vValues[j] = Integer.parseInt(vStr.substring(0, endN));
					//nStr.replace();
					nValues[j] = in.nextInt()-1;
					usedColNum[j]++;
				}
				//Values are created with n & m swapped which transposes the matrix
				for(int j = 0; j < usedCols; ++j) {
					priorityQueue.add(new Value(in.nextInt(), nValues[j], i));
				}
			}
			/*
			while(!priorityQueue.isEmpty()) {
				System.out.println(priorityQueue.poll());
			}*/
			//Iterator itr = priorityQueue.iterator();
			Value currentValue = priorityQueue.poll();
			while(!priorityQueue.isEmpty() || currentValue != null) {
				int currentM = currentValue.getM();
				int i = 0;
				StringBuilder nValues = new StringBuilder();
				StringBuilder vValues = new StringBuilder();
				int emptyRows = 0;
				while(currentValue != null && currentValue.getM() == currentM) {
					//System.out.println("meme");
					nValues.append(" " + (currentValue.getN()+1));
					vValues.append(currentValue.getV());
					++i;
					if(priorityQueue.peek() != null) {
						//currentValue = priorityQueue.poll();
						emptyRows = priorityQueue.peek().getM() - currentM - 1;
						if(priorityQueue.peek().getM() == currentM) {
							vValues.append(" ");
						}
					}
					else {
						if(currentValue.getM() != totalCols-1) {
							System.out.println(0 + "\n");
						}
						currentM = -1;
					}
					currentValue = priorityQueue.poll();
				}
				System.out.print(i);
				System.out.println(nValues + "\n" + vValues);
				for(int j = 0; j < emptyRows; ++j) {
					System.out.println(0 + "\n");
				}
			}
		}
	}
}

class Value implements  Comparable<Value>{
    private int m,n,v;

    public Value(int v, int m, int n){
        this.v = v;
        this.m = m;
		this.n = n;
    }
	public int getM() {
		return m;
	}
	public int getV() {
		return v;
	}
	public int getN() {
		return n;
	}
    //smaller m coordinate results in higher priority in the queue, n is secondary priority
    public int compareTo(Value other){

        //return a negative number when you want 'this' object to have higher priority than other object
        //we will return a negative number if the x coordinate of this point is smaller than the other point
        if(this.m < other.m) return -1;

        //return a positive number when you want 'this' object to have lower priority than other object
        //we will return a positive number if the x coordinate of this point is greater than the other point
        else if(this.m > other.m) return 1;

        //In the case that m is equal, n should be checked
		//Lesser n gets priority
        else if(this.n < other.n) return -1;
		//Greater n gets lower priority
		else if(this.n > other.n) return 1;
		//this case handles equality for the m,n coordinate between the two different points
        //if the objects are equal I'm fucked
		else {
            return 0;
        }

    }

    public String toString(){
        return ("val: " + this.v + " m: " + this.m + "  n: " + this.n);
    }

}
