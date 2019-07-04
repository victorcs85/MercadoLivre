package br.com.android.victorcs.domain.usecase.mainscreen

import br.com.android.victorcs.domain.usecase.core.UseCase
import br.com.android.victorcs.domain.vo.Items

/**
 * Contract use case to observable get items with pass param.
 * @author victorcs
 */
interface IMainScreenGetItemsUseCase: UseCase.FromObservable.WithParameter<String, Items>