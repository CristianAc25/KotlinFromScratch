package clase1

fun imprimirLongitud(objeto: Any) {
    if (objeto is String) {
        println("La longitud de la cadena es: ${objeto.length}") // Length es una propiedad de String, no de Any, sin embargo puedo usarla despues del check
    } else {
        println("El objeto no es una cadena")
    }
}

fun main() {
    imprimirLongitud("Hola, mundo") // Salida: La longitud de la cadena es: 11
    imprimirLongitud(10) // Salida: El objeto no es una cadena
}



