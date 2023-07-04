package clase2

//----------------------------------------------------------------------------------------------------------------------
// Declaracion de una variable de tipo funcion


                            val funcion: (Int) -> String = { "Algun valor de retorno" }


//----------------------------------------------------------------------------------------------------------------------



class Lambdas { //Ejemplos

    val temperatura: (Int, Int) -> String = { x: Int, y: Int -> "Hoy hacen $x°C con un $y% de humedad" }

    val monedas: (Int) -> String = { cantidad ->
        "$cantidad centavos"
    }

    val multiplicacion = { x: Int, y: Int -> x * y }
}

class FuncionAnonima { //Ejemplos

    val temperatura: (Int, Int) -> String = fun(x: Int, y: Int): String {
        return "Hoy hacen $x°C con un $y% de humedad"
    }

    val monedas: (Int) -> String = fun(cantidad: Int): String {
        return "$cantidad centavos"
    }

    val multiplicacion = fun(x: Int, y: Int): Int {
        return x * y
    }
}

//Funsion de primer orden
fun primerOrden(x: Int, y: Int): String {
    return "El resultado de la multiplicacion es: ${x * y}"
}

//Funcion de orden superior con Lambda como ultimo parametro (Propiedad: 'Trailing Lambda')
fun funcionDeOrdenSuperior(a: Int, b: Int, operacion: (Int, Int) -> String): String {
    return operacion(a, b)
}

fun main() {
    val result = funcionDeOrdenSuperior(3, 4) { x: Int, y: Int -> // ... Aplicando Trailing lambda
        "Hoy hacen $x°C con un $y% de humedad"
    }
    println(result)
}