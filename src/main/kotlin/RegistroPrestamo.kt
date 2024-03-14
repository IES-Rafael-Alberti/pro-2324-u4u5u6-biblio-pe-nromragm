package org.pebiblioteca

class RegistroPrestamos:IGestorPrestamos {
    private val prestamosActuales: MutableList<Prestamo> = mutableListOf()
    private val historialPrestamos: MutableList<Prestamo> = mutableListOf()

    override fun registrarPrestamo(usuario: Usuario, elemento: ElementoBiblioteca) {
        val prestamo = Prestamo(usuario, elemento)
        prestamosActuales.add(prestamo)
        elemento.cambiarEstado(EstadoElemento.PRESTADO)
        println("Prestamo registrado: ${elemento.titulo} de ${usuario.nombre}")
    }

    override fun registrarDevolucion(usuario: Usuario, elemento: ElementoBiblioteca) {
        val prestamo = prestamosActuales.find { it.elemento == elemento && it.usuario == usuario }
        if (prestamo != null) {
            prestamosActuales.remove(prestamo)
            historialPrestamos.add(prestamo)
            elemento.cambiarEstado(EstadoElemento.DISPONIBLE)

        } else {
            println("Error: No se encontro el prestamo")
        }
    }

    override fun consultarHistorialPrestamos(): List<Prestamo> {
        return historialPrestamos.toList()
    }

    fun consultarHistorialPrestamos(elemento: ElementoBiblioteca): List<Prestamo> {
        return historialPrestamos.filter { it.elemento == elemento }
    }

    fun consultarHistorialPrestamosUsuario(usuario: Usuario): List<Prestamo> {
        return historialPrestamos.filter { it.usuario == usuario }
    }
}