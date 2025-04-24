package com.vm.HGenAI.service;

import com.vm.HGenAI.model.FNOL;
import com.vm.HGenAI.repository.FNOLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FNOLService {

    @Autowired
    private FNOLRepository fnolRepository;

    // Create a new FNOL
    public FNOL createFNOL(FNOL fnol) {
        return fnolRepository.save(fnol);
    }

    // Get all FNOLs
    public List<FNOL> getAllFNOLs() {
        return fnolRepository.findAll();
    }

    // Get FNOL by ID
    public Optional<FNOL> getFNOLById(Long id) {
        return fnolRepository.findById(id);
    }

    // Update FNOL
    public Optional<FNOL> updateFNOL(Long id, FNOL fnolDetails) {
        return fnolRepository.findById(id)
                .map(fnol -> {
                    fnol.setPolicyholderName(fnolDetails.getPolicyholderName());
                    fnol.setPolicyNumber(fnolDetails.getPolicyNumber());
                    fnol.setPolicyStartDate(fnolDetails.getPolicyStartDate());
                    fnol.setPolicyEndDate(fnolDetails.getPolicyEndDate());
                    return fnolRepository.save(fnol);
                });
    }

    // Delete FNOL
    public boolean deleteFNOL(Long id) {
        return fnolRepository.findById(id)
                .map(fnol -> {
                    fnolRepository.delete(fnol);
                    return true;
                })
                .orElse(false);
    }
}