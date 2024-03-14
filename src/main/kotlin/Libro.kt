package org.pebiblioteca
import java.util.UUID

class Libro(
    private var id: UUID,
    private val titulo: String,
    private val autor: String,
    private val anioPublicacion: Int,
    private val tematica: String,
    private var estado: EstadoLibro = EstadoLibro.DISPONIBLE
) {

    init {
        require(titulo.isNotBlank()) { "El titulo del libro no puede estar vacio" }
        require(autor.isNotBlank()) { "El autor del libro no puede estar vacio" }
        require(anioPublicacion in 1..2024) { "El año de publicación debe estar entre 1 y 2024" }
        require(tematica.isNotBlank()) { "La tematica del libro no puede estar vacia" }
        require(estado == EstadoLibro.DISPONIBLE || estado == EstadoLibro.PRESTADO) { "El estado del libro debe estar o disponible o prestado" }
    }

    fun obtenerId() = id

    fun obtenerEstado() = estado

    fun obtenerTitulo() = titulo

    fun obtenerAutor() = autor

    fun obtenerAnioPublicacion() = anioPublicacion

    fun obtenerTematica() = tematica

    fun cambiarEstado(nuevoEstado: EstadoLibro) {
        estado = nuevoEstado
    }

    fun cambiarId(nuevoId: UUID) {
        id = nuevoId
    }
}
