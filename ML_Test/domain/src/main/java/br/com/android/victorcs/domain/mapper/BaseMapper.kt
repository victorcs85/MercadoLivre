package br.com.android.victorcs.domain.mapper

/**
 * Mappper interface.
 * @author victorcs
 */
interface BaseMapper<R, E> {
    fun toEntity(from: R): E
}