package com.example.demka.controllers

import com.example.demka.dto.CreateRecordForm
import com.example.demka.models.Date
import com.example.demka.services.RecordService
import com.example.demka.services.SpecService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping

@Controller
class SpecController(private val specService: SpecService,private val recordService: RecordService) {
    @GetMapping("/")
    fun home(model:Model):String{

        model.addAttribute("specialists",specService.getAll())
        return "index"
    }
    @GetMapping("/{specId}")
    fun getById(@PathVariable specId: String, model: Model): String{
        model.addAttribute("specialist",specService.getById(specId))
        val specDates:List<Date> = specService.getById(specId).dates
        for (record in recordService.getAll()){
            for (date in specDates){
                if (date.title==record.dateTitle){
                    for (time in date.times){
                        if (time==record.dateTime){
//                            println(specDates.get(specDates.indexOf(date)).times)
//                            println(specDates.get(specDates.indexOf(date)).times.filter { it != time })
                            specDates.get(specDates.indexOf(date)).times = specDates.get(specDates.indexOf(date)).times.filter { it != time }
                        }
                    }
                }
            }
        }
//        println(recordService.getAll().map { it.dateTime })
//        println(specDates.map { it.times })
        model.addAttribute("datesSpec",specService.getById(specId).dates.filter { it.times.isEmpty().not() })
        return "specform"
    }
}