package com.example.demka.services;

import com.example.demka.dto.CreateSpecRq
import com.example.demka.dto.CreateSpecRq2

import com.example.demka.dto.SpecRs
import com.example.demka.mappers.toDto
import com.example.demka.models.SpecialistEntity
import com.example.demka.repository.SpecRepository
import jakarta.transaction.Transactional
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import ru.umom.hackaton.shared.errors.common.NotFoundError

@Service
class SpecService(
    private val specRepository: SpecRepository
) {
    @Transactional
    fun create_spec(dto:CreateSpecRq2){
        specRepository.save(SpecialistEntity(
            title = dto.title,
            description = dto.description,
            photoUrl = dto.photoUrl
        ))
    }
    @Transactional
    fun create(dto: CreateSpecRq) {
        specRepository.save(
            SpecialistEntity(
                title = dto.title,
                description = dto.description,
                photoUrl = dto.photoUrl,
                dates = dto.dates,
            )
        )
    }

    @Transactional
    fun getById(specId: String): SpecRs =
        specRepository.findByIdOrNull(specId)?.toDto() ?: throw NotFoundError("Item not found with id: $specId")

   @Transactional
   fun getAll(): List<SpecRs> = specRepository.findAll().toList().map { it.toDto() }

    @Transactional
    fun delete(id: String) {
        specRepository.deleteById(id)
    }


}