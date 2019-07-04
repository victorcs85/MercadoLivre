package br.com.android.victorcs.ml_test.mocks

import br.com.android.victorcs.domain.entity.response.ItemDetailResponse
import br.com.android.victorcs.domain.entity.response.main.ItemsResponse
import br.com.android.victorcs.domain.entity.response.main.Result
import br.com.android.victorcs.domain.entity.response.main.Value
import br.com.android.victorcs.domain.repository.IMainScreenRepository
import br.com.android.victorcs.domain.vo.Picture
import io.reactivex.Observable
import org.mockito.Mockito

object ItemDetailScreenMock {

    fun mockGetItemDetail(
        mock: IMainScreenRepository,
        mockResponse: ItemDetailResponse = getItemDetail(),
        error: Throwable? = null
    ): ItemDetailResponse {
        Mockito.`when`(mock.getItemDetail("ML0123456"))
            .thenReturn(error?.let { Observable.error<ItemDetailResponse>(it) }
                ?: Observable.just(mockResponse))
        return mockResponse
    }

    fun getItemDetail(): ItemDetailResponse {
        return ItemDetailResponse(
            title = "Item Detail Test",
            categoryId = "000000",
            price = 4444,
            currencyId = "00000",
            availableQuantity = 0,
            buyingMode = "Grana",
            listingTypeId = "00000",
            condition = "Usado?",
            description = "test test",
            videoId = "00000",
            warranty = "00000",
            pictures = null
        )
    }
}