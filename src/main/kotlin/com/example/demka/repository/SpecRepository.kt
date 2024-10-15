package com.example.demka.repository;

import com.example.demka.models.SpecEntity
import org.springframework.data.jpa.repository.JpaRepository

interface SpecRepository : JpaRepository<SpecEntity, String> {
}