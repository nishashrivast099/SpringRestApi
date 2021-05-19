package com.njclabs.SpringRestApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.njclabs.SpringRestApi.model.Country;


@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

}
