package com.lionmint.demo.sse.domain;


import java.util.Date;

public class HotelBooking {
    private String user;
    private Hotel hotel;
    private Date when;

    public HotelBooking(String user, Hotel hotel, Date when) {
        this.user = user;
        this.hotel = hotel;
        this.when = when;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Date getWhen() {
        return when;
    }

    public void setWhen(Date when) {
        this.when = when;
    }
}
