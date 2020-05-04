package com.PowerMonitoringSystem.controllers;

import com.PowerMonitoringSystem.services.api.ElectricEnergy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiElectricEnergyController {

    @Autowired
    private ElectricEnergy electricEnergy;

    @GetMapping("/api/v1/energies")
    public ResponseEntity<Iterable<com.PowerMonitoringSystem.models.ElectricEnergy>> index() {
        Iterable<com.PowerMonitoringSystem.models.ElectricEnergy> energies = electricEnergy.findAll();
        return new ResponseEntity<>(energies, HttpStatus.OK);
    }

}
