package de.thkoeln.eks.osgi.main;

import de.thkoeln.eks.osgi.autovermietung.api.Vermietung;
import de.thkoeln.eks.osgi.autovermietung.api.Verwaltung;
import de.thkoeln.eks.osgi.autovermietung.api.entities.Auto;
import de.thkoeln.eks.osgi.autovermietung.api.entities.Kunde;
import de.thkoeln.eks.osgi.autovermietung.api.entities.Leihe;

import java.util.logging.Logger;

public class Main {

    private static final Logger LOG = Logger.getLogger(Main.class.getName());

    private final Verwaltung verwaltung;
    private final Vermietung vermietung;

    public Main(Verwaltung verwaltung, Vermietung vermietung) {
        this.verwaltung = verwaltung;
        this.vermietung = vermietung;
    }

    public void execute() {
        Auto xWing = this.verwaltung.newAuto("X", "Wing");
        LOG.info(xWing.toString());
        Kunde skywalker = this.verwaltung.newKunde("Luke Skywalker");
        LOG.info(skywalker.toString());
        Leihe leihe = this.vermietung.startLeihe(skywalker, xWing);
        LOG.info(leihe.toString());
        this.vermietung.endLeihe(leihe);
        LOG.info(leihe.toString());
    }

}
