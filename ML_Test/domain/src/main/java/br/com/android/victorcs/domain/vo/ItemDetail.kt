package br.com.android.victorcs.domain.vo

/**
 * Data class to represent vo from the item detail app.
 * @author victorcs
 */
data class ItemDetail(
    var title: String? = null,
    var categoryId: String? = null,
    var price: String? = null,
    var currencyId: String? = null,
    var availableQuantity: Int? = null,
    var soldQuantity: Int? = null,
    var buyingMode: String? = null,
    var listingTypeId: String? = null,
    var condition: String? = null,
    var description: String? = null,
    var videoId: String? = null,
    var warranty: String? = null,
    var pictures: List<Picture>? = null
)

/**
 * Data class to represent vo from the item picture detail app.
 * @author victorcs
 */
data class Picture(
    var source: String? = null
)
