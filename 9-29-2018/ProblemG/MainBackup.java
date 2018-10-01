import java.util.*;
import java.lang.*;

public class Main
{
	public static void main (String[] args)	{
		Scanner in = new Scanner(System.in);
		int itemNum = in.nextInt();
		int minBuy = in.nextInt();
		//array row 1 is week 1 price, row 2 is week 2 price, row 3 is price diff, row 4 is bought of not bit
		int[] arr = new int[itemNum];
		PriorityQueue<Price> costs = new PriorityQueue<Price>;
		int sum = 0;
		int idealPurchased = 0;
		//process input
		for(int i = 0; i < itemNum; ++i) {
			arr[i] = in.nextInt();
		}
		//Week 1
		//Purchase anything with positive diff
		for(int i = 0; i < itemNum; ++i) {
			int temp = in.nextInt();
			costs.add(new Price(arr[i], temp, temp-arr[i], 0))
			arr[i][2] = arr[i][1] - arr[i][0];
			arr[i][3] = 0;
			if(arr[i][2] > 0) {
				//System.out.println("Week 1: " + i);
				arr[i][3] = 1;
				sum += arr[i][0];
				++idealPurchased;
			}
		}
		//If purchased less than min, buy items with min diffs
		if(idealPurchased < minBuy) {
			int needed = minBuy - idealPurchased;
			//find min diff and buy
			int minCost = Integer.MIN_VALUE;
			int minCostPos = 0;
			for(int i = 0; i < needed; ++i) {
				for(int j = 0; j < itemNum; ++j) {
					if(arr[j][3] == 0 && arr[j][2] > minCost) {
						minCost = arr[j][2];
						minCostPos = j;
					}
				}
				//System.out.println("mWeek 1: " + minCostPos);
				arr[minCostPos][3] = 1;
				sum += arr[minCostPos][0];
			}
		}
		//Week2
		//Purchase anything left
		for(int i = 0; i < itemNum; ++i) {
			if(arr[i][3] == 0) {
				//System.out.println("Week 2: " + i);
				arr[i][3] = 1;
				sum += arr[i][1];
			}
		}
		System.out.println(sum);
	}
	private class Price implements Comparable<Price>{
	    int w1,w2,diff,bought;

	    public Value(int w1, int w2, int diff, int bought){
	        this.w1 = w1;
	        this.w2 = w2;
			this.diff = diff;
			this.bought = bought
	    }/*
		public int getM() {
			return m;
		}
		public int getV() {
			return v;
		}
		public int getN() {
			return n;
		}*/
	    //larger diff results in higher priority in the queue
	    public int compareTo(Value other){
	        //return a negative number when you want 'this' object to have higher priority than other object
	        if(this.diff > other.diff) return -1;
	        //return a positive number when you want 'this' object to have lower priority than other object
	        else if(this.diff < other.diff) return 1;
			//this case handles equality for the diff
			else {
	            return 0;
	        }

	    }
		/*
	    public String toString(){
	        return ("val: " + this.v + " m: " + this.m + "  n: " + this.n);
	    }*/
	}
}
