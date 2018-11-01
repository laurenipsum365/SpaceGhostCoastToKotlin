package android.spaceghost

import android.app.Application
import android.graphics.Typeface

class KotlinApp : Application() {

    companion object {
        const val CONSTANT = 12
        lateinit var typeface: Typeface
    }

    override fun onCreate() {
        super.onCreate()
        typeface = Typeface.createFromAsset(assets, "fonts/myFont.ttf")
    }

}