package android.spaceghost.utils

import android.content.Context
import androidx.appcompat.app.AlertDialog


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
