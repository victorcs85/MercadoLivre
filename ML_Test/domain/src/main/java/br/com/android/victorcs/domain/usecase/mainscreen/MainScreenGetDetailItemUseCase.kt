package br.com.android.victorcs.domain.usecase.mainscreen

import br.com.android.victorcs.domain.mapper.ItemDetailMapper
import br.com.android.victorcs.domain.repository.IMainScreenRepository
import br.com.android.victorcs.domain.vo.ItemDetail
import io.reactivex.Observable

/**
 * Use case to observable get detail item with pass param using repository.
 * @author victorcs
 */
class MainScreenGetDetailItemUseCase(private val repository: IMainScreenRepository) :
    IMainScreenGetDetailItemUseCase {

    override fun execute(params: String): Observable<ItemDetail> {
        return repository.getItemDetail(params).map {
            ItemDetailMapper().toEntity(it)
        }
    }
}