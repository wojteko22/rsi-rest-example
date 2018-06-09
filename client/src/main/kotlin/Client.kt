import com.example.dto.PersonDto
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject

fun main(args: Array<String>) {
    val client = Client()
    do {
        println(
            """
            Available commends:
            get
            exit
            """
        )
        val line = readLine()!!
        val words = line.split(" ")
        val commend = words[0].toLowerCase()
        when (commend) {
            "get" -> client.getAllPeople()
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


}
