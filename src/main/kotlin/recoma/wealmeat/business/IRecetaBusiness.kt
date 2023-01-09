package recoma.wealmeat.business

import recoma.wealmeat.model.Receta

interface IRecetaBusiness {

    fun list(): List<Receta>
    fun load(idReceta: Long): Receta
    fun save(receta: Receta): Receta
    fun remove(idReceta: Long)

}