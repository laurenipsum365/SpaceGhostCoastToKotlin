package android.spaceghost.activities

import android.os.Bundle
import android.os.PersistableBundle
import android.spaceghost.R
import android.support.v7.app.AppCompatActivity

class VideoPlayerActivity : AppCompatActivity() {

    private val TAG = "VideoPlayerActivity"

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_video_player)

        println("onCreate: $TAG")
    }
}