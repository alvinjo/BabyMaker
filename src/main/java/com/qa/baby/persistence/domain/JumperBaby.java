package com.qa.baby.persistence.domain;

public class JumperBaby {

    private Long babyId;

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

    public JumperBaby(Long babyId, String name, int lifespan){
        this.babyId = babyId;
        this.name = name;
        this.lifespan = lifespan;
    }

    public JumperBaby(Baby baby){
        this.babyId = baby.getId();
        this.name = baby.getName();
        this.lifespan = baby.getLifespan();
    }

    public Long getId() {
        return babyId;
    }

    public void setId(Long babyId) {
        this.babyId = babyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
