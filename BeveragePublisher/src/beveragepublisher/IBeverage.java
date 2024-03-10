package beveragepublisher;

import java.util.ArrayList;

public interface IBeverage {
	
	//Basic Implementation
	public boolean addBeverage(Beverage beverage);
	public boolean updateBeverage(String id, Beverage beverage);
	public boolean deleteBeverage(String id);
	public Beverage beverageGetById(String id);
	public ArrayList<Beverage> getBeverageList();

}
