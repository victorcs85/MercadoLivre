package br.com.android.victorcs.ml_test

import br.com.android.victorcs.ml_test.di.testModules
import br.com.android.victorcs.ml_test.utils.ext.applyRxSchedulers
import br.com.android.victorcs.ml_test.utils.ext.startKoin
import br.com.android.victorcs.ml_test.utils.ext.stopKoin
import org.spekframework.spek2.Spek
import org.spekframework.spek2.dsl.Root

abstract class MlSpek(val testRoot: Root.() -> Unit) : Spek(root = {
    applyRxSchedulers()
    stopKoin()
    startKoin(testModules)
    testRoot()
})