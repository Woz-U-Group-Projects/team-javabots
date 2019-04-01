package com.props.oresources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OResourcesController {

    @Autowired
    OResourcesRepository dao;

    @GetMapping("/oresources")
    public List<OResources> getOResourcess() {
        List<OResources> foundOResourcess = dao.findAll();
        return foundOResourcess;
    }

    @GetMapping("/oresources/{id}")
    public ResponseEntity<OResources> getOResources(@PathVariable(value="id") String id) {
    	OResources foundOResources = dao.findById(id).orElse(null);

        if(foundOResources == null) {
            return ResponseEntity.notFound().header("OResources","Nothing found with that id").build();
        }
        return ResponseEntity.ok(foundOResources);
    }

    @PostMapping("/oresources")
    public ResponseEntity<OResources> postOResources(@RequestBody OResources oresources) {

        // saving to DB using instance of the repo interface
    	OResources createdOResources = dao.save(oresources);

        // RespEntity crafts response to include correct status codes.
        return ResponseEntity.ok(createdOResources);
    }

    @DeleteMapping("/oresources/{id}")
    public ResponseEntity<OResources> deleteOResources(@PathVariable(value="id") String id) {
    	OResources foundOResources = dao.findById(id).orElse(null);

        if(foundOResources == null) {
            return ResponseEntity.notFound().header("OResources","Nothing found with that id").build();
        }else {
            dao.delete(foundOResources);
        }
        return ResponseEntity.ok().build();
    }
}