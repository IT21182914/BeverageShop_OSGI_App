package beveragepublisher;

import java.util.ArrayList;

public class BeverageImpl implements IBeverage {
	
	//Create a Beverage List
	private ArrayList<Beverage> beverageList = new ArrayList<Beverage>();

	//Add Beverage Method
	@Override
	public boolean addBeverage(Beverage beverage) {
		beverageList.add(beverage);
		return true;
	}

	//Update Beverage Method
	@Override
	public boolean updateBeverage(String id, Beverage beverage) {
		if (beverageList.isEmpty()) {
			return false;
		} else {
			int i = -1;
			for (Beverage object : beverageList) {
				i = i + 1;
				if (object.getId().equals(id)) {
					beverageList.set(i, new Beverage(beverage.getId(), beverage.getBeverageName(), beverage.getPrice(), beverage.getBeverageType()));
					return true;
				}
			}
			return false;
		}
	}

	//Delete Beverage Method
	@Override
	public boolean deleteBeverage(String id) {
		if (beverageList.isEmpty()) {
			return false;
		} else {
			for (Beverage beverage : beverageList) {
				if (beverage.getId().equals(id)) {
					beverageList.remove(beverage);
					return true;
				}
			}
			return false;
		}
	}

	//Get Beverage By ID Method
	@Override
	public Beverage beverageGetById(String id) {
		if (beverageList.isEmpty()) {
			return null;
		} else {
			for (Beverage beverage : beverageList) {
				if (beverage.getId().equals(id)) {
					return beverage;
				}
			}
			return null;
		}
	}

	//Get All Beverages (Menu) Method
	@Override
	public ArrayList<Beverage> getBeverageList() {
		return beverageList;
	}

}
