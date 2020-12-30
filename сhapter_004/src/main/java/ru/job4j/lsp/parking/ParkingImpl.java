package ru.job4j.lsp.parking;

import java.util.HashSet;
import java.util.Set;

public class ParkingImpl implements Parking {

    private int trackPlace;
    private int carPlace;
    private Set<Vehicle> vehicles;

    public ParkingImpl(int trackPlace, int carPlace) {
        this.trackPlace = trackPlace;
        this.carPlace = carPlace;
        vehicles = new HashSet<>();
    }

    @Override
    public boolean addVehicle(Vehicle vehicle) {
        return false;
    }

    @Override
    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    @Override
    public int getTrackPlace() {
        return trackPlace;
    }

    @Override
    public int getCarPlace() {
        return carPlace;
    }
}
