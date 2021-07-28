package com.ncr.hackspre;

public class Customer {

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

    public LoyaltyRewards getRewards() {
        return rewards;
    }

    public void setRewards(final LoyaltyRewards rewards) {
        this.rewards = rewards;
    }
}
