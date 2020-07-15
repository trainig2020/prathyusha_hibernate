package org.anusha.dto;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
public class FourWheeler extends Vehicle {
    private String SteeringWheel;

    public String getSteeringWheel() {
        return SteeringWheel;
    }

    public void setSteeringWheel(String steeringHandle) {
        SteeringWheel = steeringHandle;
    }

}

