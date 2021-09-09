package fr.formation.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonView;

import fr.formation.api.Views;

public class Repos {
    @JsonView(Views.Repos.class)
    private int pvRecupere;
    
    @JsonView(Views.Repos.class)
    private BigDecimal argentperdu;

    public Repos() {

    }

    public Repos(int pvRecupere, BigDecimal argentperdu) {
        this.pvRecupere = pvRecupere;
        this.argentperdu = argentperdu;
    }

    public int getPvRecupere() {
        return pvRecupere;
    }

    public void setPvRecupere(int pvRecupere) {
        this.pvRecupere = pvRecupere;
    }

    public BigDecimal getArgentperdu() {
        return argentperdu;
    }

    public void setArgentperdu(BigDecimal argentperdu) {
        this.argentperdu = argentperdu;
    }

}