package org.example

fun main() {
    // Se crea un gestor de biblioteca
    val registroPrestamos = RegistroPrestamos()
    val gestorBiblioteca = GestorBiblioteca(registroPrestamos)

    // Se crean algunos libros
    val libro1 = Libro(133, "City of Glass", "Paul Auster", 1992, "Detectivesca", Estado.DISPONIBLE)
    val libro2 = Libro(134, "The Mark on the Wall", "Virginia Woolf", 1981, "Psicológica", Estado.PRESTADO)
    val libro3 = Libro(135, "Brave New World", "Aldous Huxley", 1966, "Ficción", Estado.PRESTADO)

    val user = Usuario(112, "Jorge")


    // Se agregan los libros al gestor de biblioteca
    gestorBiblioteca.agregarLibro(libro1)
    gestorBiblioteca.agregarLibro(libro2)
    gestorBiblioteca.agregarLibro(libro3)

    // Se muestra el menú de usuario
    MenuUsuario.userMenu(user, gestorBiblioteca, registroPrestamos)
}
