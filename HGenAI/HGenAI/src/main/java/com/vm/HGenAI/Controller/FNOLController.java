package com.vm.HGenAI.controller;

import com.vm.HGenAI.model.FNOL;
import com.vm.HGenAI.service.FNOLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fnol")
public class FNOLController {

    @Autowired
    private FNOLService fnolService;

    @GetMapping("/health")
    public String healthCheck() {
        return "hello world";
    }

    // Create a new FNOL
    @PostMapping
    public FNOL createFNOL(@RequestBody FNOL fnol) {
        return fnolService.createFNOL(fnol);
    }

    // Get all FNOLs
    @GetMapping
    public List<FNOL> getAllFNOLs() {
        return fnolService.getAllFNOLs();
    }

    // Get FNOL by ID
    @GetMapping("/{id}")
    public ResponseEntity<FNOL> getFNOLById(@PathVariable Long id) {
        return fnolService.getFNOLById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update FNOL
    @PutMapping("/{id}")
    public ResponseEntity<FNOL> updateFNOL(@PathVariable Long id, @RequestBody FNOL fnolDetails) {
        return fnolService.updateFNOL(id, fnolDetails)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }



    // Delete FNOL
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFNOL(@PathVariable Long id) {
        if (fnolService.deleteFNOL(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
