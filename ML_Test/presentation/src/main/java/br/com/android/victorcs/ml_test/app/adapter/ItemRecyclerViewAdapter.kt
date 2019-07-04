package br.com.android.victorcs.ml_test.app.adapter

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import br.com.android.victorcs.domain.vo.ItemResult
import br.com.android.victorcs.domain.vo.Items
import br.com.android.victorcs.ml_test.R
import br.com.android.victorcs.ml_test.app.feature.detail.ItemDetailActivity
import br.com.android.victorcs.ml_test.app.feature.detail.ItemDetailFragment
import br.com.android.victorcs.ml_test.app.feature.main.MainScreenActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.synthetic.main.item_list_content.view.*

/**
 * List items adapter, setup and control all structure data to RecyclerView.
 * @author victorcs
 */
class ItemRecyclerViewAdapter(
    private val parentActivity: MainScreenActivity,
    private val values: Items,
    private val twoPane: Boolean
) :
    RecyclerView.Adapter<ItemRecyclerViewAdapter.ViewHolder>() {

    private val onClickListener: View.OnClickListener

    init {
        // Setup and set an event click to capture item id and send to detail screen to call load item detail.
        onClickListener = View.OnClickListener { v ->
            val item = v.tag as ItemResult
            if (twoPane) {
                val fragment = ItemDetailFragment().apply {
                    arguments = Bundle().apply {
                        putString(ItemDetailFragment.ARG_ITEM_ID, item.id)
                    }
                }
                parentActivity.supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.itemDetailContainer, fragment)
                    .commit()
            } else {
                val intent = Intent(v.context, ItemDetailActivity::class.java).apply {
                    putExtra(ItemDetailFragment.ARG_ITEM_ID, item.id)
                }
                v.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_content, parent, false)
        return ViewHolder(view)
    }

    // Setup holder with item detail data.
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        values.results?.let {
            val item = it[position]
            Glide.with(parentActivity).load(item.thumbnail).diskCacheStrategy(DiskCacheStrategy.DATA)
                .into(holder.acivThumb)
            holder.tvTitle.text = item.title
            holder.tvPrice.text = item.price

            with(holder.itemView) {
                tag = item
                setOnClickListener(onClickListener)
            }
        }
    }

    override fun getItemCount() = values.results?.size ?: 0

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val acivThumb: AppCompatImageView = view.acivThumb
        val tvTitle: TextView = view.tvTitle
        val tvPrice: TextView = view.tvPrice
    }
}