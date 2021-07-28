package com.ncr.hackspre;

import java.io.Serializable;

public class Customer implements Serializable {

    private static final long serialID=1L;
    String memberID;
    String name;
    String email;
    String phoneNumber;
    LoyaltyRewards rewards;

    public Customer () {}

    public Customer(String memberID, String name, String email, String phoneNumber, LoyaltyRewards rewards) {
        this.memberID = memberID;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.rewards = rewards;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(final String memberID) {
        this.memberID = memberID;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getRewards() {
        return rewards.getRewards();
    }

    public void setRewards(final LoyaltyRewards rewards) {
        this.rewards = rewards;
    }
}
