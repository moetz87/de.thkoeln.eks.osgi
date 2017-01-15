package de.thkoeln.eks.osgi.autovermietung.api.entities;

import java.util.Date;

public class Leihe {

    private final Date leihStart;
    private Date leihEnde;
    private final Kunde kunde;
    private final Auto auto;

    public Leihe(Date leihStart, Kunde kunde, Auto auto) {
        this.leihStart = leihStart;
        this.kunde = kunde;
        this.auto = auto;
    }

    public Date getLeihStart() {
        return leihStart;
    }

    public Date getLeihEnde() {
        return leihEnde;
    }

    public void setLeihEnde(Date leihEnde) {
        this.leihEnde = leihEnde;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public Auto getAuto() {
        return auto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Leihe leihe = (Leihe) o;

        if (leihStart != null ? !leihStart.equals(leihe.leihStart) : leihe.leihStart != null) return false;
        if (leihEnde != null ? !leihEnde.equals(leihe.leihEnde) : leihe.leihEnde != null) return false;
        if (kunde != null ? !kunde.equals(leihe.kunde) : leihe.kunde != null) return false;
        return auto != null ? auto.equals(leihe.auto) : leihe.auto == null;
    }

    @Override
    public int hashCode() {
        int result = leihStart != null ? leihStart.hashCode() : 0;
        result = 31 * result + (leihEnde != null ? leihEnde.hashCode() : 0);
        result = 31 * result + (kunde != null ? kunde.hashCode() : 0);
        result = 31 * result + (auto != null ? auto.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Leihe{" +
                "leihStart=" + leihStart +
                ", leihEnde=" + leihEnde +
                ", kunde=" + kunde +
                ", auto=" + auto +
                '}';
    }

}
