package br.com.android.victorcs.domain.vo

/**
 * Data class to represent vo from the items app.
 * @author victorcs
 */
data class Items(
    var siteId: String?,
    var query: String?,
    var results: List<ItemResult>? = null
)

/**
 * Data class to represent vo from the item result.
 * @author victorcs
 */
data class ItemResult(
    var id: String?,
    var siteId: String?,
    var title: String?,
    var availableQuantity: Int?,
    var soldQuantity: Int?,
    var buyingMode: String?,
    var listingTypeId: String?,
    var condition: String?,
    var thumbnail: String?,
    var acceptsMercadopago: Boolean,
    var originalPrice: Any?,
    var categoryId: String?,
    var tags: List<String>? = null,
    var name: String?,
    var type: String?,
    var price: String?,
    var values: List<Value>? = null
)

/**
 * Data class to represent vo from the item value app.
 * @author victorcs
 */
data class Value(
    var id: String?,
    var name: String?,
    var results: Int?
)