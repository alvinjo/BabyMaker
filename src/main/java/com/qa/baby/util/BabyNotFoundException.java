package com.qa.baby.util;

public class BabyNotFoundException extends RuntimeException {

    public BabyNotFoundException(Long id){
        super("Baby with id: " + id + " does not exist.");
    }

}
