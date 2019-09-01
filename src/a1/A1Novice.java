package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// Your code follows here.

		if (scan.hasNextInt()) {
			int count = scan.nextInt();

			String[] values = new String[count];
			double total = 0;
			double[] product;
			for (int i = 0; i < count; i++) {
				String firstName = scan.next();
				String lastName = scan.next();

				int pnum = scan.nextInt();
				product = new double[pnum];
				for (int j = 0; j < pnum; j++) {
					int num = scan.nextInt();
					scan.next(); // get rid of product name
					double price = scan.nextDouble();

					total = ProductTotal(num, price);

					product[j] = total;

				}

				double sum = 0;
				for (double t : product) {
					sum += t;
				}

				String tot = String.format("%.2f", sum);

				values[i] = firstName.substring(0, 1) + '.' + " " + lastName + ':' + " " + tot;

			}

			for (String each : values) {
				System.out.println(each);

			}

		}
		scan.close();
	}

	public static double ProductTotal(int x, double y) {
		return x * y;
	}
}
