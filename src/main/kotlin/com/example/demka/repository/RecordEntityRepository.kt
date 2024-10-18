package com.example.demka.repository;

import com.example.demka.models.RecordEntity
import org.springframework.data.jpa.repository.JpaRepository

interface RecordEntityRepository : JpaRepository<RecordEntity, String> {
}