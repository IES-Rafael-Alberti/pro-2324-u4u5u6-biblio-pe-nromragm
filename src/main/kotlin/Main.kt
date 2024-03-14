package org.pebiblioteca
import org.pebiblioteca.UtilidadesBiblioteca.generarUUID

fun main() {
    val libro1 = Libro(generarUUID(), "Hola", "Yo", 2024, "Examen")
    val libro2 = Libro(generarUUID(), "Adios", "Tu", 2024, "Programacion")
    val libro3 = Libro(generarUUID(), "Voy", "a", 2024, "Suspender")

    val registroPrestamos = RegistroPrestamos()
    val gestorBiblioteca = GestorBiblioteca(registroPrestamos)

    gestorBiblioteca.agregarLibro(libro1)
    gestorBiblioteca.agregarLibro(libro2)
    gestorBiblioteca.agregarLibro(libro3)

    val usuario1 = Usuario(generarUUID(), "Papa")
    val usuario2 = Usuario(generarUUID(), "Mama")

    gestorBiblioteca.realizarPrestamo(usuario1, gestorBiblioteca.catalogo[0])
    gestorBiblioteca.realizarPrestamo(usuario1, gestorBiblioteca.catalogo[0])

    gestorBiblioteca.realizarPrestamo(usuario2, gestorBiblioteca.catalogo[1])

    gestorBiblioteca.realizarDevolucion(usuario1, gestorBiblioteca.catalogo[0])
    gestorBiblioteca.realizarDevolucion(usuario1, gestorBiblioteca.catalogo[0])

    registroPrestamos.consultarHistorialPrestamosLibro(libro1)
    registroPrestamos.consultarHistorialPrestamosUsuario(usuario1)

    gestorBiblioteca.mostrarEstadoLibros()
}