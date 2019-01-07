package com.whitdan.arkhamhorrorlcgcampaignguide.Z_Data;

public class Investigator {

    public Investigator(InvestigatorCharacter investigator, String name, String deckName, String deck) {
        setupInvestigator(investigator);
        this.PlayerName = name;
        this.DeckName = deckName;
        this.Decklist = deck;
    }

    private void setupInvestigator(InvestigatorCharacter investigator) {
        this.name = investigator;
        this.Health = name.getHealth();
        this.Sanity = name.getSanity();
        this.Status = 1;
        this.Damage = 0;
        this.Horror = 0;
        this.TotalXP = name.getStartingXP();
        this.AvailableXP = this.TotalXP;
        this.SpentXP = 0;
    }

    // Basic attributes for all investigators
    public InvestigatorCharacter name;
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
