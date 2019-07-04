package br.com.android.victorcs.ml_test.app.extensions

import br.com.android.victorcs.domain.business.Money

fun Double.toMoney(): Money {
    return Money(this)
}