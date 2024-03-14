package org.pebiblioteca

import java.util.*

abstract class ElementoBiblioteca(
    var id: UUID,
    val titulo: String,
    var estado: EstadoElemento = EstadoElemento.DISPONIBLE
) {
    abstract fun cambiarEstado(nuevoEstadoElemento: EstadoElemento)
    fun obtenerId() = id
    fun obtenerEstado() = estado
}