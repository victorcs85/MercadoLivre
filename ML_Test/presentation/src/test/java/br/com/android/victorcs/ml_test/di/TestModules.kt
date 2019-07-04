package br.com.android.victorcs.ml_test.di

import br.com.android.victorcs.domain.di.DomainModule
import br.com.android.victorcs.domain.repository.IMainScreenRepository
import br.com.android.victorcs.ml_test.app.di.PresenterModule
import com.nhaarman.mockitokotlin2.mock
import org.koin.dsl.module.module

val RepositoryModuleTest = module {
    single { mock<IMainScreenRepository>() }
}

val PresenterModuleTest = PresenterModule.module

val UserCaseModuleTest = DomainModule.module

val testModules = listOf(RepositoryModuleTest, UserCaseModuleTest, PresenterModuleTest)