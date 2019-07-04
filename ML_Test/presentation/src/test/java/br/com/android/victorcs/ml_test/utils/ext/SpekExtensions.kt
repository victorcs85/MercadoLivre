package br.com.android.victorcs.ml_test.utils.ext

import br.com.android.victorcs.ml_test.R
import br.com.android.victorcs.ml_test.app.feature.core.BaseView
import com.nhaarman.mockitokotlin2.verify
import org.spekframework.spek2.style.gherkin.ScenarioBody
import retrofit2.HttpException

fun ScenarioBody.verifyLoadingBehavior(view: BaseView) {
    Then("view should show loading") {
        view.verifyIfProgressShowed()
    }
    And("view should hide loading") {
        view.verifyIfProgressHided()
    }
}

fun ScenarioBody.verifyErrorBehavior(view: BaseView, error: Throwable) {

    when {

        ErrorUtils.isNetworkError(error) -> {
            Then("view should show network error") {
                verify(view).showNetworkError()
            }
        }

        error is HttpException -> {

            Then("view should show generic error") {
                verify(view).showMessage(R.string.load_data_error)
            }

        }
    }
}