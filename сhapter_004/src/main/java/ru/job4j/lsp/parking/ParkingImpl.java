package ru.job4j.lsp.parking;

import java.util.Set;

public class ParkingImpl implements Parking {

    private Set<Vehicle> vehicles;
    @Override
    public boolean addVehicle(Vehicle vehicle) {
        return false;
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }
}
