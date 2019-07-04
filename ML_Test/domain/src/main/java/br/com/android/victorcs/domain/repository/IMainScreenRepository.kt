package br.com.android.victorcs.domain.repository

import br.com.android.victorcs.domain.entity.response.ItemDetailResponse
import br.com.android.victorcs.domain.entity.response.main.ItemsResponse
import io.reactivex.Observable

/**
 * Main repository interface to load data.
 * @author victorcs
 */
interface IMainScreenRepository {
    fun getItems(query: String): Observable<ItemsResponse>
    fun getItemDetail(itemId: String): Observable<ItemDetailResponse>
}