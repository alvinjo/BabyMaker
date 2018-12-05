package com.qa.baby.service;

import com.qa.baby.persistence.domain.Baby;
import com.qa.baby.persistence.repository.BabyRepository;
import com.qa.baby.util.BabyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BabyServiceImpl implements IBabyService {


    @Autowired
    BabyRepository repo;

    @Override
    public List<Baby> getBabies() {
        return repo.findAll();
    }

    @Override
    public Baby getBaby(Long id) {
        Optional<Baby> baby = repo.findById(id);
        return baby.orElseThrow(() -> new BabyNotFoundException(id));
    }

    @Override
    public Baby addBaby(Baby baby) {
        return repo.save(baby);
    }

    @Override
    public ResponseEntity<Object> killBaby(Long id) {
        if(babyExists(id)){
            repo.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Object> updateBaby(Baby baby, Long id) {
        if(babyExists(id)){
            baby.setBabyId(id);
            repo.save(baby);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.ok().build();
    }

    private boolean babyExists(Long id){
        Optional<Baby> dbBaby = repo.findById(id);
        return dbBaby.isPresent();
    }
}
