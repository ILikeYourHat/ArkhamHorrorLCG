package com.whitdan.arkhamhorrorlcgcampaignguide.Z_Data;

public class Investigator {

    public enum Name {
        NONE(0, 0, 0),
        ROLAND_BANKS(9, 5, 0),
        DAISY_WALKER(5, 9, 0),
        SKIDS_OTOOLE(8,6,0),
        AGNES_BAKER(6,8,0),
        WENDY_ADAMS(7, 7, 0),
        ZOEY_SAMARAS(9, 6, 0),
        REX_MURPHY(6, 9, 0),
        JENNY_BARNES(8, 7, 0),
        JIM_CULVER(7, 8, 0),
        ASHCAN_PETE(6, 5, 0),
        MARK_HARRIGAN(9, 5, 0),
        MINH_THI_PHAN(7, 7, 0),
        SEFINA_ROUSSEAU(5, 9, 0),
        AKACHI_ONYELE(6, 8, 0),
        WILLIAM_YORICK(8,6 ,0),
        LOLA_HAYES(6, 6, 0),
        MARIE_LAMBEAU(6, 8, 0),
        NORMAN_WITHERS(6, 8, 0),
        CAROLYN_FERN(6, 9, 0),
        SILAS_MARSH(9, 5, 0),
        LEO_ANDERSON(8, 6, 0),
        URSULA_DOWNS(7, 7, 0),
        FINN_EDWARDS(7, 7, 0),
        FATHER_MATEO(6, 8, 5),
        CALVIN_WRIGHT(6, 6, 0);

        private final int health;
        private final int sanity;
        private final int startingXP;

        Name(int health, int sanity, int startingXP) {
            this.health = health;
            this.sanity = sanity;
            this.startingXP = startingXP;
        }
    }

    public Investigator(Investigator.Name investigator, String name, String deckName, String deck) {
        setupInvestigator(investigator);
        this.PlayerName = name;
        this.DeckName = deckName;
        this.Decklist = deck;
    }

    private void setupInvestigator(Investigator.Name investigator) {
        this.name = investigator;
        this.Health = name.health;
        this.Sanity = name.sanity;
        this.Status = 1;
        this.Damage = 0;
        this.Horror = 0;
        this.TotalXP = name.startingXP;
        this.AvailableXP = this.TotalXP;
        this.SpentXP = 0;
    }

    // Basic attributes for all investigators
    public Investigator.Name name;
    public int Health;
    public int Sanity;
    public int Status;          // 0 = not in use, 1 = in use, 2 = dead, 3 = saved
    public int Damage;
    public int Horror;
    public int TotalXP;
    public int AvailableXP;
    public int SpentXP;
    public String PlayerName;
    public String DeckName;
    public String Decklist;

    // Temp variables for when a change might be pending clicking the continue button
    public int TempStatus;      // 0 = normal, 1 = resigned, 2 = health, 3 = horror
    public int TempWeakness;    // 0 = not active, 1 = active
    public int TempWeaknessOne;
    public int TempWeaknessTwo;
    public int TempDamage;
    public int TempHorror;
    public int TempTotalXP;
    public int TempAvailableXP;

    // Supplies
    public int SupplyPoints;
    public int Provisions;
    public int Medicine;
    public int Supplies;
    public int ResuppliesOne;
}
