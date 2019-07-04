package br.com.android.victorcs.ml_test.app.feature.main

import br.com.android.victorcs.domain.usecase.mainscreen.IMainScreenGetItemsUseCase
import br.com.android.victorcs.ml_test.R
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

/**
 * Main screen presenter.
 * @author victorcs
 */
class MainScreenPresenter(
    private val view: MainScreenContract.View,
    private val itemsUseCase: IMainScreenGetItemsUseCase
) : MainScreenContract.Presenter {

    // Call get items from server.
    override fun getItems(query: String) {
        view.showLoading()
        itemsUseCase.execute(query)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onNext = {
                    view.hideLoading()
                    view.setupRecyclerViewAdapter(it)
                }
                , onError = {
                    view.hideLoading()
                    view.showMessage(R.string.load_data_error)
                    Timber.e(it)
                })
    }

}