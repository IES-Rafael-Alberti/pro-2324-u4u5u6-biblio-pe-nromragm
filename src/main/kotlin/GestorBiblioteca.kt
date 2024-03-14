package org.pebiblioteca
import org.pebiblioteca.UtilidadesBiblioteca.generarUUID
import org.pebiblioteca.UtilidadesBiblioteca.mostrarMensaje
import java.util.UUID

class GestorBiblioteca(private val registroPrestamos: RegistroPrestamos) {
    val catalogo = mutableListOf<Libro>()

    fun agregarLibro(libro: Libro) {
        val nuevoId = generarUUID()
        libro.cambiarId(nuevoId)
        catalogo.add(libro)
        mostrarMensaje("Libro: ${libro.obtenerTitulo()} agregado")
    }

    fun eliminarLibro(id: UUID) {
        catalogo.removeAll { it.obtenerId() == id }
    }

    fun realizarPrestamo(usuario: Usuario, libro: Libro) {
        if (libro.obtenerEstado() == EstadoLibro.DISPONIBLE) {
            registroPrestamos.registrarPrestamo(usuario, libro)
            usuario.agregarLibroPrestado(libro)
        }
        else (println("El libro no esta Disponible"))
    }

    fun realizarDevolucion(usuario: Usuario, libro: Libro) {
        if (libro.obtenerEstado() == EstadoLibro.PRESTADO){
            registroPrestamos.registrarDevolucion(usuario, libro)
            usuario.quitarLibroPrestado(libro)
        }
        else (println("El libro no esta Prestado"))
    }


    fun mostrarEstadoLibros() {
        println("Estado de los libros:")
        catalogo.forEach { println("Libro(Id: ${it.obtenerId()}, Titulo: ${it.obtenerTitulo()}, Estadp: ${it.obtenerEstado()})")  }
    }

    fun consultarDisponibilidad(idLibro: UUID) {
        val libro = catalogo.find { it.obtenerId() == idLibro }

        if (libro != null) {
            val disponibilidad = if (libro.obtenerEstado() == EstadoLibro.DISPONIBLE) "disponible" else "prestado"
            println("El libro: ${libro.obtenerTitulo()} esta $disponibilidad.")
        } else {
            println("Error: El libro no se encuentra en el catalogo.")
        }
    }

    fun listarTodosLosLibros(): List<Libro> = catalogo

    fun listarLibrosDisponibles(): List<Libro> = catalogo.filter { it.obtenerEstado() == EstadoLibro.DISPONIBLE }

    fun listarLibrosPrestados(): List<Libro> = catalogo.filter { it.obtenerEstado() == EstadoLibro.PRESTADO }
}
