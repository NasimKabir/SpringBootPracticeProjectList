package com.nasim.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nasim.model.Documents;

public interface DocumentsRepository extends JpaRepository<Documents,Long> {

}
