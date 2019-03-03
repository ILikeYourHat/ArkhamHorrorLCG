package com.whitdan.arkhamhorrorlcgcampaignguide.B_CampaignSetup.chaosbag;

import java.util.ArrayList;
import java.util.List;

public class ChaosBag {

    private List<ChaosBagToken> list = new ArrayList<>();

    public List<Integer> get() {
        List<Integer> tokens = new ArrayList<>();
        for (ChaosBagToken token : list) {
            tokens.add(token.ordinal() + 1);
        }
        return tokens;
    }

    public List<ChaosBagToken> getTokens() {
        return new ArrayList<>(list);
    }

    public static class Builder {

        private ChaosBag bag = new ChaosBag();

        public Builder add(ChaosBagToken token, int count) {
            for (int i = 0; i < count; i++) {
                bag.list.add(token);
            }
            return this;
        }

        public ChaosBag build() {
            return bag;
        }

    }

}
