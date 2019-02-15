package android.spaceghost.chromecast

import android.content.Context
import android.spaceghost.R
import android.spaceghost.utils.UiUtils
import com.google.android.gms.cast.framework.SessionProvider

class CastOptionsProvider : com.google.android.gms.cast.framework.OptionsProvider {
    override fun getCastOptions(appContext: Context): com.google.android.gms.cast.framework.CastOptions {

        // Register you custom receiver on the Google Cast SDK Developer Console to get this ID.
        val receiverId: String = appContext.getString(R.string.chromecast_app_id)

        return com.google.android.gms.cast.framework.CastOptions.Builder()
                .setReceiverApplicationId(receiverId)
                .build()
    }

    override fun getAdditionalSessionProviders(context: Context): List<SessionProvider>? {
        return null
    }
}