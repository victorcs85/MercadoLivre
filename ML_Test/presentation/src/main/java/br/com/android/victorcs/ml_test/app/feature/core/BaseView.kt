package br.com.android.victorcs.ml_test.app.feature.core

import android.os.Bundle
import androidx.annotation.LayoutRes

/**
 * Base contract to views.
 * @author victorcs
 */
interface BaseView {

    fun showMessage(message: String)
    fun showMessage(messageResId: Int)
    fun showLoading()
    fun hideLoading()
    fun showNetworkError()

}
