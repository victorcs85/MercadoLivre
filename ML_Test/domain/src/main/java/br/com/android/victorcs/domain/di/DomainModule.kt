package br.com.android.victorcs.domain.di

import br.com.android.victorcs.domain.usecase.mainscreen.IMainScreenGetDetailItemUseCase
import br.com.android.victorcs.domain.usecase.mainscreen.IMainScreenGetItemsUseCase
import br.com.android.victorcs.domain.usecase.mainscreen.MainScreenGetDetailItemUseCase
import br.com.android.victorcs.domain.usecase.mainscreen.MainScreenGetItemsUseCase
import org.koin.dsl.module.module

/**
 * Domain module koin to setup use cases.
 * @author victorcs
 */
object DomainModule {

    val module = module {

        single<IMainScreenGetItemsUseCase> {
            MainScreenGetItemsUseCase(repository = get())
        }

        single<IMainScreenGetDetailItemUseCase> {
            MainScreenGetDetailItemUseCase(repository = get())
        }

    }
}