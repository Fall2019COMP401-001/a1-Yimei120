package a1;

import java.util.*;

public class A1Jedi {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		 // read all the input
		int count = scan.nextInt();
		ItemJ[] item = new ItemJ[count];

		int product_no = 0;
		CustomerJ[] cus = null;

		for (int i = 0; i < count; i++) {
			item[i] = new ItemJ();

			String item_name = scan.next();
			double item_price = scan.nextDouble();

			item[i].setItem_name(item_name);
			item[i].setItem_price(item_price);

			if (scan.hasNextInt()) {
				int customer_no = scan.nextInt();
				cus = new CustomerJ[customer_no];
				for (int j = 0; j < customer_no; j++) {
					cus[j] = new CustomerJ();
					String firstName = scan.next();
					String lastName = scan.next();
					product_no = scan.nextInt();

					cus[j].setShopping_list(product_no);

					Cus_ItemJ[] bought = new Cus_ItemJ[product_no];


					cus[j].setBought(bought);
					// String[] names = new String[product_no];
					for (int p = 0; p < product_no; p++) {
						bought[p] = new Cus_ItemJ();

						int bou_no = scan.nextInt();
						String bou_name = scan.next();
						
						/*for (int n=0; n<names.length; n++ ) {
							names[n] = bou_name;
						}*/

						bought[p].setQuantity(bou_no);
						bought[p].setBou_name(bou_name);

					}
				}
			}
		}

		// read all the input from loops
		// after matching names, record the quantity of EACH item
		// flag: used to record number of customers

		int[] product_output = new int[item.length];
		int[] cus_order = new int[item.length];
		
		for (int c = 0; c < item.length; c++) {
			int sum = 0;
			int order = 0;
			for (int a = 0; a < cus.length; a++) {
					int flag = 0;
				for (int b = 0; b < cus[a].getShopping_list(); b++) {
					
					if (cus[a].getBought()[b].getBou_name().equals(item[c].getItem_name())) {
						// get price and quantity; multiple them and add them together
						   int q = cus[a].getBought()[b].getQuantity();
							sum += q;
							
						   if (b==0) {
							   flag = 1;
						   }else {
							for (int m=0; m<b; m++) {
								if (cus[a].getBought()[b].getBou_name().equals(cus[a].getBought()[m].getBou_name())) {
									flag = 0;
									break;
								} 
								flag = 1;
							}
						   }
						
					}else {
						flag = 0;
					}
						
					if (flag == 1) {
						order += 1;
					}
					
				}
				
			}
			product_output[c] = sum;
			cus_order[c] = order;
			if (product_output[c] == 0) {
				System.out.println("No customers bought " + item[c].getItem_name());
			}
		}

		
		for (int s = 0; s < item.length; s++) {
			if (product_output[s] == 0) {
				continue;
			}
			System.out.println(cus_order[s] + " customers bought " + product_output[s] + " " + item[s].getItem_name());
		}
		scan.close();
	}

	public static int sum(int[] x) {
		int sum = 0;
		for (int i = 0; i < x.length; i++) {
			sum += x[i];
		}
		return sum;
	}
 

}

//store names, shopping list, and the number of different items each customer bought
class CustomerJ {

	private Cus_ItemJ[] bought;
	private int shopping_list;

	public Cus_ItemJ[] getBought() {
		return bought;
	}

	public void setBought(Cus_ItemJ[] bought) {
		this.bought = bought;
	}

	public int getShopping_list() {
		return shopping_list;
	}

	public void setShopping_list(int shopping_list) {
		this.shopping_list = shopping_list;
	}

}

//store prices, and names of all items
class ItemJ {
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

//number and names of items EACH customer bought
class Cus_ItemJ {
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

