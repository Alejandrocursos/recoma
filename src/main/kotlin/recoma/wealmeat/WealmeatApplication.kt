package recoma.wealmeat

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import recoma.wealmeat.dao.IngredienteRepository
import recoma.wealmeat.dao.RecetaRepository
import recoma.wealmeat.model.Receta
import recoma.wealmeat.model.Ingrediente

@SpringBootApplication
class WealmeatApplication : CommandLineRunner {

    @Autowired
    val recetaRepository: RecetaRepository? = null

    @Autowired
    val ingredienteRepository: IngredienteRepository? = null


    override fun run(vararg args: String?) {
        //val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
        //val persona1 = Receta(38732234, "gaston","Saillen", LocalDate.parse("29-05-1998",formatter))
        val receta1 = Receta(
            "Tortilla de patatas",
            "Vegana",
            5,
            4,
            156,
            "Tortilla",
            "Ponemos la mariposa en las cuchillas y añadimos al vaso el aceite y el agua. Programamos 5 min/Varoma/vel cuchara."
        )
        recetaRepository!!.save(receta1)

        val ingrediente1 = Ingrediente("Agua")
        val ingrediente2 = Ingrediente("Cebolla")
        val ingrediente3 = Ingrediente("Patata")
        val ingrediente4 = Ingrediente("Huevo")
        val ingrediente5 = Ingrediente("Aceite de oliva virgen extra")

        ingredienteRepository!!.saveAll(listOf(ingrediente1,ingrediente2,ingrediente3,ingrediente4,ingrediente5))
        //ingredienteRepository!!.save(ingrediente1)

    }

}

fun main(args: Array<String>) {
    runApplication<WealmeatApplication>(*args)
}
