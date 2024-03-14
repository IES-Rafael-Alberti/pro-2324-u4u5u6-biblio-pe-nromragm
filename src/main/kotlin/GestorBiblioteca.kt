package org.pebiblioteca
import java.util.UUID

class GestorBiblioteca(private val registroPrestamos: RegistroPrestamos) {
    val catalogo = mutableListOf<ElementoBiblioteca>()

    fun agregarElemento(elemento: ElementoBiblioteca) {
        catalogo.add(elemento)
    }

    fun eliminarElemento(id: UUID) {
        catalogo.removeAll { it.obtenerId() == id }
    }

    fun realizarPrestamo(usuario: Usuario, elemento: ElementoBiblioteca) {
        if (elemento.obtenerEstado() == EstadoElemento.DISPONIBLE) {
            registroPrestamos.registrarPrestamo(usuario, elemento)
            usuario.agregarLibroPrestado(elemento)
        }
        else println("El Elemento no esta Disponible")
    }

    fun realizarDevolucion(usuario: Usuario, elemento: ElementoBiblioteca) {
        if (elemento.obtenerEstado() == EstadoElemento.PRESTADO){
            registroPrestamos.registrarDevolucion(usuario, elemento)
            usuario.quitarElementoPrestado(elemento)
        }
        else println("El libro no esta Prestado")
    }


    fun mostrarEstadoLibros() {
        println("Estado de los libros:")
        catalogo.forEach { println("Libro(Id: ${it.obtenerId()}, Estado: ${it.obtenerEstado()})")  }
    }

    fun consultarDisponibilidad(idLibro: UUID) {
        val libro = catalogo.find { it.obtenerId() == idLibro }

        if (libro != null) {
            val disponibilidad = if (libro.obtenerEstado() == EstadoElemento.DISPONIBLE) "disponible" else "prestado"
            println("El elemento esta $disponibilidad.")
        } else {
            println("Error: El libro no se encuentra en el catalogo.")
        }
    }

    fun listarTodosLosLibros(): List<ElementoBiblioteca> = catalogo

    fun listarLibrosDisponibles(): List<ElementoBiblioteca> = catalogo.filter { it.obtenerEstado() == EstadoElemento.DISPONIBLE }

    fun listarLibrosPrestados(): List<ElementoBiblioteca> = catalogo.filter { it.obtenerEstado() == EstadoElemento.PRESTADO }
}
