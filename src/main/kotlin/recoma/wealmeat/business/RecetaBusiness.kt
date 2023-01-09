package recoma.wealmeat.business

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import recoma.wealmeat.dao.RecetaRepository
import recoma.wealmeat.exceptions.BusinessException
import recoma.wealmeat.exceptions.NotFoundException
import java.util.Optional
import kotlin.jvm.Throws
import recoma.wealmeat.model.Receta

@Service
class RecetaBusiness : IRecetaBusiness {

    @Autowired
    val recetaRepository: RecetaRepository? = null


    @Throws(BusinessException::class)
    override fun list(): List<Receta> {
        try {
            return recetaRepository!!.findAll()
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }
    }

    @Throws(BusinessException::class, NotFoundException::class)
    override fun load(idReceta: Long): Receta {
        val op: Optional<Receta>
        try {
            op = recetaRepository!!.findById(idReceta)
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }

        if (!op.isPresent) {
            throw NotFoundException("No se encontro una persona con el id:  $idReceta")
        }

        return op.get()

    }

    @Throws(BusinessException::class)
    override fun save(receta: Receta): Receta {
        try {
            return recetaRepository!!.save(receta)
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }
    }

    override fun remove(idReceta: Long) {

        val op: Optional<Receta>

        try {
            op = recetaRepository!!.findById(idReceta)
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }

        if (!op.isPresent) {
            throw NotFoundException("No se encontro una persona con el id:  $idReceta")
        }

        try {
            recetaRepository!!.deleteById(idReceta)
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }


    }
}