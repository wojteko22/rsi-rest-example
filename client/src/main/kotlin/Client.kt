import com.example.dto.CreatePersonDto
import com.example.dto.PersonDto
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject
import org.springframework.web.client.postForObject

fun main(args: Array<String>) {
    val client = Client()
    do {
        println(
            """
            Available commends:
            get
            post {name} {weight}
            put {id} {name} {weight}
            exit
            """
        )
        val line = readLine()!!
        val words = line.split(" ")
        val commend = words[0].toLowerCase()
        when (commend) {
            "get" -> client.getAllPeople()
            "post" -> client.addPerson(words)
            "put" -> client.replacePerson(words)
        }
    } while (commend != "exit")
}

class Client {
    private val template = RestTemplate()
    private val url = "http://localhost:8080/people"

    fun getAllPeople() {
        val people = template.getForObject<List<PersonDto>>(url)
        println(people)
    }

    fun addPerson(arguments: List<String>) {
        val name = arguments[1]
        val weight = arguments[2].toDouble()
        val person = CreatePersonDto(name, weight)
        val id = template.postForObject<Int>(url, person)
        println("id: $id")
    }

    fun replacePerson(arguments: List<String>) {
        val id = arguments[1].toInt()
        val name = arguments[2]
        val weight = arguments[3].toDouble()
        val person = CreatePersonDto(name, weight)
        template.put("$url/$id", person)
    }


}
