package de.thkoeln.eks.osgi.autovermietung.core;

import de.thkoeln.eks.osgi.autovermietung.api.Verwaltung;
import de.thkoeln.eks.osgi.autovermietung.api.entities.Auto;
import de.thkoeln.eks.osgi.autovermietung.api.entities.Kunde;

import java.util.ArrayList;
import java.util.List;


public class VerwaltungImpl implements Verwaltung {

    private final List<Kunde> kunden;
    private final List<Auto> autos;

    public VerwaltungImpl() {
        this.kunden = new ArrayList<>();
        this.autos = new ArrayList<>();
    }

    public Kunde newKunde(String name) {
        Kunde kunde = new Kunde(name);
        this.kunden.add(kunde);
        return this.kunden.stream().filter(k -> k.equals(kunde)).findFirst().orElse(null);
    }

    public Auto newAuto(String marke, String modell) {
        Auto auto = new Auto(marke, modell);
        this.autos.add(auto);
        return this.autos.stream().filter(a -> a.equals(auto)).findFirst().orElse(null);
    }

}
