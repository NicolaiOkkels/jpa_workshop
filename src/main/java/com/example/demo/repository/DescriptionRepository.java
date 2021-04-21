package com.example.demo.repository;

import com.example.demo.model.Description;
import org.springframework.data.repository.CrudRepository;

public interface DescriptionRepository extends CrudRepository<Description, Long> {
}
