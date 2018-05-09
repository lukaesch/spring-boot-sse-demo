package com.lionmint.demo.sse.domain;

public class Hotel {

    private String name;
    private int availableRooms;

    public Hotel(String name, int availableRooms) {
        this.name = name;
        this.availableRooms = availableRooms;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAvailableRooms() {
        return availableRooms;
    }

    public void setAvailableRooms(int availableRooms) {
        this.availableRooms = availableRooms;
    }
}
