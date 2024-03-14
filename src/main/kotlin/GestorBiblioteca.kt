package org.pebiblioteca
import org.pebiblioteca.UtilidadesBiblioteca.generarUUID
import java.util.UUID

class GestorBiblioteca {
    val catalogo = mutableListOf<Libro>()
    private val registroPrestamos = mutableListOf<Pair<UUID, String>>()

    fun agregarLibro(libro: Libro) {
        val nuevoId = generarUUID()
        libro.id = nuevoId
        catalogo.add(libro)
        println("Libro: ${libro.titulo} agregado")
    }


    fun eliminarLibro(id: UUID) {
        catalogo.removeAll { it.id == id }
    }

    fun registrarPrestamo(idLibro: UUID) {
        val libro = catalogo.find { it.id == idLibro }

        if (libro != null && libro.estado == EstadoLibro.DISPONIBLE) {
            libro.estado = EstadoLibro.PRESTADO
            registroPrestamos.add(Pair(idLibro, "prestado"))
            println("Libro prestado correctamente")
        } else {
            println("Error: El libro no esta disponible.")
        }
    }

    fun devolverLibro(idLibro: UUID) {
        val libro = catalogo.find { it.id == idLibro }

        if (libro != null && libro.estado == EstadoLibro.PRESTADO) {
            libro.estado = EstadoLibro.DISPONIBLE
            println("Libro devuelto correctamente")
        } else {
            println("Error: El libro no esta prestado.")
        }
    }

    fun consultarDisponibilidad(idLibro: UUID) {
        val libro = catalogo.find { it.id == idLibro }

        if (libro != null) {
            val disponibilidad = if (libro.estado == EstadoLibro.DISPONIBLE) "disponible" else "prestado"
            println("El libro '${libro.titulo}' esta $disponibilidad.")
        } else {
            println("Error: El libro no se encuentra en el catálogo.")
        }
    }

    fun mostrarEstadoLibros() {
        println("Estado de los libros:")
        catalogo.forEach { println("Libro(Id: ${it.id}, Titulo: ${it.titulo}, Estado: ${it.estado})") }
    }

    fun listarTodosLosLibros(): List<Libro> = catalogo

    fun listarLibrosDisponibles(): List<Libro> = catalogo.filter { it.estado == EstadoLibro.DISPONIBLE }

    fun listarLibrosPrestados(): List<Libro> = catalogo.filter { it.estado == EstadoLibro.PRESTADO }
}
