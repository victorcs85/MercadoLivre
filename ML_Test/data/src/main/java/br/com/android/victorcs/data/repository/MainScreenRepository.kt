package br.com.android.victorcs.data.repository

import br.com.android.victorcs.data.remote.Api
import br.com.android.victorcs.domain.entity.response.ItemDetailResponse
import br.com.android.victorcs.domain.entity.response.main.ItemsResponse
import br.com.android.victorcs.domain.repository.IMainScreenRepository
import io.reactivex.Observable

/**
 * Main screen repository, use api to get server information.
 * @author victorcs
 */
class MainScreenRepository(private val api: Api) : IMainScreenRepository {

    override fun getItems(query: String): Observable<ItemsResponse> {
        return api.getItems(query)
    }

    override fun getItemDetail(itemId: String): Observable<ItemDetailResponse> {
        return api.getItemDetail(itemId)
    }
}