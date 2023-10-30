package org.example.domain;

import java.util.Objects;

public class Tablou extends Entity<Long>{
    private String titlu;
    private String pictor;
    private String tematica;
    private double celebritate;


    public Tablou(String titlu, String pictor, String tematica, double celebritate) {

        this.titlu = titlu;
        this.pictor = pictor;
        this.tematica = tematica;
        this.celebritate = celebritate;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public String getPictor() {
        return pictor;
    }

    public void setPictor(String pictor) {
        this.pictor = pictor;
    }

    public String getTematica() {
        return tematica;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }

    public double getCelebritate() {
        return celebritate;
    }

    public void setCelebritate(double celebritate) {
        this.celebritate = celebritate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tablou tablou)) return false;
        return Double.compare(tablou.celebritate, celebritate) == 0 && Objects.equals(titlu, tablou.titlu) && Objects.equals(pictor, tablou.pictor) && Objects.equals(tematica, tablou.tematica);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titlu, pictor, tematica, celebritate);
    }

    @Override
    public String toString() {
        return "Tablou{" +
                "titlu='" + titlu + '\'' +
                ", pictor='" + pictor + '\'' +
                ", tematica='" + tematica + '\'' +
                ", celebritate=" + celebritate +
                '}';
    }
}
