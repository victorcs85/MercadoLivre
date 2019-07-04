package br.com.android.victorcs.domain.entity.response

import com.google.gson.annotations.SerializedName

/**
 * Item detail response server.
 * @author victorcs
 */
data class ItemDetailResponse(
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("category_id")
    var categoryId: String? = null,
    @SerializedName("price")
    var price: Int? = null,
    @SerializedName("currency_id")
    var currencyId: String? = null,
    @SerializedName("available_quantity")
    var availableQuantity: Int? = null,
    @SerializedName("buying_mode")
    var buyingMode: String? = null,
    @SerializedName("listing_type_id")
    var listingTypeId: String? = null,
    @SerializedName("condition")
    var condition: String? = null,
    @SerializedName("description")
    var description: String? = null,
    @SerializedName("video_id")
    var videoId: String? = null,
    @SerializedName("warranty")
    var warranty: String? = null,
    @SerializedName("pictures")
    var pictures: List<Picture>? = null
)

/**
 * Item picture detail response server.
 * @author victorcs
 */
data class Picture(
    @SerializedName("url")
    var source: String? = null
)
