package br.com.android.victorcs.domain.usecase.mainscreen

import br.com.android.victorcs.domain.usecase.core.UseCase
import br.com.android.victorcs.domain.vo.ItemDetail
import br.com.android.victorcs.domain.vo.ItemResult

/**
 * Contract use case to observable get detail item with pass param.
 * @author victorcs
 */
interface IMainScreenGetDetailItemUseCase : UseCase.FromObservable.WithParameter<String, ItemDetail>