package stockpublisher;

import java.util.ArrayList;

public class StockImpl implements IStock {
	
	//Create a Stock List
	private ArrayList<Stock> stockList = new ArrayList<Stock>();

	//Add Stock Method
	@Override
	public boolean addStock(Stock stock) {
		stockList.add(stock);
		return true;
	}

	//Update Stock
	@Override
	public boolean updateStock(String id, Stock stock) {
		if (stockList.isEmpty()) {
			return false;
		} else {
			int i = -1;
			for(Stock object : stockList) {
				i = i + 1;
				if (object.getId().equals(id)) {
					stockList.set(i, new Stock(stock.getId(), stock.getStockName(), stock.getStockQty()));
					return true;
				}
			}
			return false;
		}
	}

	//Delete Stock
	@Override
	public boolean deleteStock(String id) {
		if (stockList.isEmpty()) {
			return false;
		} else {
			for(Stock stock : stockList) {
				if (stock.getId().equals(id)) {
					stockList.remove(stock);
					return true;
				}
			}
			return false;
		}
	}

	//Stock Get By ID Method
	@Override
	public Stock stockGetById(String id) {
		if (stockList.isEmpty()) {
			return null;
		} else {
			for(Stock stock : stockList) {
				if (stock.getId().equals(id)) {
					return stock;
				}
			}
			return null;
		}
	}

	//Get Stock List Method
	@Override
	public ArrayList<Stock> getStockList() {
		return stockList;
	}

}
