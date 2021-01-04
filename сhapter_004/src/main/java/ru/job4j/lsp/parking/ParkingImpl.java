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
        if(vehicle instanceof Car && carPlace > 0){
            carPlace--;
            vehicles.add(vehicle);
            return true;
        }
        if(vehicle instanceof Track && trackPlace > 0) {
            trackPlace--;
            vehicles.add(vehicle);
            return true;
        }
        if(vehicle instanceof Track && carPlace > vehicle.size()) {
            carPlace = carPlace - vehicle.size();
            vehicles.add(vehicle);
            return true;
        }
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
