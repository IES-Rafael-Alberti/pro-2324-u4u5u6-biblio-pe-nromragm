package org.pebiblioteca
import java.util.UUID

class Libro(
    id: UUID,
    titulo: String,
    private val autor: String,
    private val anioPublicacion: Int,
    private val tematica: String,
    estado: EstadoElemento = EstadoElemento.DISPONIBLE
):ElementoBiblioteca(id, titulo, estado) ,Prestable {

    init {
        require(titulo.isNotBlank()) { "El titulo del libro no puede estar vacio" }
        require(autor.isNotBlank()) { "El autor del libro no puede estar vacio" }
        require(anioPublicacion in 1..2024) { "El año de publicación debe estar entre 1 y 2024" }
        require(tematica.isNotBlank()) { "La tematica del libro no puede estar vacia" }
        require(estado == EstadoElemento.DISPONIBLE || estado == EstadoElemento.PRESTADO) { "El estado del libro debe estar o disponible o prestado" }
    }


    fun obtenerTitulo() = titulo

    fun obtenerAutor() = autor

    fun obtenerAnioPublicacion() = anioPublicacion

    fun obtenerTematica() = tematica

    override fun cambiarEstado(nuevoEstadoElemento: EstadoElemento) {
        estado = nuevoEstadoElemento
    }

    fun cambiarId(nuevoId: UUID) {
        id = nuevoId
    }
    override fun prestar() {
        estado = EstadoElemento.PRESTADO
    }

    override fun devolver() {
        estado = EstadoElemento.DISPONIBLE
    }
}
