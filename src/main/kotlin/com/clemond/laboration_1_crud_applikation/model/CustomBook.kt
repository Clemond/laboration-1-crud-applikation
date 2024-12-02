package com.clemond.laboration_1_crud_applikation.model

import jakarta.persistence.*

@Entity
@Table(name = "CustomBook")
class CustomBook(
    val title: String = "",
    val pages: Number = 0,
    val isRead: Boolean = true,

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null
) {
}