package org.pebiblioteca
import java.util.*
fun generarUUID():UUID {
    val uuid = UUID.randomUUID()
    return uuid
}
fun main() {
    val libro1 = Libro(generarUUID(), "Hola", "Yo", 2024, "Examen")
    val libro2 = Libro(generarUUID(), "Adios", "Tu", 2024, "Programacion")
    val libro3 = Libro(generarUUID(), "Voy", "a", 2024, "Suspender")

    val gestorBiblioteca =  GestorBiblioteca()

    gestorBiblioteca.agregarLibro(libro1)
    gestorBiblioteca.agregarLibro(libro2)
    gestorBiblioteca.agregarLibro(libro3)

    gestorBiblioteca.registrarPrestamo(libro1.id)
    gestorBiblioteca.registrarPrestamo(libro1.id)
    gestorBiblioteca.devolverLibro(libro1.id)
    gestorBiblioteca.devolverLibro(libro1.id)
}