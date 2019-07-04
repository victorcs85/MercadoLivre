package br.com.android.victorcs.ml_test.app.feature.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.android.victorcs.domain.vo.ItemDetail
import br.com.android.victorcs.ml_test.R
import br.com.android.victorcs.ml_test.app.feature.core.BaseFragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.synthetic.main.activity_item_detail.*
import kotlinx.android.synthetic.main.item_detail.view.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a MainScreenActivity
 * in two-pane mode (on tablets) or a [ItemDetailActivity]
 * on handsets.
 * @author victorcs
 */
class ItemDetailFragment : BaseFragment(), ItemDetailContract.View {

    //region Variables
    private val presenter by inject<ItemDetailContract.Presenter> { parametersOf(this) }

    private lateinit var rootView: View

    companion object {
        /**
         * The fragment argument representing the item ID that this fragment
         * represents.
         */
        const val ARG_ITEM_ID = "item_id"
    }
    //endregion

    //region Life circle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            if (it.containsKey(ARG_ITEM_ID)) {
                // Load the item detail content specified by the fragment
                // arguments. In a real-world scenario, use a Loader
                // to load content from a content provider.
                it.getString(ARG_ITEM_ID)?.let { id ->
                    presenter.getItemDetail(id)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.item_detail, container, false)

        return rootView
    }
    //endregion

    //region Contract
    override fun setItemDetail(itemDetail: ItemDetail) {
        activity?.ctlToolbar?.title = itemDetail.title
        activity?.let { activity ->

            itemDetail.pictures?.let { pictures ->

                Glide.with(activity)
                    .load(pictures[0].source).diskCacheStrategy(DiskCacheStrategy.DATA)
                    .into(activity.ivProduct)

            }
        }

        rootView.tvItemDetail.text = itemDetail.description
        rootView.tvItemPrice.text = getString(R.string.price, itemDetail.price)
        if(itemDetail.warranty != null) {
            rootView.tvItemWarranty.text = getString(R.string.warring, itemDetail.warranty)
        } else {
            rootView.tvItemWarranty.visibility = View.GONE
        }
        rootView.tvItemQtd.text = getString(R.string.qtd, itemDetail.availableQuantity ?: 0)
        rootView.tvItemQtdSold.text = getString(R.string.qtd_sold, itemDetail.soldQuantity ?: 0)
    }
    //endregion

}
