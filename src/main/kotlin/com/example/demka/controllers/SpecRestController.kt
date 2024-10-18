package com.example.demka.controllers

import com.example.demka.dto.CreateSpecRq
import com.example.demka.dto.CreateSpecRq2
import com.example.demka.dto.SpecRs
import com.example.demka.services.SpecService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping

@RestController
@RequestMapping("/api/spec")
class SpecRestController(private val specService: SpecService) {
    @PostMapping
    fun create(@RequestBody spec: CreateSpecRq) {
        specService.create(spec)
    }
    @PostMapping("/create")
    fun cerate_spec(@RequestBody spec: CreateSpecRq2){
        specService.create_spec(spec)
    }
    @GetMapping("")
    fun getAll(): List<SpecRs> = specService.getAll()

    @GetMapping("/{specId}")
    fun getById(@PathVariable specId: String): SpecRs = specService.getById(specId)

    @DeleteMapping("/delete/{specId}")
    fun delete(@PathVariable specId: String){
        specService.delete(specId)
    }

}

