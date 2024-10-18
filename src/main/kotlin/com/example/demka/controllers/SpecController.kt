package com.example.demka.controllers

import com.example.demka.dto.CreateRecordForm
import com.example.demka.services.SpecService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping

@Controller
class SpecController(private val specService: SpecService) {
    @GetMapping("/")
    fun home(model:Model):String{

        model.addAttribute("specialists",specService.getAll())
        return "index"
    }
    @GetMapping("/{specId}")
    fun getById(@PathVariable specId: String, model: Model): String{
        model.addAttribute("specialist",specService.getById(specId))
        model.addAttribute("datesSpec",specService.getById(specId).dates)
        return "specform"
    }
}