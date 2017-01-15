package de.thkoeln.eks.osgi.autovermietung.api.entities;

public class Auto {

    private final String marke;
    private final String modell;

    public Auto(String marke, String modell) {
        this.marke = marke;
        this.modell = modell;
    }

    public String getMarke() {
        return marke;
    }

    public String getModell() {
        return modell;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Auto auto = (Auto) o;

        if (marke != null ? !marke.equals(auto.marke) : auto.marke != null) return false;
        return modell != null ? modell.equals(auto.modell) : auto.modell == null;
    }

    @Override
    public int hashCode() {
        int result = marke != null ? marke.hashCode() : 0;
        result = 31 * result + (modell != null ? modell.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "marke='" + marke + '\'' +
                ", modell='" + modell + '\'' +
                '}';
    }

}
