package org.pebiblioteca

interface IGestorPrestamos {
    fun registrarPrestamo(usuario: Usuario, elemento: ElementoBiblioteca)
    fun registrarDevolucion(usuario: Usuario, elemento: ElementoBiblioteca)
    fun consultarHistorialPrestamos(): List<Prestamo>
}