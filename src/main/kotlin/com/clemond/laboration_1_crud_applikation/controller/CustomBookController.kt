package com.clemond.laboration_1_crud_applikation.controller

import com.clemond.laboration_1_crud_applikation.model.CustomBook
import com.clemond.laboration_1_crud_applikation.repository.CustomBookRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
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

    @GetMapping
    fun getBookById(@RequestParam("id") id: Long): ResponseEntity<CustomBook>{

        val foundOptionalBook = customBookRepository.findById(id)

        if (foundOptionalBook.isPresent) {
            val notOptionalBook = foundOptionalBook.get()

            return ResponseEntity.status(200).body(notOptionalBook)
        }

        return ResponseEntity.notFound().build()
    }

    @DeleteMapping
    fun deleteBookById(@RequestParam("id") id: Long): ResponseEntity<String> {
        val foundOptionalBook = customBookRepository.findById(id)

        if (foundOptionalBook.isPresent) {
            val notOptionalBook = foundOptionalBook.get()

            customBookRepository.delete(notOptionalBook)

            return ResponseEntity.status(200).body("Book deleted")

        }

        return ResponseEntity.notFound().build()
    }

}