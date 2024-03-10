package billitempublisher;

import java.util.ArrayList;

public class BillItemImpl implements IBillItem {
	
	//Add bill items data to the array list to store
	private ArrayList<BillItem> billItemDataList = new ArrayList<>();

	//Add Bill Items
	@Override
	public boolean addBillItem(BillItem billItem) {
		if(billItem != null) {
			billItemDataList.add(billItem);
			return true;
		}
		else {
			return false;
		}
	}

	//Get and Assign Employees
	@Override
	public ArrayList<BillItem> getAssignByEmployeeID(String eId) {
		ArrayList<BillItem> assignOfEmployee = new ArrayList<>();
		
		for(BillItem obj : billItemDataList) {
			if(obj.getEmployee().getId().contentEquals(eId)) {
				assignOfEmployee.add(obj);
			}
		}

		if(assignOfEmployee.isEmpty()) {
			return null;
		}
		else {
			return assignOfEmployee;
		}
	}

	//Get and Assign Beverage
	@Override
	public ArrayList<BillItem> getAssignByBeverageID(String bId) {
		ArrayList<BillItem> assignOfBeverage = new ArrayList<>();
		
		for(BillItem obj : billItemDataList) {
			if(obj.getBeverage().getId().contentEquals(bId)) {
				assignOfBeverage.add(obj);
			}
		}

		if(assignOfBeverage.isEmpty()) {
			return null;
		}
		else {
			return assignOfBeverage;
		}
	}

	//Get All Bill Items
	@Override
	public ArrayList<BillItem> getAllBillItems() {
		if(!billItemDataList.isEmpty()) {
			return billItemDataList;
		} else {
			return null;
		}
	}

	//Update Bill Item
	@Override
	public boolean updateBillItem(String id, BillItem billItem) {
		for(BillItem obj : billItemDataList) {
			if(obj.getId() == id) {
				obj = billItem;
				return true;
			}
		}
		return false;
	}

	//Delete Bill Item
	@Override
	public boolean deleteBillItem(String id) {
		for(BillItem obj : billItemDataList) {
			if(obj.getId() == id) {
				billItemDataList.remove(obj);
				return true;
			}
		}
		return false;
	}

	//Get Bill Item Get By ID
	@Override
	public BillItem billItemGetById(String id) {
		if(billItemDataList.isEmpty()) {
			return null;
		}
		else {
			for(BillItem billItem : billItemDataList) {
				if(billItem.getId().equals(id)) {
					return billItem;
				}
			}
			return null;
		}
	}
	
}
