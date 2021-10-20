package online.harrigan.cotlin

class Application {

    fun saySomething(message: String) {
        println(message.uppercase())
    }

}

fun main() {
    println("Hello Kotlin World!")
}

interface Vocalise {
    fun bark(): String
}
