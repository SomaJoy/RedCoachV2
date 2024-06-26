package com.redCoach.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "busV2")
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "bus_no", unique = true, nullable = false)
    private String busNo;

    @Column(name = "total_seat", nullable = false)
    private int totalSeat;

    @Column(name = "route", nullable = false)
    private String route;
}
