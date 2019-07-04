package br.com.android.victorcs.ml_test.app.feature.core

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import br.com.android.victorcs.ml_test.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_item_list.*

/**
 * Base parent activity with common functions.
 * @author victorcs
 */
abstract class BaseActivity : AppCompatActivity(), BaseView {

    private var loadingDialog: LoadingDialogFragment? = null
    private lateinit var alertBuilder: AlertDialog.Builder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadingDialog = LoadingDialogFragment()
    }

    override fun showMessage(message: String) {
        showAlertDialog(message)
    }

    override fun showMessage(messageResId: Int) {
        showAlertDialog(messageResId)
    }

    override fun showLoading() {
        if (loadingDialog == null || loadingDialog?.isAdded != true) {
            loadingDialog?.show(supportFragmentManager, null)
        }
    }

    override fun hideLoading() {
        if (loadingDialog != null && loadingDialog?.isAdded == true) {
            loadingDialog?.dismiss()
        }
    }

    private fun showAlertDialog(message: Any) {
        alertBuilder = AlertDialog.Builder(this)

        alertBuilder.apply {
            setCancelable(false)
            when (message) {
                is String -> setMessage(message)
                is Int -> setMessage(getString(message))
            }

            setPositiveButton(getString(R.string.action_ok)) { dialog, _ ->
                dialog.dismiss()
            }
        }

        if(!alertBuilder.create().isShowing) {
            alertBuilder.create().show()
        }
    }

    override fun showNetworkError() {
        Snackbar.make(rootLayout, R.string.message_network_unavailable, Snackbar.LENGTH_INDEFINITE)
    }

}