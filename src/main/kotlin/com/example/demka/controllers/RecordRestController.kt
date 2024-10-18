package com.example.demka.controllers

import com.example.demka.dto.CreateRecordRq
import com.example.demka.dto.RecordRs
import com.example.demka.services.RecordService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping

@RestController
@RequestMapping("/api/record")
class RecordRestController(private val recordService: RecordService) {
    @GetMapping("")
    fun getAll():List<RecordRs> = recordService.getAll()
    @GetMapping("/{recordId}")
    fun getById(@PathVariable recordId:String):RecordRs=recordService.getById(recordId)
    @PostMapping("")
    fun create(@RequestBody dto:CreateRecordRq){
        recordService.create(dto)
    }
    @DeleteMapping("/{recordId}")
    fun delete(@PathVariable recordId:String){
        recordService.delete(recordId)
    }

}

