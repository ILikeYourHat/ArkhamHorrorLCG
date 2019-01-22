package com.whitdan.arkhamhorrorlcgcampaignguide.B_CampaignSetup.chaosbag;

import java.util.ArrayList;
import java.util.List;

public class ChaosBag {

    private List<ChaosBagToken> list = new ArrayList<>();

    public int[] get() {
        int[] table = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (ChaosBagToken token : list) {
            int index = token.ordinal() + 1;
            table[index]++;
        }
        return table;
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
