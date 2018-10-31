package android.kotlincamera2.utils

import android.content.Context
import android.support.v7.app.AlertDialog


class UiUtils {

    companion object {
        fun showAlertDialog(context: Context, title: String?, message: String?) {

            val builder = AlertDialog.Builder(context)

            if (title != null) {
                builder.setTitle(title)
            }

            if (message != null) {
                builder.setMessage(message)
            }

            builder.setNeutralButton("OK") { _, _ ->

            }

            val dialog: AlertDialog = builder.create()

            dialog.show()
        }
    }
}
