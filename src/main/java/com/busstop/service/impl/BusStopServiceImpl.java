package com.busstop.service.impl;
import com.busstop.entity.BusStop;
import com.busstop.excepation.ResourceNotFoundException;
import com.busstop.payloads.BusStopDto;
import com.busstop.repository.BusStopRepo;
import com.busstop.service.BusStopService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class BusStopServiceImpl implements BusStopService {

    private final BusStopRepo busStopRepo;
    private final ModelMapper modelMapper;

    public BusStopServiceImpl(BusStopRepo busStopRepo, ModelMapper modelMapper) {
        this.busStopRepo = busStopRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public BusStopDto createBusStop(BusStopDto busStopDto) {
        BusStop busStop=this.dtoToBusStop(busStopDto);
        BusStop busStop1=this.busStopRepo.save(busStop);
        return busStopToDto(busStop1);
    }

    @Override
    public BusStopDto updateBusStop(BusStopDto busStopDto, int id) {
        BusStop busStop=this.dtoToBusStop(busStopDto);
        busStop.setDistance(busStopDto.getDistance());
        busStop.setName(busStopDto.getName());
        BusStop busStop1=this.busStopRepo.save(busStop);
        return busStopToDto(busStop1);
    }

    @Override
    public void deleteBusStop(int id) {
        BusStop busStop=this.busStopRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("BusStop","id",id));
        busStopRepo.delete(busStop);

    }

    @Override
    public List<BusStopDto> getAllBusStops() {
        List<BusStop> busStops=this.busStopRepo.findAll();
        return busStops.stream().map(this::busStopToDto).collect(Collectors.toList());
    }

    @Override
    public BusStopDto getBusStopById(int id) {
        BusStop busStop=this.busStopRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("BusStop","id",id));
        return busStopToDto(busStop);
    }

    @Override
    public List<BusStopDto> getBusByBusName(String name) {
        List<BusStop> busStops=this.busStopRepo.findByName(name);
        return busStops.stream().map(this::busStopToDto).collect(Collectors.toList());
    }

    public BusStop dtoToBusStop(BusStopDto busStopDto){
        return this.modelMapper.map(busStopDto, BusStop.class);
    }
    public BusStopDto busStopToDto(BusStop busStop){
        return this.modelMapper.map(busStop,BusStopDto.class);
    }
}
