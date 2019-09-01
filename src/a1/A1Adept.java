package a1;

import java.util.*;

public class A1Adept {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
        // read all the input
		
		int count = scan.nextInt();
		Item[] item = new Item[count];

		double output = 0;
		int product_no = 0;
		double[] total_output = null;
		double sum_eachcus = 0;
		Customer[] cus = null;

		for (int i = 0; i < count; i++) {
			item[i] = new Item();

			String item_name = scan.next();
			double item_price = scan.nextDouble();

			item[i].setItem_name(item_name);
			item[i].setItem_price(item_price);

			if (scan.hasNextInt()) {
				int customer_no = scan.nextInt();
				cus = new Customer[customer_no];
				total_output = new double[customer_no];
				for (int j = 0; j < customer_no; j++) {
					cus[j] = new Customer();
					String firstName = scan.next();
					String lastName = scan.next();
					product_no = scan.nextInt();

					cus[j].setFirstName(firstName);
					cus[j].setLastName(lastName);

					cus[j].setShopping_list(product_no);


					CusItem[] bought = new CusItem[product_no];



					cus[j].setBought(bought);
					for (int p = 0; p < product_no; p++) {
						bought[p] = new CusItem();

						int bou_no = scan.nextInt();
						String bou_name = scan.next();

						bought[p].setQuantity(bou_no);
						bought[p].setBou_name(bou_name);

					}

				}
			}
		}
		
		// read all the input from loops
		// after match item names, total purchase list of each customer will be "output"
		// total_output: total money spent by each customer
		for (int a = 0; a < cus.length; a++) {
			double[] product_output = new double[cus[a].getShopping_list()];
			for (int b = 0; b < cus[a].getShopping_list(); b++) {
				for (int c = 0; c < item.length; c++) {


					if (cus[a].getBought()[b].getBou_name().equals(item[c].getItem_name())) {
						// get price and quantity; multiple them and add them together

						int q = cus[a].getBought()[b].getQuantity();
						double pp = item[c].getItem_price();

						output = pp * q;


					}


				}
				product_output[b] = output;
			}

			sum_eachcus = sum(product_output);
			total_output[a] = sum_eachcus;
		}
        // find the biggest
		double biggest = total_output[0];
		int f = 0;
		String fname_big;
		String lname_big;
		for (int z = 1; z < cus.length; z++) {
			if (total_output[z] > biggest) {
				biggest = total_output[z];
				f = z;

			}
		}

		fname_big = cus[f].getFirstName();
		lname_big = cus[f].getLastName();
		String biggie = String.format("%.2f", biggest);
        
		// find the smallest
		double smallest = total_output[0];
		int ff = 0;
		String fname_small;
		String lname_small;
		for (int s = 1; s < cus.length; s++) {
			if (total_output[s] < smallest) {
				smallest = total_output[s];
				ff = s;

			}
		}
		fname_small = cus[ff].getFirstName();
		lname_small = cus[ff].getLastName();
		String small = String.format("%.2f", smallest);
        
		String average = avg(total_output);


		System.out.println("Biggest:" + " " + fname_big + " " + lname_big + " " + "(" + biggie + ")");
		System.out.println("smallest:" + " " + fname_small + " " + lname_small + " " + "(" + small + ")");
		System.out.print("Average:" + " " + average);

		scan.close();
	}
    
	public static double sum(double[] x) {
		double sum = 0;
		for (int i = 0; i < x.length; i++) {
			sum += x[i];
		}
		return sum;
	}

	public static String avg(double[] y) {
		double sum = 0;
		for (int i = 0; i < y.length; i++) {
			sum += y[i];
		}
		String a = String.format("%.2f", sum / y.length);
		return a;

	}

}

// store names, shopping list, and the number of different items each customer bought
class Customer {
	private String firstName;
	private String lastName;
	private CusItem[] bought;
	private int shopping_list;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public CusItem[] getBought() {
		return bought;
	}

	public void setBought(CusItem[] bought) {
		this.bought = bought;
	}

	public int getShopping_list() {
		return shopping_list;
	}

	public void setShopping_list(int shopping_list) {
		this.shopping_list = shopping_list;
	}


}
// store prices, and names of all items
class Item {
	private String item_name;
	private double item_price;

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public double getItem_price() {
		return item_price;
	}

	public void setItem_price(double item_price) {
		this.item_price = item_price;
	}

}
// number and names of items EACH customer bought
class CusItem {
	private int quantity;
	private String bou_name;


	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getBou_name() {
		return bou_name;
	}

	public void setBou_name(String bou_name) {
		this.bou_name = bou_name;
	}




}
