package br.com.android.victorcs.data.remote

import br.com.android.victorcs.domain.entity.response.ItemDetailResponse
import br.com.android.victorcs.domain.entity.response.main.ItemsResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Interface api to consuming
 * @author victorcs
 */
interface Api {

    //Get all items from server by query string
    @GET("sites/MLB/search")
    fun getItems(@Query("q") query: String): Observable<ItemsResponse>

    //Get item detail by id
    @GET("items/{item_id}")
    fun getItemDetail(@Path("item_id") id: String): Observable<ItemDetailResponse>

}