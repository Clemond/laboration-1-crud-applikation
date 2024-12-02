package com.clemond.laboration_1_crud_applikation.model

import jakarta.persistence.*

@Entity
@Table(name = "CustomBook")
class CustomBook(
    var title: String = "",
    var pages: Int = 0,
    var isRead: Boolean = true,

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null
) {
}