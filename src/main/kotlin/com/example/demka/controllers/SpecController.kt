package com.example.demka.controllers

import com.example.demka.dto.CreateSpecRq
import com.example.demka.dto.SpecRs
import com.example.demka.mappers.toDto
import com.example.demka.models.SpecEntity
import com.example.demka.repository.SpecRepository
import com.example.demka.services.SpecService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import ru.umom.hackaton.shared.errors.common.NotFoundError

@RestController
@RequestMapping("/spec")
class SpecController(private val specService: SpecService) {
    @PostMapping
    fun create(@RequestBody spec: CreateSpecRq) {
        specService.create(spec)
    }

    @GetMapping("")
    fun getAll(): List<SpecRs> = specService.getAll()

    @GetMapping("/{specId}")
    fun getById(@PathVariable specId: String): SpecRs = specService.getById(specId)
}

