package org.pebiblioteca

import java.util.UUID

class Usuario(val id: UUID, val nombre: String) {
    private val librosPrestados = mutableListOf<Libro>()

    fun agregarLibroPrestado(libro: Libro) {
        librosPrestados.add(libro)
    }

    fun quitarLibroPrestado(libro: Libro) {
        librosPrestados.remove(libro)
    }

    fun obtenerLibrosPrestados(): List<Libro> {
        return librosPrestados.toList()
    }
}