package beveragepublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	//Declare Service Registration
	private ServiceRegistration<?> serviceRegistration;
	
	//Start Method
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Beverage Publisher Started");
		serviceRegistration = bundleContext.registerService(IBeverage.class.getName(), new BeverageImpl(), null);
	}

	//Stop Method
	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Beverage Publisher Stopped");
		serviceRegistration.unregister();
	}

}
