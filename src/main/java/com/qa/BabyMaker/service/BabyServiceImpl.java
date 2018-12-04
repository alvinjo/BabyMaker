package com.qa.BabyMaker.service;

import com.qa.BabyMaker.persistence.domain.Baby;
import com.qa.BabyMaker.persistence.repository.BabyRepository;
import com.qa.BabyMaker.util.BabyNotFoundException;
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
    public ResponseEntity<Object> deleteBaby(Long id) {
        Optional<Baby> baby = repo.findById(id);
        if(baby.isPresent()){
            repo.delete(baby.get());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Object> updateBaby(Baby baby, Long id) {
        Optional<Baby> dbBaby = repo.findById(id);
        if(dbBaby.isPresent()){
            baby.setId(id);
            repo.save(baby);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.ok().build();
    }
}
