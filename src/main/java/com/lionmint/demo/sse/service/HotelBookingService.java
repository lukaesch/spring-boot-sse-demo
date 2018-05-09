package com.lionmint.demo.sse.service;

import com.lionmint.demo.sse.domain.Hotel;
import com.lionmint.demo.sse.domain.HotelBooking;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.util.*;
import java.util.stream.Stream;

@Service
public class HotelBookingService {

    private List<Hotel> hotelList = new ArrayList<>();
    private List<String> hotelNames = Arrays.asList("Hostal Amor,Hotel Rabisson,Hotel Lawina,AirSleep".split(","));

    @PostConstruct
    public void initAfterStartup() {
        hotelNames.forEach(hotelName -> {
            hotelList.add(new Hotel(hotelName, generateRandomAvailableRooms()));
        });
    }

    public Flux<HotelBooking> getBookings() {
        Flux<Long> interval = Flux.interval(Duration.ofSeconds(1));
        interval.subscribe((i) -> hotelList.forEach(hotel -> {
            if(hotel.getAvailableRooms() > 0) {
                hotel.setAvailableRooms(hotel.getAvailableRooms() - 1);
            }
        }));
        Flux<HotelBooking> bookingFlux = Flux.fromStream(Stream.generate(() -> new HotelBooking(getRandomUser(), getRandomHotel(), new Date())));
        return Flux.zip(interval, bookingFlux).map(Tuple2::getT2);
    }

    private String getRandomUser() {
        String users[] = "Alejandro,Andi,Dolado,Dani,Adri,Jose,Lukas".split(",");
        return users[new Random().nextInt(users.length)];
    }

    private Hotel getRandomHotel() {
        return hotelList.get(new Random().nextInt(hotelList.size()));
    }

    private int generateRandomAvailableRooms() {
        float min = 30;
        float max = 50;
        return (int) (min + new Random().nextFloat() * (max - min));
    }
}
