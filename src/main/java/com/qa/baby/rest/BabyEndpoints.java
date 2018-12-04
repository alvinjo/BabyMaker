package com.qa.baby.rest;

import com.qa.baby.persistence.domain.Baby;
import com.qa.baby.persistence.domain.JumperBaby;
import com.qa.baby.service.IBabyService;
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

    @Value("${activemq.queue.name}")
    private String queueName;

    @GetMapping("/getBabies")
    public List<Baby> getBabies() {
        return service.getBabies();
    }

    @GetMapping("/getBaby")
    public Baby getBaby(Long id) {
        return service.getBaby(id);
    }

    @DeleteMapping("/killBaby")
    public ResponseEntity<Object> deleteBaby(@RequestBody Long id){
        sendToDelete(service.getBaby(id));
        return service.killBaby(id);
    }


    @PutMapping("/updateBaby/{id}")
    public ResponseEntity<Object> updateBaby(@RequestBody Baby baby, @PathVariable Long id){
        return service.updateBaby(baby, id);
    }


    @PostMapping("/addBaby/{length}")
    public Baby addBaby(@RequestBody Baby baby, @PathVariable int length){
        String generatedName = restTemplate.getForObject(pathBabyNameGen+pathGenerateName+length+"/"+baby.getName(), String.class);
        baby.setName(generatedName);

        String lifespan = restTemplate.getForObject(pathBabyLifespan+pathPredict, String.class);
        baby.setLifespan(Integer.parseInt(lifespan));

        sendToQueue(baby);

        return service.addBaby(baby);
    }

    private void sendToDelete(Baby baby){
        jmsTemplate.convertAndSend("BabyQueueDelete", new JumperBaby(baby));
    }

    private void sendToQueue(Baby baby){
        jmsTemplate.convertAndSend("BabyQueue", new JumperBaby(baby));
    }

}