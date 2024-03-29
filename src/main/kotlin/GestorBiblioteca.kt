package org.example

class GestorBiblioteca() {
    /**
     * Lista mutable que almacena el catálogo de libros.
     */
    val catalogo: MutableList<Libro> = mutableListOf()

    /**
     * Mapa mutable que registra el estado de préstamo de cada libro por su ID.
     */
    val registroPrestamos: MutableMap<Int, Estado> = mutableMapOf()

    /**
     * Busca un libro en el catálogo por su instancia y devuelve el libro encontrado, si existe.
     * @param libro El libro a buscar en el catálogo.
     * @return El libro encontrado o null si no se encuentra.
     */
    fun buscarLibro(libro: Libro): Libro? {
        return catalogo.find { it.id == libro.id }
    }

    /**
     * Busca un libro en el catálogo por su posición y devuelve el libro encontrado, si existe.
     * @param posLibro La posición del libro en el catálogo.
     * @return El libro encontrado o null si no se encuentra.
     */
    fun buscarLibro(posLibro: Int): Libro? {
        if (posLibro > catalogo.size) return null
        return catalogo[posLibro]
    }

    /**
     * Agrega un nuevo libro al catálogo, si no existe previamente.
     * @param libro El libro a agregar al catálogo.
     */
    fun agregarLibro(libro: Libro) {
        if (buscarLibro(libro) != null) {
            ConsoleSystem.escritor("Ese libro ya se encuentra en el catálogo.")
        } else {
            catalogo.add(libro)
        }
    }

    /**
     * Elimina un libro del catálogo por su posición, si existe.
     * @param posLibro La posición del libro en el catálogo.
     */
    fun eliminarLibro(posLibro: Int) {
        if (buscarLibro(posLibro) != null) {
            val libroEncontrado = buscarLibro(posLibro)
            catalogo.remove(libroEncontrado)
        } else {
            ConsoleSystem.escritor("Ese libro no se encuentra en el catálogo.")
        }
    }

    /**
     * Registra el préstamo de un libro por su posición, si está disponible.
     * @param posLibro La posición del libro en el catálogo.
     */
    fun registrarPrestamo(posLibro: Int) {
        val librito = buscarLibro(posLibro)

        when (posLibro) {
            null -> ConsoleSystem.escritor("Ese libro no se encuentra en el catálogo.")
            else -> {
                if (librito != null) {
                    if (librito.estado == Estado.DISPONIBLE) {
                        librito.estado = Estado.PRESTADO
                        registroPrestamos[posLibro] = Estado.PRESTADO
                        ConsoleSystem.escritor("Libro prestado con éxito.")
                    }
                }
            }
        }
    }

    /**
     * Registra la devolución de un libro por su posición, si está prestado.
     * @param posLibro La posición del libro en el catálogo.
     */
    fun devolverLibro(posLibro: Int) {
        val librito = buscarLibro(posLibro)

        when (posLibro) {
            null -> ConsoleSystem.escritor("Ese libro no se encuentra en el catálogo.")
            else -> {
                if (librito != null) {
                    if (librito.estado == Estado.PRESTADO) {
                        librito.estado = Estado.DISPONIBLE
                        registroPrestamos[posLibro] = Estado.DISPONIBLE
                        ConsoleSystem.escritor("Libro devuelto con éxito.")
                    }
                }
            }
        }
    }

    /**
     * Muestra los libros del catálogo según la opción seleccionada por el usuario.
     */
    fun retornarLibrosPorEstado() {
        ConsoleSystem.menuRetornarLibro()

        val option = ConsoleSystem.lector().toIntOrNull()

        return when (option) {
            1 -> retornarTodosLibros()
            2 -> retornarLibrosDisponibles()
            3 -> retornarLibrosPrestados()
            else -> {
                ConsoleSystem.escritor("Esa opción no es correcta. Mostrando todos los libros.")
                retornarTodosLibros()
            }
        }
    }

    /**
     * Muestra todos los libros del catálogo.
     */
    fun retornarTodosLibros() {
        ConsoleSystem.escritor("$catalogo.")
    }

    /**
     * Muestra los libros disponibles en el catálogo.
     */
    fun retornarLibrosDisponibles() {
        ConsoleSystem.escritor(catalogo.filter { it.estado == Estado.DISPONIBLE }.toString())
    }

    /**
     * Muestra los libros prestados en el catálogo.
     */
    fun retornarLibrosPrestados() {
        ConsoleSystem.escritor(catalogo.filter { it.estado == Estado.PRESTADO }.toString())
    }

    /**
     * Obtiene el ID del libro ingresado por el usuario.
     * @return El ID del libro.
     */
    fun obtenerId(): Int {
        ConsoleSystem.escritor("Por favor, introduzca el ID del libro.")
        val idLibro = ConsoleSystem.lector().toInt()
        return idLibro
    }
}