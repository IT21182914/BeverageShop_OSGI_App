package stockpublisher;

import java.util.ArrayList;

public interface IStock {
	
	//Basic Implementation
	public boolean addStock(Stock stock);
	public boolean updateStock(String id, Stock stock);
	public boolean deleteStock(String id);
	public Stock stockGetById(String id);
	public ArrayList<Stock> getStockList();

}
