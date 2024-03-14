package org.pebiblioteca
import java.util.UUID

data class Libro(
    val id: UUID,
    val titulo: String,
    val autor: String,
    val anioPublicacion: Int,
    val tematica: String,
    var estado: EstadoLibro = EstadoLibro.DISPONIBLE
)