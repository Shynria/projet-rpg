package fr.formation.model;

import com.fasterxml.jackson.annotation.JsonView;

import fr.formation.api.Views;

public class Rencontre {
    @JsonView(Views.Rencontre.class)
    private int PvPerdu;
    
    @JsonView(Views.Rencontre.class)
    private Bestiaire monstreRencontre;

    public int getPvPerdu() {
        return PvPerdu;
    }

    public void setPvPerdu(int pvPerdu) {
        PvPerdu = pvPerdu;
    }

    public Bestiaire getMonstreRencontre() {
        return monstreRencontre;
    }

    public void setMonstreRencontré(Bestiaire monstreRencontré) {
        this.monstreRencontre = monstreRencontré;
    }

    public Rencontre(int pvPerdu, Bestiaire monstreRencontré) {
        PvPerdu = pvPerdu;
        this.monstreRencontre = monstreRencontré;
    }

    public Rencontre() {
    }

    
}