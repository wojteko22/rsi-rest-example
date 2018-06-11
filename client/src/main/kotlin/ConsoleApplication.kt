object ConsoleApplication {

    private val client = Client()

    private const val message = """
            Available commands:
            get
            post {name} {weight}
            post2 {a} {b}
            put {id} {name} {weight}
            patch {id} -/{name} [weight]
            delete {id}
            exit
            """

    fun run() {
        do {
            println(message)
            val line = readLine()!!
            val words = line.split(" ")
            val command = words[0].toLowerCase()
            tryToExecute(command, words)
        } while (command != "exit")
    }

    private fun tryToExecute(command: String, words: List<String>) {
        try {
            execute(command, words)
        } catch (e: Exception) {
            println(e)
        }
    }

    private fun execute(command: String, words: List<String>) {
        when (command) {
            "get" -> client.getAllPeople()
            "post" -> client.addPerson(words)
            "post2" -> client.addRandomPeople(words)
            "put" -> client.replacePerson(words)
            "patch" -> client.updatePerson(words)
            "delete" -> client.deletePerson(words)
        }
    }
}
