package org.pebiblioteca

import java.util.*

object UtilidadesBiblioteca {
    fun generarUUID(): UUID {
        val uuid = UUID.randomUUID()
        return uuid
    }

    fun mostrarMensaje(mensaje: String) {
        println(mensaje)
    }
}