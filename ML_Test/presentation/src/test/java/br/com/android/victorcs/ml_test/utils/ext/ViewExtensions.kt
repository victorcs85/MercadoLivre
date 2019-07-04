package br.com.android.victorcs.ml_test.utils.ext

import br.com.android.victorcs.ml_test.app.feature.core.BaseView
import com.nhaarman.mockitokotlin2.verify

fun BaseView.verifyIfProgressShowed() {
    verify(this).showLoading()
}

fun BaseView.verifyIfProgressHided() {
    verify(this).hideLoading()
}