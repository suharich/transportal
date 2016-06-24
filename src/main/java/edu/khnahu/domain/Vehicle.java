/**
 * @author nau
 */
package edu.khnahu.domain;

import org.springframework.data.annotation.Id;

public class Vehicle
{
    @Id
    private String vehicle_id;
    private byte type;          // тип кузова
    private double capacity;    // грузоподъемность, т
    private double costsPer1km; // переменная составляющая себестоимости, у.е./км
    private double costsPer1h;  // постоянная составляющая себестоимости, у.е./ч

    public Vehicle(byte type, double capacity)
    {
        this.type = type;
        this.capacity = capacity;
    }
}
