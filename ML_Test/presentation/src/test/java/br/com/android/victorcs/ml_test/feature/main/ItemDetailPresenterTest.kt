package br.com.android.victorcs.ml_test.feature.main

import br.com.android.victorcs.domain.repository.IMainScreenRepository
import br.com.android.victorcs.ml_test.MlSpek
import br.com.android.victorcs.ml_test.app.feature.core.BaseView
import br.com.android.victorcs.ml_test.app.feature.detail.ItemDetailContract
import br.com.android.victorcs.ml_test.mocks.ItemDetailScreenMock
import br.com.android.victorcs.ml_test.mocks.MainScreenMock
import br.com.android.victorcs.ml_test.utils.ext.*
import com.nhaarman.mockitokotlin2.argThat
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.reset
import com.nhaarman.mockitokotlin2.verify
import org.koin.core.parameter.parametersOf
import org.spekframework.spek2.style.gherkin.Feature

class ItemDetailPresenterTest : MlSpek({

    val mockView = mock<ItemDetailContract.View>()
    val mockRepository = get<IMainScreenRepository>()
    val presenter: ItemDetailContract.Presenter by inject { parametersOf(mockView) }

    fun resetMocks() = reset(mockView, mockRepository)

    Feature("search item detail by id.") {

        Scenario("success") {
            val mockResponse = ItemDetailScreenMock.getItemDetail()
            When("user go to item detail and see item details.") {
                resetMocks()
                MainScreenMock.mockGetItems(mockRepository)
                presenter.getItemDetail("ML0123456")
            }

            verifyLoadingBehavior(mockView)

            Then("should show item detail from server") {
                verify(mockView).setItemDetail(itemDetail = argThat {
                    title == mockResponse.title
                })
            }
        }

        fun testLoadItemDetailErrorScenario(view: BaseView, error: Throwable) {
            Scenario("error: ${ErrorUtils.getErrorDescription(error)}") {

                When("user set 'abcdef' to get items.") {
                    resetMocks()
                    MainScreenMock.mockGetItems(mock = mockRepository, error = error)
                    presenter.getItemDetail("abcdef")
                }
                verifyLoadingBehavior(view)
                verifyErrorBehavior(view, error)
            }
        }
        ErrorUtils.getKnownErrors().forEach { testLoadItemDetailErrorScenario(view = mockView, error = it) }
    }
})