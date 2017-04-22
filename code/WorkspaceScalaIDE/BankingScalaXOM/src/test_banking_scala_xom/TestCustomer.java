package test_banking_scala_xom;

import banking_scala_xom.Asset;
import banking_scala_xom.Customer;
import banking_scala_xom.CustomerOwningAssets;

public class TestCustomer {
	
	static void process(Customer customer) {
		customer.clearAlerts();

		if (customer.totalBalance() < -10) {
			customer.addAlert("totalBalance less than -10");
			System.out.println("totalBalance less than -10");
		}
		
		if (customer instanceof CustomerOwningAssets) {
			CustomerOwningAssets customer2 = (CustomerOwningAssets) customer;
			
			if (customer2.sumAssetValues() > 100) {
				customer.addAlert("sumAssetValues more than 100");
				System.out.println("sumAssetValues more than 100");
			}
			
			for (Asset asset : customer2.assets()) {
				if (asset.value() > 60) {
					customer.addAlert("one of the assets has value more than 60");
					System.out.println("one of the assets has value more than 60");
					break;
				}
			}
		}
	}

	public static void main(String[] args) {
		Customer customer = new Customer(-10);
		process(customer);

		customer = new Customer(-11);
		process(customer);

		customer = new CustomerOwningAssets(-10, new Asset[] {});
		process(customer);

		customer = new CustomerOwningAssets(-11, new Asset[] {});
		process(customer);

		customer = new CustomerOwningAssets(-20, new Asset[] { new Asset(10) });
		process(customer);

		customer = new CustomerOwningAssets(-21, new Asset[] { new Asset(10) });
		process(customer);

		customer = new CustomerOwningAssets(-21, new Asset[] { new Asset(10), new Asset(50), new Asset(40) });
		process(customer);

		customer = new CustomerOwningAssets(-21, new Asset[] { new Asset(10), new Asset(50), new Asset(41) });
		process(customer);

		customer = new CustomerOwningAssets(-21, new Asset[] { new Asset(10), new Asset(50) });
		process(customer);

		customer = new CustomerOwningAssets(-21, new Asset[] { new Asset(10), new Asset(51) });
		process(customer);
	}
}
