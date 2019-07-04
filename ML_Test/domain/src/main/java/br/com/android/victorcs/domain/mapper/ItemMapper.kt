package br.com.android.victorcs.domain.mapper

import br.com.android.victorcs.domain.vo.Items
import br.com.android.victorcs.domain.entity.response.main.ItemsResponse

/**
 * Mappper from items response to items vo
 * @author victorcs
 */
class ItemMapper: BaseMapper<ItemsResponse, Items> {

    override fun toEntity(from: ItemsResponse): Items {
        val results = from.results?.let {
            ItemResultMapper().toEntity(it)
        }

        return Items(
            siteId = from.siteId,
            query = from.query,
            results = results
        )
    }

}