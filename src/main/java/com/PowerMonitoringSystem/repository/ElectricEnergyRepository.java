package com.PowerMonitoringSystem.repository;

import com.PowerMonitoringSystem.models.ElectricEnergy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository("ElectricEnergyRepository")
public interface ElectricEnergyRepository extends CrudRepository<ElectricEnergy, Long> {

    @Query(value = "select * from electric_energy EE where EE.datetime between :from and :to", nativeQuery = true)
    List<ElectricEnergy> findAllByDateBetween(Timestamp from, Timestamp to);

}
