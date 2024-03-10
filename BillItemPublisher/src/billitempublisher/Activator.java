package billitempublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	//Declare Service Registration
	public ServiceRegistration<?> serviceRegistration;

	//Start Method
	public void start(BundleContext bundleContext) throws Exception {
		serviceRegistration = bundleContext.registerService(IBillItem.class.getName(), new BillItemImpl(), null);
		System.out.println("Bill Item Publisher Started");
	}

	//Stop Method
	public void stop(BundleContext bundleContext) throws Exception {
		serviceRegistration.unregister();
		System.out.println("Bill Item Publisher Stopped");
	}

}
