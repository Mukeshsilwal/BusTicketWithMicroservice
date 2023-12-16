package com.busstop.service;



import com.busstop.payloads.BusStopDto;

import java.util.List;

public interface BusStopService {
    BusStopDto createBusStop(BusStopDto busStopDto);
    BusStopDto updateBusStop(BusStopDto busStopDto,int id);
    void deleteBusStop(int id);
    List<BusStopDto> getAllBusStops();
    BusStopDto getBusStopById(int id);
    List<BusStopDto> getBusByBusName(String name);
}

