package stockpublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	//Declare Service Registration
	private ServiceRegistration<?> serviceRegistration;

	//Start Method
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Stock Publisher Started");
		serviceRegistration = bundleContext.registerService(IStock.class.getName(), new StockImpl(), null);
	}

	//Stop Method
	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Stock Publisher Stopped");
		serviceRegistration.unregister();
	}

}
