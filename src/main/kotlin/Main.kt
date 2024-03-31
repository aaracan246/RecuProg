package org.example

fun main() {
    // Se crea un gestor de biblioteca
    val registroPrestamos = RegistroPrestamos()
    val gestorBiblioteca = GestorElementos<ElementoBiblioteca>(registroPrestamos)

    // Se crean algunos libros
    val libro1 = Libro(133, "City of Glass", "Paul Auster", 1992, "Detectivesca", Estado.DISPONIBLE)
    val libro2 = Libro(134, "The Mark on the Wall", "Virginia Woolf", 1981, "Psicológica", Estado.PRESTADO)
    val libro3 = Libro(135, "Brave New World", "Aldous Huxley", 1966, "Ficción", Estado.PRESTADO)

    val dVD1 = DVD(136, "El Señor de los Anillos: El retorno del rey")

    val revista1 = Revista(137, "")

    val user = Usuario(112, "Jorge")


    // Se agregan los libros al gestor de biblioteca
    gestorBiblioteca.agregarElemento(libro1)
    gestorBiblioteca.agregarElemento(libro2)
    gestorBiblioteca.agregarElemento(libro3)

    gestorBiblioteca.agregarElemento(dVD1)

    gestorBiblioteca.agregarElemento(revista1)

    // Se muestra el menú de usuario
    MenuUsuario.userMenu(user, gestorBiblioteca, registroPrestamos)
}
