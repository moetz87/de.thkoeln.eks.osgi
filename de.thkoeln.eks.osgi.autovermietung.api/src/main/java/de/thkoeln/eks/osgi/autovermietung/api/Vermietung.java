package de.thkoeln.eks.osgi.autovermietung.api;

import de.thkoeln.eks.osgi.autovermietung.api.entities.Auto;
import de.thkoeln.eks.osgi.autovermietung.api.entities.Kunde;
import de.thkoeln.eks.osgi.autovermietung.api.entities.Leihe;


public interface Vermietung {

    Leihe startLeihe(Kunde kunde, Auto auto);

    void endLeihe(Leihe leihe);

}
