package br.com.android.victorcs.domain.mapper

import br.com.android.victorcs.domain.vo.Value

/**
 * Mappper from Value response to value vo
 * @author victorcs
 */
class ItemValueMapper : BaseMapper< List<br.com.android.victorcs.domain.entity.response.main.Value>, List<Value> > {

    override fun toEntity(from: List<br.com.android.victorcs.domain.entity.response.main.Value>): List<Value> {
        val listReturn = mutableListOf<Value>()
        from.forEach {
            listReturn.add(
                Value(
                    id = it.id,
                    name = it.name,
                    results = it.results
                )
            )
        }
        return listReturn
    }
}