package com.busstop.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BusStopDto {
    private int id;
    private String name;
    private int distance;
    private boolean visited;
    private String pickUpLocation;
}