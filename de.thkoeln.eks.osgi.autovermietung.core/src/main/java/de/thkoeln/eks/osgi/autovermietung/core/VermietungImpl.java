package de.thkoeln.eks.osgi.autovermietung.core;

import de.thkoeln.eks.osgi.autovermietung.api.Vermietung;
import de.thkoeln.eks.osgi.autovermietung.api.entities.Auto;
import de.thkoeln.eks.osgi.autovermietung.api.entities.Kunde;
import de.thkoeln.eks.osgi.autovermietung.api.entities.Leihe;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class VermietungImpl implements Vermietung {

    private final List<Leihe> leihen;

    public VermietungImpl() {
        this.leihen = new ArrayList<>();
    }

    public Leihe startLeihe(Kunde kunde, Auto auto) {
        Leihe leihe = new Leihe(new Date(), kunde, auto);
        this.leihen.add(leihe);
        return this.leihen.stream().filter(l -> l.equals(leihe)).findFirst().orElse(null);
    }

    public void endLeihe(Leihe leihe) {
        if (this.leihen.removeIf(l -> l.equals(leihe))) {
            leihe.setLeihEnde(new Date());
            this.leihen.add(leihe);
        }
    }

}
