import java.util.*;
import java.lang.*;

public class Main
{
	public static void main (String[] args)	{
		Scanner in = new Scanner(System.in);
		StringBuffer out = new StringBuffer();
		int paint = in.nextInt();
		int[] arr = new int[9];
		for(int i = 0; i < 9; ++i) {
			arr[i] = in.nextInt();
		}
		//int minCost = Integer.MAX_VALUE;
		int minPos = updateMin(arr, paint);
		if(minPos == -1) {
			System.out.println("-1");
			return;
		}
		int minCost = arr[minPos];
		while(paint >= minCost) {
			//System.out.println(minPos);
			if(paint >= 2*minCost) {
				out.append((minPos+1));
				paint -= minCost;
			}
			else {
				minPos = updateMin(arr, paint);
				if(minPos > 0) {
					minCost = arr[minPos];
					out.append((minPos+1));
					paint -= minCost;
				}
				else {
					minCost = Integer.MAX_VALUE;
				}
			}
		}
		System.out.println(out);
	}
	static int updateMin(int[] arr, int paint)	{
		int minPos = -1;
		int minCost = Integer.MAX_VALUE;
		//initialize to max usable digit in case only 1 digit is usable
		for(int i=8; i>=0; --i) {
			if(arr[i] <= paint) {
				minCost = arr[i];
				minPos = i;
			}
		}
		for(int i=8; i>=0; --i) {
			//Check if 2 of these can fit otherwise it's useless
			if(arr[i] < minCost && (arr[i]*2) <= paint) {
				minCost = arr[i];
				minPos = i;
			}
		}
		return minPos;
	}
}
