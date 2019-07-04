package br.com.android.victorcs.ml_test.app.feature.main

import br.com.android.victorcs.domain.vo.Items
import br.com.android.victorcs.ml_test.app.feature.core.BaseView

/**
 * Contract to view and presenter.
 * @author victorcs
 */
interface MainScreenContract {

    interface View : BaseView {
        fun initComponents()
        fun setupRecyclerViewAdapter(items: Items)
    }

    interface Presenter {
        fun getItems(query: String)
    }

}