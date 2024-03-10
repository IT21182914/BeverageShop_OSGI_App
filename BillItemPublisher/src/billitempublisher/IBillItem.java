package billitempublisher;

import java.util.ArrayList;

public interface IBillItem {
	
	//Basic Implementation
	public boolean addBillItem(BillItem billItem);
	public ArrayList<BillItem> getAssignByEmployeeID(String eId);
	public ArrayList<BillItem> getAssignByBeverageID(String bId);
	public ArrayList<BillItem> getAllBillItems();
	public boolean updateBillItem(String id, BillItem billItem);
	public boolean deleteBillItem(String id);
	public BillItem billItemGetById(String id);

}
