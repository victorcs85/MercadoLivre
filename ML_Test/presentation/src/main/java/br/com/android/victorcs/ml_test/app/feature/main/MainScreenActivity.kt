package br.com.android.victorcs.ml_test.app.feature.main

import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.android.victorcs.domain.vo.Items
import br.com.android.victorcs.ml_test.R
import br.com.android.victorcs.ml_test.app.adapter.ItemRecyclerViewAdapter
import br.com.android.victorcs.ml_test.app.feature.core.BaseActivity
import kotlinx.android.synthetic.main.activity_item_list.*
import kotlinx.android.synthetic.main.item_list.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf


/**
 * An activity representing a list of Pings. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a ItemDetailActivity representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 * @author victorcs
 */
class MainScreenActivity : BaseActivity(), MainScreenContract.View {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private var twoPane: Boolean = false

    private val presenter by inject<MainScreenContract.Presenter> { parametersOf(this) }

    //region Life cycle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_list)

        if (itemDetailContainer != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            twoPane = true
        }

        initComponents()

    }

    // Setup searchview, set text query server search.
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search_menu, menu)

        val searchView = menu?.findItem(R.id.menu_search)?.actionView as SearchView

        searchView.queryHint = getString(R.string.search_title)
        searchView.maxWidth = Integer.MAX_VALUE
        searchView.setIconifiedByDefault(false)
        searchView.requestFocus()

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    presenter.getItems(it)
                }
                searchView.clearFocus()
                return false
            }

        })

        return true
    }
    //endregion

    //region Contract
    // Initialize components screen.
    override fun initComponents() {
        setSupportActionBar(toolbar)
        rvItems.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rvItems.visibility = View.GONE
        tvEmpty.visibility = View.VISIBLE
    }

    // Setup recyclerview by server response.ó
    override fun setupRecyclerViewAdapter(items: Items) {
        rvItems.adapter =
            ItemRecyclerViewAdapter(
                this,
                items,
                twoPane
            )

        if (items.results == null || items.results!!.isEmpty()) {
            rvItems.visibility = View.GONE
            tvEmpty.visibility = View.VISIBLE
        } else {
            rvItems.visibility = View.VISIBLE
            tvEmpty.visibility = View.GONE
        }
    }
    //endregion
}
