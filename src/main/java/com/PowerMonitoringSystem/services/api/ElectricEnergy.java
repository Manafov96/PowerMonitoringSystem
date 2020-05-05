package com.PowerMonitoringSystem.services.api;

import java.sql.Timestamp;
import java.util.List;

public interface ElectricEnergy {

    Iterable<com.PowerMonitoringSystem.models.ElectricEnergy> findAll();
    List<com.PowerMonitoringSystem.models.ElectricEnergy> findAllByDateBetween(Timestamp from, Timestamp to);

}
