package com.clemond.laboration_1_crud_applikation.repository

import com.clemond.laboration_1_crud_applikation.model.CustomBook
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomBookRepository: JpaRepository<CustomBook, Long>{
}