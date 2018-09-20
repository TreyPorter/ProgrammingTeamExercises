import java.util.*;
import java.lang.*;

class Day1
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner in = new Scanner(System.in);
		int scenarios = in.nextInt();
		for(int i = scenarios; i>0; --i) {
			HashMap<String, String> m = new HashMap<String, String>();
			System.out.println("Scenario #" + (scenarios-i+1) + ":");
			int j = in.nextInt();
			String[] arr = new String[j-1];
			for(int k = j; k > 1; --k) {
				String temp = in.next();
				arr[j-k] = temp;
				m.put(temp, in.next());
			}
			String start = "";
			for(int k = 0; k < j-1; k++) {
					if(!m.containsValue(arr[k])) {
					start = arr[k];
					break;
				}
			}
			System.out.println(start);
			for(int k = 0; k < j-1; k++) {
				String temp = m.get(start);
				System.out.println(temp);
				start = temp;
			}
			System.out.println();
		}


	}
}
