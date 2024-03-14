package org.pebiblioteca

class RegistroPrestamos {
    private val prestamosActuales: MutableList<Prestamo> = mutableListOf()
    private val historialPrestamos: MutableList<Prestamo> = mutableListOf()

    fun registrarPrestamo(usuario: Usuario, libro: Libro) {
        val prestamo = Prestamo(usuario, libro)
        prestamosActuales.add(prestamo)
        libro.cambiarEstado(EstadoLibro.PRESTADO)
        println("Prestamo registrado: ${libro.obtenerTitulo()} de ${usuario.nombre}")
    }

    fun registrarDevolucion(usuario: Usuario, libro: Libro) {
        val prestamo = prestamosActuales.find { it.libro == libro && it.usuario == usuario }
        if (prestamo != null) {
            prestamosActuales.remove(prestamo)
            historialPrestamos.add(prestamo)
            libro.cambiarEstado(EstadoLibro.DISPONIBLE)
            println("Devolucion registrada: ${libro.obtenerTitulo()} de ${usuario.nombre}")
        } else {
            println("Error: No se encontro el prestamo")
        }
    }

    fun consultarHistorialPrestamosLibro(libro: Libro): List<Prestamo> {
        return historialPrestamos.filter { it.libro == libro }
    }

    fun consultarHistorialPrestamosUsuario(usuario: Usuario): List<Prestamo> {
        return historialPrestamos.filter { it.usuario == usuario }
    }
}
