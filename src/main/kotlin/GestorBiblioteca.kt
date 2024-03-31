package org.example

import org.example.UtilidadesBiblioteca.Companion.generarIdentificadorUnico

open class GestorBiblioteca(private val gestorPrestamos: IGestorPrestamos) {
    /**
     * Lista mutable que almacena el catálogo de libros.
     */
    private val catalogo: MutableList<ElementoBiblioteca> = mutableListOf()


    /**
     * Busca un libro en el catálogo por su instancia y devuelve el libro encontrado, si existe.
     * @param elemento El libro a buscar en el catálogo.
     * @return El libro encontrado o null si no se encuentra.
     */
    private fun buscarElemento(elemento: ElementoBiblioteca): ElementoBiblioteca? {
        return catalogo.find { it.obtenerId() == elemento.obtenerId() }
    }

    /**
     * Busca un libro en el catálogo por su ID y devuelve el libro encontrado, si existe.
     * @param id El ID del libro a buscar en el catálogo.
     * @return El libro encontrado o null si no se encuentra.
     */
    fun buscarElemento(id: Int): ElementoBiblioteca? {
        return catalogo.find { it.obtenerId() == id }
    }

    /**
     * Agrega un nuevo libro al catálogo, si no existe previamente.
     * @param elemento El libro a agregar al catálogo.
     */
    fun agregarElemento(elemento: ElementoBiblioteca) {
        val idUnico = generarIdentificadorUnico()

        retornarTodosLibros()


        if (buscarElemento(elemento) != null) {
            ConsoleSystem.escritor("Ese libro ya se encuentra en el catálogo.")
        } else {
            elemento.asignarId(idUnico)
            catalogo.add(elemento)
        }
    }

    /**
     * Elimina un libro del catálogo por su id, si existe.
     * @param id El id del libro.
     */
    fun eliminarLibro(id: Int) {
        val libroEncontrado = catalogo.find { it.obtenerId() == id }

        retornarTodosLibros()

        if (libroEncontrado != null) {
            catalogo.remove(libroEncontrado)
            ConsoleSystem.escritor("Libro eliminado con éxito.")
        } else {
            ConsoleSystem.escritor("Ese libro no se encuentra en el catálogo.")
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
    private fun retornarTodosLibros() {
        catalogo.forEach{
            ConsoleSystem.escritor("ID: ${it.obtenerId()}.")
            ConsoleSystem.escritor("Título: ${it.obtenerTitulo()}.")
            ConsoleSystem.escritor("Estado: ${it.obtenerEstado()}.")
            ConsoleSystem.escritor("________________")
        }
    }

    /**
     * Muestra los libros disponibles en el catálogo.
     */
    private fun retornarLibrosDisponibles() {
        val librosDisponibles = catalogo.filter { it.obtenerEstado() == Estado.DISPONIBLE }

        if (librosDisponibles.isNotEmpty()){
            librosDisponibles.forEach{
                ConsoleSystem.escritor("ID: ${it.obtenerId()}.")
                ConsoleSystem.escritor("Título: ${it.obtenerTitulo()}.")
                ConsoleSystem.escritor("Estado: ${it.obtenerEstado()}.")
                ConsoleSystem.escritor("________________")
            }
        }
    }

    /**
     * Muestra los libros prestados en el catálogo.
     */
    private fun retornarLibrosPrestados() {
        val librosPrestados = catalogo.filter { it.obtenerEstado() == Estado.PRESTADO }

        if (librosPrestados.isNotEmpty()){
            librosPrestados.forEach{
                ConsoleSystem.escritor("ID: ${it.obtenerId()}.")
                ConsoleSystem.escritor("Título: ${it.obtenerTitulo()}.")
                ConsoleSystem.escritor("Estado: ${it.obtenerEstado()}.")
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

    fun getCatalogo(): MutableList<ElementoBiblioteca>{
        return catalogo
    }
}