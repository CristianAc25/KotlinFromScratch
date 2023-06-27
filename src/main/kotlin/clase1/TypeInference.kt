package clase1

fun main(args: Array<String>) {
    val lista = listOf(1, 2, 3, 4, 5) // No especificamos el tipo datos que contiene la lista, el compilador los infiere.
    val elemento = obtenerPrimerElemento(lista)

    println("El tipo de 'elemento' es: ${elemento::class.simpleName}")
}

fun obtenerPrimerElemento(lista: List<Any>) = lista[0] // No es necesario especificar el tipo de retorno, es inferido por el tipo del parametro



