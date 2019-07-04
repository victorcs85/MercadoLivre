package br.com.android.victorcs.domain.entity.response.main

import com.google.gson.annotations.SerializedName

/**
 * Result response server.
 * @author victorcs
 */
data class Result(
    @SerializedName("id")
    var id: String?,
    @SerializedName("site_id")
    var siteId: String?,
    @SerializedName("title")
    var title: String?,
    @SerializedName("available_quantity")
    var availableQuantity: Int?,
    @SerializedName("sold_quantity")
    var soldQuantity: Int?,
    @SerializedName("buying_mode")
    var buyingMode: String?,
    @SerializedName("listing_type_id")
    var listingTypeId: String?,
    @SerializedName("condition")
    var condition: String?,
    @SerializedName("thumbnail")
    var thumbnail: String?,
    @SerializedName("accepts_mercadopago")
    var acceptsMercadopago: Boolean,
    @SerializedName("original_price")
    var originalPrice: Any?,
    @SerializedName("category_id")
    var categoryId: String?,
    @SerializedName("tags")
    var tags: List<String>? = null,
    @SerializedName("name")
    var name: String?,
    @SerializedName("type")
    var type: String?,
    @SerializedName("values")
    var values: List<Value>? = null,
    @SerializedName("price")
    var price: Double? = 0.0
)


/**
 * Value response server.
 * @author victorcs
 */
data class Value(
    @SerializedName("id")
    var id: String?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("results")
    var results: Int?
)