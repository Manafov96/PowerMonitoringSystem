package com.PowerMonitoringSystem.services.impl;

import com.PowerMonitoringSystem.repository.ElectricEnergyRepository;
import com.PowerMonitoringSystem.services.api.ElectricEnergy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service("electricEnergyService")
public class ElectricEnergyServiceImpl implements ElectricEnergy {


    @Autowired
    ElectricEnergyRepository electricEnergyRepository;

    @Override
    public Iterable<com.PowerMonitoringSystem.models.ElectricEnergy> findAll() {
        return electricEnergyRepository.findAll();
    }

    @Override
    public List<com.PowerMonitoringSystem.models.ElectricEnergy> findAllByDateBetween(Timestamp from, Timestamp to) {
        return electricEnergyRepository.findAllByDateBetween(from, to);
    }
}
