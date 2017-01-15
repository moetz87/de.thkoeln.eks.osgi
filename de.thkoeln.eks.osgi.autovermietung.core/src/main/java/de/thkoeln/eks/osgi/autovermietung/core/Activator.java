package de.thkoeln.eks.osgi.autovermietung.core;

import de.thkoeln.eks.osgi.autovermietung.api.Vermietung;
import de.thkoeln.eks.osgi.autovermietung.api.Verwaltung;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import java.util.Hashtable;


public class Activator implements BundleActivator {

    private ServiceRegistration<Verwaltung> verwaltungServiceRegistration;
    private ServiceRegistration<Vermietung> vermietungServiceRegistration;

    public void start(BundleContext bundleContext) throws Exception {
        Hashtable<String, String> properties = new Hashtable<>();
        this.verwaltungServiceRegistration = bundleContext.registerService(Verwaltung.class, new VerwaltungImpl(), properties);
        this.vermietungServiceRegistration = bundleContext.registerService(Vermietung.class, new VermietungImpl(), properties);
    }

    public void stop(BundleContext bundleContext) throws Exception {
        this.verwaltungServiceRegistration.unregister();
        this.vermietungServiceRegistration.unregister();
    }

}
