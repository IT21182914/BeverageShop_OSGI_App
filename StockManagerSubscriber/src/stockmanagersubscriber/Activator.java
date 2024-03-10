package stockmanagersubscriber;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import stockpublisher.IStock;

public class Activator implements BundleActivator {

	//Declare Service Reference
	private ServiceReference<?> stockServiceReference;
	
	//Declare Stock Interface Class
	private IStock stockService;

	//Start Method
	public void start(BundleContext bundleContext) throws Exception {
		stockServiceReference = bundleContext.getServiceReference(IStock.class.getName());
		stockService = (IStock) bundleContext.getService(stockServiceReference);
		
		System.out.println("Stock Subscriber is Started");
		
		StockManagerMainUI adminFrame = new StockManagerMainUI(stockService);
		adminFrame.setVisible(true);
	}

	//Stop Method
	public void stop(BundleContext bundleContext) throws Exception {
		bundleContext.ungetService(stockServiceReference);
		
		System.out.println("Stock Subscriber is stopped");
	}

}
