package cashiersubscriber;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import beverageemployeepublisher.IEmployee;
import beveragepublisher.IBeverage;
import billitempublisher.IBillItem;

public class Activator implements BundleActivator {

	//Declare Service References
	private ServiceReference<?> employeeServiceReference;
	private ServiceReference<?> billItemServiceReference;
	private ServiceReference<?> beverageServiceReference;
	
	//Declare Interface Classes
	private IEmployee employeeService;
	private IBillItem billItemService;
	private IBeverage beverageService;
	
	//Start Method
	public void start(BundleContext bundleContext) throws Exception {
		employeeServiceReference = bundleContext.getServiceReference(IEmployee.class.getName());
		billItemServiceReference = bundleContext.getServiceReference(IBillItem.class.getName());
		beverageServiceReference = bundleContext.getServiceReference(IBeverage.class.getName());
		
		employeeService = (IEmployee) bundleContext.getService(employeeServiceReference);
		billItemService = (IBillItem) bundleContext.getService(billItemServiceReference);
		beverageService = (IBeverage) bundleContext.getService(beverageServiceReference);
		
		System.out.println("Cashier Subscriber is Started");
		
		CashierMainUI cashierFrame = new CashierMainUI(employeeService, beverageService, billItemService);
		cashierFrame.setVisible(true);
	}

	//Stop Method
	public void stop(BundleContext bundleContext) throws Exception {
		bundleContext.ungetService(employeeServiceReference);
		bundleContext.ungetService(billItemServiceReference);
		bundleContext.ungetService(beverageServiceReference);
		
		System.out.println("Cashier Subscriber is Stopped");	
	}

}
