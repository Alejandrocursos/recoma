package recoma.wealmeat.business

import recoma.wealmeat.model.Ingrediente

interface IIngredienteBusiness {

    fun list(): List<Ingrediente>
    fun load(idIngrediente: Long): Ingrediente
    fun save(ingrediente: Ingrediente): Ingrediente
    fun remove(idIngrediente: Long)

}