package org.example

import org.example.UtilidadesBiblioteca.Companion.generarIdentificadorUnico

/**
 * Representa un usuario de la biblioteca con sus atributos básicos y la funcionalidad relacionada con los préstamos de libros.
 *
 * @property id El identificador único del usuario.
 * @property nombre El nombre del usuario.
 * @constructor Crea un nuevo usuario con los atributos proporcionados.
 */
class Usuario(private val id: Int = generarIdentificadorUnico(), private val nombre: String) {

    /** Lista mutable que almacena los libros prestados al usuario. */
    private val listaLibrosPrestados: MutableList<Libro> = mutableListOf()

    /**
     * Busca un libro en la lista de libros prestados al usuario.
     *
     * @return El libro encontrado o null si no se encuentra.
     */
    private fun buscarLibro(): Libro? {
        return listaLibrosPrestados.find { it.getId() == id }
    }

    /**
     * Agrega un libro a la lista de libros prestados al usuario.
     *
     * @param libro El libro a agregar.
     */
    fun agregarLibro(libro: Libro){
        val libroEncontrado = buscarLibro()

        if (libroEncontrado != null){
            listaLibrosPrestados.add(libroEncontrado)
        }
    }

    /**
     * Elimina un libro de la lista de libros prestados al usuario.
     *
     * @param libro El libro a eliminar.
     */
    fun eliminarLibro(libro: Libro){
        val libroEncontrado = buscarLibro()

        if (libroEncontrado != null){
            listaLibrosPrestados.remove(libro)
        }
    }

    /**
     * Consulta la lista de libros prestados al usuario e imprime la información de cada libro.
     */
    fun consultarListaPrestamos(){
        listaLibrosPrestados.forEach{
            ConsoleSystem.escritor("Id: ${it.getId()}.")
            ConsoleSystem.escritor("Título: ${it.getTitulo()}.")
            ConsoleSystem.escritor("Autor: ${it.getAutor()}.")
            ConsoleSystem.escritor("Año publicación: ${it.getAnioPubli()}.")
            ConsoleSystem.escritor("Temática: ${it.getTematica()}.")
            ConsoleSystem.escritor("Estado: ${it.getEstado()}.")
            ConsoleSystem.escritor("________________")
        }
    }

    /**
     * Devuelve el identificador único del usuario.
     *
     * @return El identificador del usuario.
     */
    fun getId(): Int{
        return id
    }

    /**
     * Devuelve el nombre del usuario.
     *
     * @return El nombre del usuario.
     */
    fun getNombre(): String{
        return nombre
    }
}