package br.com.android.victorcs.domain.mapper

import br.com.android.victorcs.domain.entity.response.Picture

/**
 * Mappper from picture list response to picture list vo
 * @author victorcs
 */
class ItemDetailPicturesMapper : BaseMapper<List<Picture>, List<br.com.android.victorcs.domain.vo.Picture>> {

    override fun toEntity(from: List<Picture>): List<br.com.android.victorcs.domain.vo.Picture> {

        val listPictures = mutableListOf<br.com.android.victorcs.domain.vo.Picture>()

        from.forEach {
            listPictures.add(
                br.com.android.victorcs.domain.vo.Picture(
                    source = it.source
                )
            )
        }

        return listPictures
    }

}