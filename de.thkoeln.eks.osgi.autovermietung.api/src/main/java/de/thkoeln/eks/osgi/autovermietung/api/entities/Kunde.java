package de.thkoeln.eks.osgi.autovermietung.api.entities;

public class Kunde {

    private final String name;

    public Kunde(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Kunde kunde = (Kunde) o;

        return name != null ? name.equals(kunde.name) : kunde.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Kunde{" +
                "name='" + name + '\'' +
                '}';
    }

}
