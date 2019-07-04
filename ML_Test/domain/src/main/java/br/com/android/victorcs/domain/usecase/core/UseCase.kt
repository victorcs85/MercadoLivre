package br.com.android.victorcs.domain.usecase.core

import io.reactivex.Completable
import io.reactivex.Observable

/**
 * Use case base to setup params or without (only response) params use.
 * @author victorcs
 */
abstract class UseCase {

    object FromObservable {

        interface WithParameter<in P, R> {
            fun execute(params: P): Observable<R>
        }

        interface WithoutParameter<R> {
            fun execute(): Observable<R>
        }
    }

    object FromCompletable {

        interface WithParameter<in P> {
            fun execute(params: P): Completable
        }

        interface WithoutParameter {
            fun execute(): Completable
        }
    }
}