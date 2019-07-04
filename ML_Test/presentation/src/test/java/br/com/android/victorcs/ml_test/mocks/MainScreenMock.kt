package br.com.android.victorcs.ml_test.mocks

import br.com.android.victorcs.domain.entity.response.main.ItemsResponse
import br.com.android.victorcs.domain.entity.response.main.Result
import br.com.android.victorcs.domain.entity.response.main.Value
import br.com.android.victorcs.domain.repository.IMainScreenRepository
import io.reactivex.Observable
import org.mockito.Mockito

object MainScreenMock {

    fun mockGetItems(
        mock: IMainScreenRepository,
        mockResponse: ItemsResponse = getItemMock(),
        error: Throwable? = null
    ): ItemsResponse {
        Mockito.`when`(mock.getItems("test"))
            .thenReturn(error?.let { Observable.error<ItemsResponse>(it) }
                ?: Observable.just(mockResponse))
        return mockResponse
    }

    fun getItemMock(): ItemsResponse {

        val valueMock = Value(
            id = "000000",
            name = "Value Test",
            results = 0
        )

        val itemResultMock = Result(
            id = "00000",
            siteId = "00000",
            title = "Item Test",
            availableQuantity = 1,
            soldQuantity = 2,
            buyingMode = "Chalala",
            listingTypeId = "00000",
            condition = "Novo?",
            thumbnail = "",
            acceptsMercadopago = true,
            originalPrice = "444",
            categoryId = "00000",
            tags = null,
            name = "Item Test",
            type = "test",
            price = 444.0,
            values = listOf(valueMock)
        )

        return ItemsResponse(
            siteId = "00000",
            query = "",
            results = listOf(itemResultMock)
        )
    }
}