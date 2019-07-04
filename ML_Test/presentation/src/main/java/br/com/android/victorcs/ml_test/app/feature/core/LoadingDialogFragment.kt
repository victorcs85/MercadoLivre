package br.com.android.victorcs.ml_test.app.feature.core

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import br.com.android.victorcs.ml_test.R

/**
 * Default loading dialog full screen.
 * @author victorcs
 */
class LoadingDialogFragment : DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.dialog_loading, container, false)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val loadingDialog = object : Dialog(context!!, R.style.LoadingDialogTheme) {

            override fun onBackPressed() {
                // disabled
            }
        }

        val view = LayoutInflater.from(context).inflate(R.layout.dialog_loading, null)
        loadingDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        loadingDialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        loadingDialog.setContentView(view)
        loadingDialog.show()
        return loadingDialog
    }

    override fun onStart() {
        super.onStart()
        dialog?.apply {
            window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        }
    }
}