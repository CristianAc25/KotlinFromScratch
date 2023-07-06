import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun main() {
    log("Start")

    val repetitions = 1000

    runBlocking {
        launch (Dispatchers.Default) {
            repeat(repetitions) {
                log("Launch 1: $it")
                //delay(50)
            }
        }

        launch (Dispatchers.IO) {
            repeat(repetitions) {
                log("Launch 2: ${repetitions - it}")
                //delay(50)
            }
        }
    }

    log("End")
}