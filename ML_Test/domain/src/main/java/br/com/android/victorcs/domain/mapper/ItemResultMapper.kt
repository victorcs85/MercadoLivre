package br.com.android.victorcs.domain.mapper

import br.com.android.victorcs.domain.business.Money
import br.com.android.victorcs.domain.entity.response.main.Result
import br.com.android.victorcs.domain.vo.ItemResult

/**
 * Mappper from result list response to result list vo.
 * @author victorcs
 */
class ItemResultMapper : BaseMapper<List<Result>, List<ItemResult>> {

    override fun toEntity(from: List<Result>): List<ItemResult> {

        val itemResultList = mutableListOf<ItemResult>()

        from.forEach { result ->

            val values = result.values?.let {
                ItemValueMapper().toEntity(it)
            }

            val price = result.price?.let {
                Money(it).prettyPrint()
            }

            itemResultList.add(
                ItemResult(
                    id = result.id,
                    siteId = result.siteId,
                    title = result.title,
                    availableQuantity = result.availableQuantity,
                    soldQuantity = result.soldQuantity,
                    buyingMode = result.buyingMode,
                    listingTypeId = result.listingTypeId,
                    condition = result.condition,
                    thumbnail = result.thumbnail,
                    acceptsMercadopago = result.acceptsMercadopago,
                    originalPrice = result.originalPrice,
                    categoryId = result.categoryId,
                    tags = result.tags,
                    name = result.name,
                    type = result.type,
                    price = price,
                    values = values
                )
            )
        }

        return itemResultList
    }
}