package br.com.android.victorcs.ml_test.app.feature.core

import androidx.fragment.app.Fragment

/**
 * Base parent fragment with common functions.
 * @author victorcs
 */
abstract class BaseFragment : Fragment(), BaseView {

    private val baseActivity = (activity as? BaseActivity)

    override fun showLoading() {
        baseActivity?.showLoading()
    }

    override fun hideLoading() {
        baseActivity?.hideLoading()
    }

    override fun showMessage(message: String) {
        baseActivity?.showMessage(message)
    }

    override fun showMessage(messageResId: Int) {
        baseActivity?.showMessage(messageResId)
    }

    override fun showNetworkError() {
        baseActivity?.showNetworkError()
    }

}