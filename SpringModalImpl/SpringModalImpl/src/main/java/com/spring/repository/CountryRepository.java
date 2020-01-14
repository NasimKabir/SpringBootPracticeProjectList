package com.spring.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.spring.model.Country;

public interface CountryRepository extends PagingAndSortingRepository<Country, Long>{

}
