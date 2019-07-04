package br.com.android.victorcs.ml_test.app.di

import br.com.android.victorcs.ml_test.app.feature.detail.ItemDetailContract
import br.com.android.victorcs.ml_test.app.feature.main.MainScreenContract
import br.com.android.victorcs.ml_test.app.feature.detail.ItemDetailPresenter
import br.com.android.victorcs.ml_test.app.feature.main.MainScreenPresenter
import org.koin.dsl.module.module

/**
 * Koin module to all presenters to generate.
 * @author victorcs
 */
object PresenterModule {

    /*
    * https://insert-koin.io/docs/1.0/documentation/reference/index.html#_injection_parameters
    * */
    val module = module {

        factory<MainScreenContract.Presenter> { (view: MainScreenContract.View) ->
            MainScreenPresenter(
                view = view,
                itemsUseCase = get()
            )
        }

        factory<ItemDetailContract.Presenter> { (view: ItemDetailContract.View) ->
            ItemDetailPresenter(
                view = view,
                detailItemUseCase = get()
            )
        }
    }
}