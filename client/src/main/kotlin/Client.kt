import com.example.dto.CreatePersonDto
import com.example.dto.CreateRandomPeopleDto
import com.example.dto.PersonDto
import com.example.dto.UpdatePersonDto
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory
import org.springframework.web.client.*


class Client {

    private val template = run {
        val requestFactory = HttpComponentsClientHttpRequestFactory()
        RestTemplate(requestFactory)
    }
    private val url = "http://localhost:8080/people"

    fun getAllPeople() {
        val people = template.getForObject<List<PersonDto>>(url)
        println("\npeople: $people")
    }

    fun addPerson(words: List<String>) {
        val name = words[1]
        val weight = words[2].toFloat()
        val person = CreatePersonDto(name, weight)
        val id = template.postForObject<Int>(url, person)
        println("\nid: $id")
    }

    fun addRandomPeople(words: List<String>) {
        val a = words[1].toInt()
        val b = words[2].toInt()
        val dto = CreateRandomPeopleDto(a, b)
        val generatedPeople = template.postForObject<List<PersonDto>>("$url/random", dto)
        println("\ngeneratedPeople: $generatedPeople")
    }

    fun replacePerson(words: List<String>) {
        val id = words[1].toInt()
        val name = words[2]
        val weight = words[3].toFloat()
        val person = CreatePersonDto(name, weight)
        tryToMakeSuccessfulRequest { template.put("$url/$id", person) }
    }

    fun updatePerson(words: List<String>) {
        val id = words[1].toInt()
        val name = tryToGetName(words)
        val weight = tryToGetWeight(words)
        val person = UpdatePersonDto(name, weight)
        tryToMakeSuccessfulRequest { template.patchForObject<Void>("$url/$id", person) }
    }

    fun deletePerson(words: List<String>) {
        val id = words[1].toInt()
        tryToMakeSuccessfulRequest { template.delete("$url/$id") }
    }

    private fun tryToMakeSuccessfulRequest(f: () -> Unit) {
        try {
            f()
        } catch (e: HttpClientErrorException) {
            println("\nresponseBody: ${e.responseBodyAsString}")
        }
    }

    private fun tryToGetName(arguments: List<String>): String? {
        val word = arguments[2]
        return if (word == "-") null else word
    }

    private fun tryToGetWeight(arguments: List<String>): Float? =
        try {
            arguments[3].toFloat()
        } catch (e: Exception) {
            null
        }
}
