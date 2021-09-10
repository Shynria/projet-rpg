package fr.formation.model;

import com.fasterxml.jackson.annotation.JsonView;

import fr.formation.api.Views;

public class Rencontre {
    @JsonView(Views.Rencontre.class)
    private int PvPerdu;
    
    @JsonView(Views.Rencontre.class)
    private Bestiaire monstreRencontre;

    @JsonView(Views.Rencontre.class)
    private boolean levelUp;

    @JsonView(Views.Rencontre.class)
    private boolean mort;

    

    public boolean isMort() {
        return mort;
    }

    public void setMort(boolean mort) {
        this.mort = mort;
    }

    public boolean isLevelUp() {
        return levelUp;
    }

    public void setLevelUp(boolean levelUp) {
        this.levelUp = levelUp;
    }

    public int getPvPerdu() {
        return PvPerdu;
    }

    public void setPvPerdu(int pvPerdu) {
        PvPerdu = pvPerdu;
    }

    public Bestiaire getMonstreRencontre() {
        return monstreRencontre;
    }

    public void setMonstreRencontre(Bestiaire monstreRencontre) {
        this.monstreRencontre = monstreRencontre;
    }

    public Rencontre(int pvPerdu, Bestiaire monstreRencontre) {
        PvPerdu = pvPerdu;
        this.monstreRencontre = monstreRencontre;
    }

    public Rencontre(int pvPerdu, Bestiaire monstreRencontre, boolean levelUp) {
        PvPerdu = pvPerdu;
        this.monstreRencontre = monstreRencontre;
        this.levelUp = levelUp;
    }

    public Rencontre() {
    }

    
}