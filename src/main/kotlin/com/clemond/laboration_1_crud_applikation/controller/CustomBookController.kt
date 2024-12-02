package com.clemond.laboration_1_crud_applikation.controller

import com.clemond.laboration_1_crud_applikation.model.CustomBook
import com.clemond.laboration_1_crud_applikation.repository.CustomBookRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/book")
class CustomBookController(
    private val customBookRepository: CustomBookRepository
) {

    @PostMapping
    fun postNewBook(@RequestBody customBook: CustomBook): ResponseEntity<String> {

        customBookRepository.save(customBook)

        return ResponseEntity.status(201).body("Book Created")
    }

}