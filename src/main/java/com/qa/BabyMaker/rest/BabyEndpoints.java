package com.qa.BabyMaker.rest;

import com.qa.BabyMaker.persistence.domain.Baby;
import com.qa.BabyMaker.service.IBabyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@CrossOrigin
@RequestMapping("/baby")
@RestController
public class BabyEndpoints {

    @Autowired
    IBabyService service;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private JmsTemplate jmsTemplate;

    @Value("${path.babyNameGen}")
    private String pathBabyNameGen;
    @Value("${path.generateName}")
    private String pathGenerateName;

    @Value("${path.babyLifespan}")
    private String pathBabyLifespan;
    @Value("${path.predictLife}")
    private String pathPredict;

    @GetMapping("/getBabies")
    public List<Baby> getBabies() {
        return service.getBabies();
    }

    @GetMapping("/getBaby")
    public Baby getBaby(Long id) {
        return service.getBaby(id);
    }

    @DeleteMapping("/killBaby")
    public ResponseEntity<Object> deleteBaby(Long id){
        return service.killBaby(id);
    }

    @PutMapping("/updateBaby")
    public ResponseEntity<Object> updateBaby(Baby baby, Long id){
        return service.updateBaby(baby, id);
    }


    @PostMapping("/addBaby/{length}")
    public Baby addBaby(@RequestBody Baby baby, @PathVariable int length){
        String generatedName = restTemplate
                .getForObject(pathBabyNameGen+pathGenerateName+length+"/"+baby.getName(), String.class);
        baby.setName(generatedName);

        String lifespan = restTemplate.getForObject(pathBabyLifespan+pathPredict, String.class);
        baby.setLifespan(Integer.parseInt(lifespan));
        return service.addBaby(baby);
    }

}
