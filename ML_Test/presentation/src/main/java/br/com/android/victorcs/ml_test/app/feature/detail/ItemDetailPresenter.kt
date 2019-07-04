package br.com.android.victorcs.ml_test.app.feature.detail

import br.com.android.victorcs.domain.usecase.mainscreen.IMainScreenGetDetailItemUseCase
import br.com.android.victorcs.ml_test.R
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

/**
 * Main screen presenter.
 * @author victorcs
 */
class ItemDetailPresenter(
    private val view: ItemDetailContract.View,
    private val detailItemUseCase: IMainScreenGetDetailItemUseCase
) : ItemDetailContract.Presenter {

    // Call get item detail from server.
    override fun getItemDetail(itemId: String) {
        view.showLoading()
        detailItemUseCase.execute(itemId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onNext = { itemDetail ->
                    view.hideLoading()
                    view.setItemDetail(itemDetail)
                }
                , onError = {
                    view.hideLoading()
                    view.showMessage(R.string.load_data_error)
                    Timber.e(it)
                })
    }

}