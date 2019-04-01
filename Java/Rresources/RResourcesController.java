package com.props.rresources;

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
public class RResourcesController {

    @Autowired
    RResourcesRepository dao;

    @GetMapping("/rresources")
    public List<RResources> getRResourcess() {
        List<RResources> foundRResourcess = dao.findAll();
        return foundRResourcess;
    }

    @GetMapping("/rresources/{id}")
    public ResponseEntity<RResources> getRResources(@PathVariable(value="id") String id) {
    	RResources foundRResources = dao.findById(id).orElse(null);

        if(foundRResources == null) {
            return ResponseEntity.notFound().header("RResources","Nothing found with that id").build();
        }
        return ResponseEntity.ok(foundRResources);
    }

    @PostMapping("/rresources")
    public ResponseEntity<RResources> postRResources(@RequestBody RResources rresources) {

        // saving to DB using instance of the repo interface
    	RResources createdRResources = dao.save(rresources);

        // RespEntity crafts response to include correct status codes.
        return ResponseEntity.ok(createdRResources);
    }

    @DeleteMapping("/rresources/{id}")
    public ResponseEntity<RResources> deleteRResources(@PathVariable(value="id") String id) {
    	RResources foundRResources = dao.findById(id).orElse(null);

        if(foundRResources == null) {
            return ResponseEntity.notFound().header("RResources","Nothing found with that id").build();
        }else {
            dao.delete(foundRResources);
        }
        return ResponseEntity.ok().build();
    }
}