package beverageshopadminsubscriber;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import beverageemployeepublisher.IEmployee;

public class Activator implements BundleActivator {

	//Declare Service Reference
	private ServiceReference<?> employeeServiceReference;
	
	//Declare Employee Interface Class
	private IEmployee employeeService;

	//Start Method
	public void start(BundleContext bundleContext) throws Exception {
		employeeServiceReference = bundleContext.getServiceReference(IEmployee.class.getName());
		employeeService = (IEmployee) bundleContext.getService(employeeServiceReference);
		
		System.out.println("Restaurant Admin Subscriber is Started");
		
		AdminMainUI adminFrame = new AdminMainUI(employeeService);
		adminFrame.setVisible(true);
	}

	//Stop Method
	public void stop(BundleContext bundleContext) throws Exception {
		bundleContext.ungetService(employeeServiceReference);
		
		System.out.println("Admin Subscriber is Stopped");
	}

}
