package com.redCoach.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BusDto {

    private int id;
    private String busNo;
    private int totalSeat;
    private String route;
}
