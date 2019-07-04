package br.com.android.victorcs.ml_test.app.feature.detail

import br.com.android.victorcs.domain.vo.ItemDetail
import br.com.android.victorcs.ml_test.app.feature.core.BaseView

/**
 * Contract to view and presenter.
 * @author victorcs
 */
interface ItemDetailContract {

    interface View : BaseView {
        fun setItemDetail(itemDetail: ItemDetail)
    }

    interface Presenter {
        fun getItemDetail(itemId: String)
    }

}