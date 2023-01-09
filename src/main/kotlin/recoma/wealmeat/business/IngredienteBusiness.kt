package recoma.wealmeat.business

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import recoma.wealmeat.dao.IngredienteRepository
import recoma.wealmeat.exceptions.BusinessException
import recoma.wealmeat.exceptions.NotFoundException
import java.util.Optional
import kotlin.jvm.Throws
import recoma.wealmeat.model.Ingrediente

@Service
class IngredienteBusiness : IIngredienteBusiness {

    @Autowired
    val ingredienteRepository: IngredienteRepository? = null


    @Throws(BusinessException::class)
    override fun list(): List<Ingrediente> {
        try {
            return ingredienteRepository!!.findAll()
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }
    }

    @Throws(BusinessException::class, NotFoundException::class)
    override fun load(idIngrediente: Long): Ingrediente {
        val op: Optional<Ingrediente>
        try {
            op = ingredienteRepository!!.findById(idIngrediente)
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }

        if (!op.isPresent) {
            throw NotFoundException("No se encontro una persona con el id:  $idIngrediente")
        }

        return op.get()

    }

    @Throws(BusinessException::class)
    override fun save(ingrediente: Ingrediente): Ingrediente {
        try {
            return ingredienteRepository!!.save(ingrediente)
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }
    }

    override fun remove(idIngrediente: Long) {

        val op: Optional<Ingrediente>

        try {
            op = ingredienteRepository!!.findById(idIngrediente)
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }

        if (!op.isPresent) {
            throw NotFoundException("No se encontro una persona con el id:  $idIngrediente")
        }

        try {
            ingredienteRepository!!.deleteById(idIngrediente)
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }


    }
}