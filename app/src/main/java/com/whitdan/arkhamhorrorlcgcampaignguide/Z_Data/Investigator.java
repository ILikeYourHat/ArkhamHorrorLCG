package com.whitdan.arkhamhorrorlcgcampaignguide.Z_Data;

public class Investigator {
    // Integer values for each investigator
    public enum Name {
        PLACEHOLDER,
        ROLAND_BANKS,
        DAISY_WALKER,
        SKIDS_OTOOLE,
        AGNES_BAKER,
        WENDY_ADAMS,
        ZOEY_SAMARAS,
        REX_MURPHY,
        JENNY_BARNES,
        JIM_CULVER,
        ASHCAN_PETE,
        MARK_HARRIGAN,
        MINH_THI_PHAN,
        SEFINA_ROUSSEAU,
        AKACHI_ONYELE,
        WILLIAM_YORICK,
        LOLA_HAYES,
        MARIE_LAMBEAU,
        NORMAN_WITHERS,
        CAROLYN_FERN,
        SILAS_MARSH,
        LEO_ANDERSON,
        URSULA_DOWNS,
        FINN_EDWARDS,
        FATHER_MATEO,
        CALVIN_WRIGHT
    }

    // Sets maximum health and sanity values for the various investigators (correspond to the names in the string array)
    // StartingXP sets the bonus XP available at start for an investigator (for applicable investigators)
    private int[] health        = {0,9,5,8,6,7,9,6,8,7,6,9,7,5,6,8,6,6,6,6,9,8,7,7,6,6};
    private int[] sanity        = {0,5,9,6,8,7,6,9,7,8,5,5,7,9,8,6,6,8,8,9,5,6,7,7,8,6};
    private int[] startingXP    = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,0};

    public Investigator(Investigator.Name investigator, String name, String deckName, String deck){
        setupInvestigator(investigator);
        this.PlayerName = name;
        this.DeckName = deckName;
        this.Decklist = deck;
    }

    private void setupInvestigator(Investigator.Name investigator){
        this.name = investigator;
        this.Health = health[name.ordinal()];
        this.Sanity = sanity[name.ordinal()];
        this.Status = 1;
        this.Damage = 0;
        this.Horror = 0;
        this.TotalXP = startingXP[name.ordinal()];
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
