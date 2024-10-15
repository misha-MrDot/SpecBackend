package com.example.demka.services;

import com.example.demka.dto.CreateSpecRq

import com.example.demka.dto.SpecRs
import com.example.demka.mappers.toDto
import com.example.demka.models.SpecEntity
import com.example.demka.repository.SpecRepository
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import ru.umom.hackaton.shared.errors.common.NotFoundError

@Service
class SpecService(
    private val specRepository: SpecRepository
) {

    @Transactional
    fun create(dto: CreateSpecRq) {
        specRepository.save(
            SpecEntity(
                title = dto.title,
                description = dto.description,
                photoUrl = dto.photoUrl,
            )
        )
    }

    @Transactional
    fun getById(specId: String): SpecRs =
        specRepository.findByIdOrNull(specId)?.toDto() ?: throw NotFoundError("Item not found with id: $specId")

   @Transactional
   fun getAll(): List<SpecRs> = specRepository.findAll().toList().map { it.toDto() }
}