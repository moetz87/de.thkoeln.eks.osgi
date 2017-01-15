package de.thkoeln.eks.osgi.main;


import de.thkoeln.eks.osgi.autovermietung.api.Vermietung;
import de.thkoeln.eks.osgi.autovermietung.api.Verwaltung;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;


public class Activator implements BundleActivator {

    public void start(BundleContext bundleContext) throws Exception {
        BundleContext verwaltungBundleContext = FrameworkUtil.getBundle(Verwaltung.class).getBundleContext();
        ServiceReference<Verwaltung> verwaltungServiceReference = verwaltungBundleContext.getServiceReference(Verwaltung.class);
        Verwaltung verwaltung = verwaltungBundleContext.getService(verwaltungServiceReference);

        BundleContext vermietungBundleContext = FrameworkUtil.getBundle(Vermietung.class).getBundleContext();
        ServiceReference<Vermietung> vermietungServiceReference = verwaltungBundleContext.getServiceReference(Vermietung.class);
        Vermietung vermietung = vermietungBundleContext.getService(vermietungServiceReference);

        Main main = new Main(verwaltung, vermietung);
        main.execute();
    }

    public void stop(BundleContext bundleContext) throws Exception {

    }

}
