package com.qa.baby.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Baby {

    @Id
    @GeneratedValue
    private Long babyId;

    private String name;

    private int lifespan;

    public Baby(){

    }

    public int getLifespan() {
        return lifespan;
    }

    public void setLifespan(int lifespan) {
        this.lifespan = lifespan;
    }

    public Baby(Long babyId, String name, int lifespan){
        this.babyId = babyId;
        this.name = name;
        this.lifespan = lifespan;

    }

    public Long getBabyId() {
        return babyId;
    }

    public void setBabyId(Long babyId) {
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
        return "ID: "+ babyId + ", Name: " + name + ", Lifespan: " + lifespan;
    }

}
