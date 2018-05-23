package com.aaron.crud.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.aaron.crud.entity.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long>{}