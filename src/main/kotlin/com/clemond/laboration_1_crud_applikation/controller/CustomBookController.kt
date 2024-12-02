package com.clemond.laboration_1_crud_applikation.controller

import com.clemond.laboration_1_crud_applikation.model.CustomBook
import com.clemond.laboration_1_crud_applikation.repository.CustomBookRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

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

    @PutMapping
    fun putBook(@RequestBody updatedBook: CustomBook): ResponseEntity<String> {
        val bookId = updatedBook.id ?: return ResponseEntity.status(400).body("Book ID is required")

        val existingBookOptional = customBookRepository.findById(bookId)

        if (existingBookOptional.isPresent) {
            val existingBook = existingBookOptional.get()

            existingBook.title = updatedBook.title
            existingBook.pages = updatedBook.pages
            existingBook.isRead = updatedBook.isRead

            customBookRepository.save(existingBook)

            return ResponseEntity.status(200).body("Book updated successfully")
        }

        return ResponseEntity.status(404).body("Book not found")
    }

}