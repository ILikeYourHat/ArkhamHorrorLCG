package com.whitdan.arkhamhorrorlcgcampaignguide.Z_Data;

public enum Difficulty {
    EASY,
    STANDARD,
    HARD,
    EXPERT;

    public int getId() {
        return ordinal();
    }
}
