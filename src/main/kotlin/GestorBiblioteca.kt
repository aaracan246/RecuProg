package org.example

import org.example.UtilidadesBiblioteca.Companion.generarIdentificadorUnico

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

//    /**
//     * Busca un libro en el catálogo por su posición y devuelve el libro encontrado, si existe.
//     * @param posLibro La posición del libro en el catálogo.
//     * @return El libro encontrado o null si no se encuentra.
//     */
//    fun buscarLibro(posLibro: Int): Libro? {
//        if (posLibro > catalogo.size) return null
//        return catalogo[posLibro]
//    }

    /**
     * Busca un libro en el catálogo por su ID y devuelve el libro encontrado, si existe.
     * @param id El ID del libro a buscar en el catálogo.
     * @return El libro encontrado o null si no se encuentra.
     */
    fun buscarLibro(id: Int): Libro? {
        return catalogo.find { it.id == id }
    }

    /**
     * Agrega un nuevo libro al catálogo, si no existe previamente.
     * @param libro El libro a agregar al catálogo.
     */
    fun agregarLibro(libro: Libro) {
        val idUnico = generarIdentificadorUnico()
        if (buscarLibro(libro) != null) {
            ConsoleSystem.escritor("Ese libro ya se encuentra en el catálogo.")
        } else {
            libro.id = idUnico
            catalogo.add(libro)
        }
    }

    /**
     * Elimina un libro del catálogo por su id, si existe.
     * @param id El id del libro.
     */
    fun eliminarLibro(id: Int) {
        val libroEncontrado = catalogo.find { it.id == id }

        if (libroEncontrado != null) {
            catalogo.remove(libroEncontrado)
            ConsoleSystem.escritor("Libro eliminado con éxito.")
        } else {
            ConsoleSystem.escritor("Ese libro no se encuentra en el catálogo.")
        }
    }

    /**
     * Registra el préstamo de un libro por su posición, si está disponible.
     * @param posLibro La posición del libro en el catálogo.
     */
    fun registrarPrestamo(id: Int) {
        val librito = buscarLibro(id)

        when (id) {
            null -> ConsoleSystem.escritor("Ese libro no se encuentra en el catálogo.")
            else -> {
                if (librito != null) {
                    if (librito.estado == Estado.DISPONIBLE) {
                        librito.estado = Estado.PRESTADO
                        registroPrestamos[id] = Estado.PRESTADO
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
    fun devolverLibro(id: Int) {
        val librito = buscarLibro(id)

        when (id) {
            null -> ConsoleSystem.escritor("Ese libro no se encuentra en el catálogo.")
            else -> {
                if (librito != null) {
                    if (librito.estado == Estado.PRESTADO) {
                        librito.estado = Estado.DISPONIBLE
                        registroPrestamos[id] = Estado.DISPONIBLE
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
        catalogo.forEach{
            ConsoleSystem.escritor("ID: ${it.id}.")
            ConsoleSystem.escritor("Título: ${it.titulo}.")
            ConsoleSystem.escritor("Autor: ${it.autor}.")
            ConsoleSystem.escritor("Año publicación: ${it.aniopubli}.")
            ConsoleSystem.escritor("Temática: ${it.tematica}.")
            ConsoleSystem.escritor("Estado: ${it.estado}.")
            ConsoleSystem.escritor("________________")
        }
    }

    /**
     * Muestra los libros disponibles en el catálogo.
     */
    fun retornarLibrosDisponibles() {
        val librosDisponibles = catalogo.filter { it.estado == Estado.DISPONIBLE }

        if (librosDisponibles.isNotEmpty()){
            librosDisponibles.forEach{
                ConsoleSystem.escritor("ID: ${it.id}.")
                ConsoleSystem.escritor("Título: ${it.titulo}.")
                ConsoleSystem.escritor("Autor: ${it.autor}.")
                ConsoleSystem.escritor("Año publicación: ${it.aniopubli}.")
                ConsoleSystem.escritor("Temática: ${it.tematica}.")
                ConsoleSystem.escritor("Estado: ${it.estado}.")
                ConsoleSystem.escritor("________________")
            }
        }
    }

    /**
     * Muestra los libros prestados en el catálogo.
     */
    fun retornarLibrosPrestados() {
        val librosPrestados = catalogo.filter { it.estado == Estado.PRESTADO }

        if (librosPrestados.isNotEmpty()){
            librosPrestados.forEach{
                ConsoleSystem.escritor("ID: ${it.id}.")
                ConsoleSystem.escritor("Título: ${it.titulo}.")
                ConsoleSystem.escritor("Autor: ${it.autor}.")
                ConsoleSystem.escritor("Año publicación: ${it.aniopubli}.")
                ConsoleSystem.escritor("Temática: ${it.tematica}.")
                ConsoleSystem.escritor("Estado: ${it.estado}.")
                ConsoleSystem.escritor("________________")
            }
        }
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