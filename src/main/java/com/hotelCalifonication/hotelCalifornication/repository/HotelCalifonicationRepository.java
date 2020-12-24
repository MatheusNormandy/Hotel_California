package com.hotelCalifonication.hotelCalifornication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotelCalifonication.hotelCalifornication.model.HotelCalifornication;

@Repository
public interface HotelCalifonicationRepository extends JpaRepository<HotelCalifornication, Long> {}
