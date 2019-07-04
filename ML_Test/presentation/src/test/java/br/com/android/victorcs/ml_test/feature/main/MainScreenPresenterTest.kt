package br.com.android.victorcs.ml_test.feature.main

import br.com.android.victorcs.domain.repository.IMainScreenRepository
import br.com.android.victorcs.ml_test.MlSpek
import br.com.android.victorcs.ml_test.app.feature.core.BaseView
import br.com.android.victorcs.ml_test.app.feature.main.MainScreenContract
import br.com.android.victorcs.ml_test.mocks.MainScreenMock
import br.com.android.victorcs.ml_test.utils.ext.*
import com.nhaarman.mockitokotlin2.argThat
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.reset
import com.nhaarman.mockitokotlin2.verify
import org.koin.core.parameter.parametersOf
import org.spekframework.spek2.style.gherkin.Feature

class MainScreenPresenterTest : MlSpek({

    val mockView = mock<MainScreenContract.View>()
    val mockRepository = get<IMainScreenRepository>()
    val presenter: MainScreenContract.Presenter by inject { parametersOf(mockView) }

    fun resetMocks() = reset(mockView, mockRepository)

    Feature("search item.") {

        Scenario("success") {
            val mockResponse = MainScreenMock.getItemMock()
            When("user set 'test' to get items.") {
                resetMocks()
                MainScreenMock.mockGetItems(mockRepository)
                presenter.getItems("test")
            }

            verifyLoadingBehavior(mockView)

            Then("should show items from server") {
                verify(mockView).setupRecyclerViewAdapter(items = argThat {
                    results == mockResponse.results
                })
            }
        }

        fun testLoadItemsErrorScenario(view: BaseView, error: Throwable) {
            Scenario("error: ${ErrorUtils.getErrorDescription(error)}") {

                When("user set 'abcdef' to get items.") {
                    resetMocks()
                    MainScreenMock.mockGetItems(mock = mockRepository, error = error)
                    presenter.getItems("abcdef")
                }
                verifyLoadingBehavior(view)
                verifyErrorBehavior(view, error)
            }
        }
        ErrorUtils.getKnownErrors().forEach { testLoadItemsErrorScenario(view = mockView, error = it) }
    }
})