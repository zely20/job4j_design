package ru.job4j.lsp.parking;

import java.util.Set;

public interface Parking {

    public boolean addVehicle(Vehicle vehicle);
    public Set<Vehicle> getVehicles();
}
