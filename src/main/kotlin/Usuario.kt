package org.pebiblioteca

import java.util.UUID

class Usuario(val id: UUID, val nombre: String) {
    private val elementosPrestados = mutableListOf<ElementoBiblioteca>()

    fun agregarLibroPrestado(elemento: ElementoBiblioteca) {
        elementosPrestados.add(elemento)
    }

    fun quitarElementoPrestado(elemento: ElementoBiblioteca) {
        elementosPrestados.remove(elemento)
    }

    fun obtenerElementoPrestados(): List<ElementoBiblioteca> {
        return elementosPrestados.toList()
    }
}