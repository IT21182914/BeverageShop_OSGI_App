package beveragemanagersubscriber;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import beveragepublisher.IBeverage;

public class Activator implements BundleActivator {

	//Declare Service Reference
	private ServiceReference<?> beverageServiceReference;
	
	//Declare Beverage Interface Class
	private IBeverage beverageService;

	//Start Method
	public void start(BundleContext bundleContext) throws Exception {
		beverageServiceReference = bundleContext.getServiceReference(IBeverage.class.getName());
		beverageService = (IBeverage) bundleContext.getService(beverageServiceReference);
		
		System.out.println("Beverage Manager Subscriber is Started");
		
		BeverageManagerMainUI beverageManagerFrame = new BeverageManagerMainUI(beverageService);
		beverageManagerFrame.setVisible(true);
	}

	//Stop Method
	public void stop(BundleContext bundleContext) throws Exception {
		bundleContext.ungetService(beverageServiceReference);
		
		System.out.println("Beverage Manager Subscriber is Stopped");
	}

}
