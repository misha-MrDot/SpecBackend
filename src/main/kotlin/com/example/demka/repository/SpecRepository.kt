package com.example.demka.repository;

import com.example.demka.models.SpecialistEntity

import org.springframework.data.jpa.repository.JpaRepository

interface SpecRepository : JpaRepository<SpecialistEntity, String> {
}