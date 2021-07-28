package com.ncr.hackspre;

import java.io.Serializable;

public class LoyaltyRewards implements Serializable {

    private static final long serialID = 2L;
    String rewardsID;
    int rewards;

    public LoyaltyRewards(final String rewardsID, final int rewards) {
        this.rewardsID = rewardsID;
        this.rewards = rewards;
    }

    public String getRewardsID() {
        return rewardsID;
    }

    public void setRewardsID(final String rewardsID) {
        this.rewardsID = rewardsID;
    }

    public int getRewards() {
        return rewards;
    }

    public void setRewards(final int rewards) {
        this.rewards = rewards;
    }

}
