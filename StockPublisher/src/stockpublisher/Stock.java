package stockpublisher;

public class Stock {
	
	//Declare Variables
	private String id;
	private String stockName;
	private String stockQty;
	
	/**
	 * @param id
	 * @param stockName
	 * @param stockQty
	 */
	public Stock(String id, String stockName, String stockQty) {
		this.id = id;
		this.stockName = stockName;
		this.stockQty = stockQty;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the stockName
	 */
	public String getStockName() {
		return stockName;
	}

	/**
	 * @param stockName the stockName to set
	 */
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	/**
	 * @return the stockQty
	 */
	public String getStockQty() {
		return stockQty;
	}

	/**
	 * @param stockQty the stockQty to set
	 */
	public void setStockQty(String stockQty) {
		this.stockQty = stockQty;
	}

}
