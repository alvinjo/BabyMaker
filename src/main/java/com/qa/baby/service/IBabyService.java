package com.qa.baby.service;

import com.qa.baby.persistence.domain.Baby;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface IBabyService {

    List<Baby> getBabies();

    Baby getBaby(Long id);

    Baby addBaby(Baby baby);

    ResponseEntity<Object> killBaby(Long id);

    ResponseEntity<Object> updateBaby(Baby baby, Long id);

}
