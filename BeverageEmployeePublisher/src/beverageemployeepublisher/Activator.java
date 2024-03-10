package beverageemployeepublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
	
	//Declare Service Registration
	private ServiceRegistration<?> serviceRegistration;

	//Start Method
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Employee Publisher Started");
		serviceRegistration = bundleContext.registerService(IEmployee.class.getName(), new EmployeeImpl(), null);
	}

	//Stop Method
	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Employee Publisher Stopped");
		serviceRegistration.unregister();
	}

}
