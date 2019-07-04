package br.com.android.victorcs.domain.mapper

import br.com.android.victorcs.domain.business.Money
import br.com.android.victorcs.domain.entity.response.ItemDetailResponse
import br.com.android.victorcs.domain.vo.ItemDetail

/**
 * Mappper from item detail response to item detail vo
 * @author victorcs
 */
class ItemDetailMapper : BaseMapper<ItemDetailResponse, ItemDetail> {

    override fun toEntity(from: ItemDetailResponse): ItemDetail {

        val price = from.price?.let {
            Money(it.toDouble()).prettyPrint()
        }

        val pictures = from.pictures?.let {
            ItemDetailPicturesMapper().toEntity(it)
        }

        return ItemDetail(
            title = from.title,
            categoryId = from.categoryId,
            price = price,
            currencyId = from.currencyId,
            availableQuantity = from.availableQuantity,
            buyingMode = from.buyingMode,
            listingTypeId = from.listingTypeId,
            condition = from.condition,
            description = from.description,
            videoId = from.videoId,
            warranty = from.warranty,
            pictures = pictures
        )
    }

}