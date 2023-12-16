package com.busstop.repository;

import com.busstop.entity.BusStop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BusStopRepo extends JpaRepository<BusStop,Integer>{
    List<BusStop> findByName(String name);
}