package com.qa.BabyMaker.persistence.domain;

public class Baby {

    private Long id;

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

    public Baby(Long id, String name, int lifespan){
        this.id = id;
        this.name = name;
        this.lifespan = lifespan;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
