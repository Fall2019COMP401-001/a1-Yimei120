package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		// int count = scan.nextInt();
		
		// int[] values = new int[count];
		
		if (scan.hasNextInt()) {
			int count = scan.nextInt();
			
			String[] values = new String[count];
			for (int i = 0; i < count; i ++) {
			   	String firstName = scan.next();
			   	String lastName = scan.next();
			   	
			   	int pnum = scan.nextInt();
			   	for (int j =0; j < pnum; j ++) {
			   		int num = scan.nextInt();
			   		scan.next(); // get rid of product name
			   		double price = scan.nextDouble();
			   		
			   		double total = ProductTotal(num, price);
			   		
			   		String tot = String.format("%.2f", total);
			   		
			   		values[i] = firstName.substring(0,1) + '.' + lastName + ':' + tot;
			   	}
			   		
			}
			for (String each : values) {
				System.out.println(each);
			}
			 
		}
		
	}
	public static double ProductTotal(int x, double y ) {
		return x*y;
	}
}
