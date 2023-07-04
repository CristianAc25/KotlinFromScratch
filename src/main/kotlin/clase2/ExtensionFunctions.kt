package clase2

import kotlin.math.ln

fun String.saludar() {
    println("¡Hola, $this!")
}

class Perro(val nombre: String, val edad: Int)

fun main() {
    val nombre = "Juan"
    nombre.saludar() // Llama a la extension function en la cadena "nombre"

    val perro = Perro("Fatiga", 9)
    println(perro.edadEnAñosHumanos)
    perro.imprimirDescripcion("Pepe Argento")
}

fun Perro.imprimirDescripcion(dueño: String) {
    println("Nombre: $nombre Edad: $edad Dueño: $dueño")
}

val Perro.edadEnAñosHumanos: Double
    get() = 16 * ln(edad.toDouble()) + 31
