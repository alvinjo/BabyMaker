package com.qa.baby.persistence.domain;

public class JumperBaby {

    private String babyId;

    private String name;

    private int lifespan;

    public JumperBaby(){

    }

    public int getLifespan() {
        return lifespan;
    }

    public void setLifespan(int lifespan) {
        this.lifespan = lifespan;
    }

    public JumperBaby(String babyId, String name, int lifespan){
        this.babyId = babyId;
        this.name = name;
        this.lifespan = lifespan;
    }

    public String getBabyId() {
        return babyId;
    }

    public void setBabyId(String babyId) {
        this.babyId = babyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return "{\"babyId\":\"" + babyId + "\", \"name\":\"" + "\", \"lifespan\":\"" + lifespan + "\"}";
    }

}
