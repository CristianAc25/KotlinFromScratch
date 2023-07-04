package clase2


fun main() {

    // Funcion de orden superior que recibe una funcion como parametro
    fun operar(a: Int, b: Int, operacion: (Int, Int) -> Int): Int {
        return operacion(a, b)
    }

    val sumaSimple = { x: Int, y: Int -> x + y }

    val resultado1 = operar(10, 5, sumaSimple) // Invocando la función operar con la función suma como parámetro
    println("El resultado de operar() es: $resultado1")

    // Funcion de orden superior que retorna una funcion
    fun operacionMatematica(op: String): (Int, Int) -> Int {
        return when (op) {
            "suma" -> { x, y -> x + y }
            "resta" -> { x, y -> x - y }
            else -> { x, y -> 0 }
        }
    }

    val suma = operacionMatematica("suma")

    val resultado2 = suma(10, 5) // Invocando la función suma devuelta por operacionMatematica
    println("El resultado de suma() es: $resultado2")

}



