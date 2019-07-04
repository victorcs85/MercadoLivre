package br.com.android.victorcs.domain.usecase.mainscreen

import br.com.android.victorcs.domain.mapper.ItemMapper
import br.com.android.victorcs.domain.repository.IMainScreenRepository
import br.com.android.victorcs.domain.vo.Items
import io.reactivex.Observable

/**
 * Use case to observable get items with pass param using repository.
 * @author victorcs
 */
class MainScreenGetItemsUseCase(private val repository: IMainScreenRepository) :
    IMainScreenGetItemsUseCase {

    override fun execute(params: String): Observable<Items> {
        return repository.getItems(params).map { ItemMapper().toEntity(it) }
    }

}