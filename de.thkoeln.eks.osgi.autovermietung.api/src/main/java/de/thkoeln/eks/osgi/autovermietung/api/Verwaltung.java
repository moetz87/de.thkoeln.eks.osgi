package de.thkoeln.eks.osgi.autovermietung.api;

import de.thkoeln.eks.osgi.autovermietung.api.entities.Auto;
import de.thkoeln.eks.osgi.autovermietung.api.entities.Kunde;


public interface Verwaltung {

    Kunde newKunde(String name);

    Auto newAuto(String marke, String modell);

}
