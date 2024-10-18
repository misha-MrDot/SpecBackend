package com.example.demka.controllers

import com.example.demka.dto.CreateRecordForm
import com.example.demka.dto.CreateRecordRq
import com.example.demka.dto.RecordRs
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
    fun create(@ModelAttribute("formRecord") formRecord:CreateRecordForm, @PathVariable specId:String,bindingResult: BindingResult):String{
        if (bindingResult.hasErrors()){
            return "/specform"
        }

        recordService.create(CreateRecordRq(
            dateTitle = formRecord.dateTitle,
            dateTime = formRecord.dateTime,
            email = formRecord.email,
            phoneNumber = formRecord.phoneNumber,
            specId = specId,
        ))
        return "redirect:/index"
    }
}