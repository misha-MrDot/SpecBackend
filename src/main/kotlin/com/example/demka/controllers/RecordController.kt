package com.example.demka.controllers

import com.example.demka.dto.CreateRecordForm
import com.example.demka.dto.CreateRecordRq
import com.example.demka.dto.RecordRs
import com.example.demka.models.RecordEntity
import com.example.demka.services.RecordService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/record")
class RecordController(private val recordService: RecordService) {
    @GetMapping("/")
    fun getAll():List<RecordRs> = recordService.getAll()
    @GetMapping("/{recordId}")
    fun getById(@PathVariable recordId:String):RecordRs=recordService.getById(recordId)
    @PostMapping("/{specId}")
    fun create(@RequestParam(value = "dateTitle", required = false) dateTitle:String,@RequestParam(value = "dateTime", required = false) dateTime:String,@RequestParam(value = "email", required = false) email:String,@RequestParam(value = "phoneNumber", required = false) phoneNumber:String, @PathVariable specId:String):String{
        recordService.create(CreateRecordRq(
            dateTitle=dateTitle,
            dateTime=dateTime,
            email=email,
            phoneNumber=phoneNumber,
            specId=specId,
        ))
        return "redirect:/"
    }
}