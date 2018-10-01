import java.util.*;
import java.lang.*;

public class Main
{
	public static void main (String[] args)	{
		//Main outer = new Main();
		Scanner in = new Scanner(System.in);
		int itemNum = in.nextInt();
		int minBuy = in.nextInt();
		//array row 1 is week 1 price, row 2 is week 2 price, row 3 is price diff, row 4 is bought of not bit
		int[] arr = new int[itemNum];
		PriorityQueue<Price> costs = new PriorityQueue<Price>();
		int sum = 0;
		int idealPurchased = 0;
		//process input
		for(int i = 0; i < itemNum; ++i) {
			arr[i] = in.nextInt();
		}
		for(int i = 0; i < itemNum; ++i) {
			int temp = in.nextInt();
			//Price a = outer.new Price(arr[i], temp, temp-arr[i], 0);
			Price a = new Price(arr[i], temp, temp-arr[i], 0);
			costs.add(a);
		}
		//Week 1
		//Purchase anything while less that min or with positive diff
		while(idealPurchased < minBuy || (costs.peek() != null && costs.peek().diff > 0)) {
			//Price temp = costs.poll();
			sum += costs.poll().w1;
			++idealPurchased;
		}
		//Week2
		//Purchase anything left
		while(!costs.isEmpty()) {
			sum += costs.poll().w2;
		}

		System.out.println(sum);
	}

}
class Price implements Comparable<Price>{
	public int w1, w2, diff, bought;

	public Price(int w1, int w2, int diff, int bought){
		this.w1 = w1;
		this.w2 = w2;
		this.diff = diff;
		this.bought = bought;
	}
	//larger diff results in higher priority in the queue
	public int compareTo(Price other){
		//return a negative number when you want 'this' object to have higher priority than other object
		if(this.diff > other.diff) return -1;
		//return a positive number when you want 'this' object to have lower priority than other object
		else if(this.diff < other.diff) return 1;
		//this case handles equality for the diff
		else {
			return 0;
		}

	}
}
