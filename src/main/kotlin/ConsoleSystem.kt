package org.example

/**
 * Interfaz que define un método para enviar mensajes de salida.
 */
interface EnviarMsg {
    /**
     * Método para imprimir un mensaje.
     * @param msgToPrint El mensaje que se va a imprimir.
     */
    fun escritor(msgToPrint: String)
}

/**
 * Interfaz que define un método para leer mensajes de entrada.
 */
interface LeerMsg {
    /**
     * Método para leer un mensaje.
     * @return El mensaje leído.
     */
    fun lector(): String
}

/**
 * Objeto que implementa las interfaces `EnviarMsg` y `LeerMsg`, proporcionando funcionalidades para imprimir y leer mensajes en la consola.
 */
object ConsoleSystem : EnviarMsg, LeerMsg {

    /**
     * Imprime un mensaje en la consola.
     * @param msgToPrint El mensaje que se va a imprimir.
     */
    override fun escritor(msgToPrint: String) {
        println(msgToPrint)
    }

    /**
     * Lee un mensaje desde la consola.
     * @return El mensaje leído.
     */
    override fun lector(): String {
        return readln()
    }

    /**
     * Muestra el menú para consultar el estado de los libros.
     */
    fun menuRetornarLibro() {
        println("¿Qué desea consultar?:")
        println("1. El estado de todos los libros")
        println("2. Los disponibles")
        println("3. Los prestados")
        println("4. Salir")
        println("Por favor, seleccione la opción que desee: ")
    }

    /**
     * Muestra el menú de opciones para el usuario.
     */
    fun userMenuMenu() {
        println("¿Qué desea hacer?: ")
        println("1. Agregar libro al catálogo")
        println("2. Eliminar libro del catálogo")
        println("3. Registrar un préstamo")
        println("4. Devolver un libro")
        println("5. Consultar estado libros")
        println("6. Consultar historial de préstamos")
        println("7. Consultar préstamos de un usuario")
        println("Por favor, seleccione la opción que desee: ")
    }
}