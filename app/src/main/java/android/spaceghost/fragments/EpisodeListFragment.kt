import android.content.Intent
import android.os.Bundle
import android.spaceghost.R
import android.spaceghost.activities.VideoPlayerActivity
import android.spaceghost.adapters.EpisodeAdapter
import android.spaceghost.models.EpisodeItem
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_episode_list.*


// Here's Brak
// https://www.youtube.com/watch?v=3_YLTEVMfUI
class EpisodeListFragment : Fragment(), EpisodeAdapter.EpisodeClickListener {

    private val episodes: ArrayList<EpisodeItem> = ArrayList()

    companion object {

        fun newInstance(): EpisodeListFragment {
            return EpisodeListFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_episode_list, container, false)
    }

    override fun onStart() {

        if (episodes == null || episodes.isEmpty()) {
            // load urls from adult swim website into array of EpisodeItems
            addEpisodes()

            // Creates a vertical Layout Manager
            episodeRecyclerView.layoutManager = LinearLayoutManager(context) as RecyclerView.LayoutManager?

            // Access the RecyclerView Adapter and load the data into it
            episodeRecyclerView.adapter = EpisodeAdapter(episodes, context, this)
        }

        super.onStart()
    }

    fun handleEpisodeClicked(episodeItem: EpisodeItem) {
        val intent = Intent(context, VideoPlayerActivity::class.java)
        intent.putExtra(VideoPlayerActivity.VIDEO_OBJECT_URL, episodeItem.getVideoId())
        startActivity(intent)
    }

    fun addEpisodes() {

        // Season 2
        episodes.add(EpisodeItem("mClcxomsErI", "President's Day Nightmare", 1, 2))
        episodes.add(EpisodeItem("CwGcak8NuF8", "Girly Show", 3, 2))
        episodes.add(EpisodeItem("Ep2MVdCFYhY", "Hungry", 4, 2))
        episodes.add(EpisodeItem("VNRAF2z1EdU", "Fire Drill", 5, 2))
        episodes.add(EpisodeItem("JqbnHyWwQLA", "Sleeper", 7, 2))
        episodes.add(EpisodeItem("1ltvkPo6qqo", "Jerk", 8, 2))
        episodes.add(EpisodeItem("WNybLehBI9w", "Urges", 9, 2))

        // Season 3
        episodes.add(EpisodeItem("GEfFNgPb6FU", "Explode", 1, 3))
        episodes.add(EpisodeItem("v3EM2si3v4o", "Transcript", 4, 3))
        episodes.add(EpisodeItem("SLCy-xFyRt0", "Sharrock", 5, 3))
        episodes.add(EpisodeItem("26p6SvZZ6bc", "Boo!", 6, 3))
        episodes.add(EpisodeItem("pvEjX2Tfs_I", "Freak Show", 7, 3))
        episodes.add(EpisodeItem("4FmG9mtVMtE", "Switcharoo", 8, 3))
        episodes.add(EpisodeItem("upBr5rOQBT0", "Glen Campbell", 10, 3))
        episodes.add(EpisodeItem("DoV5yyfSJXQ", "Cookout", 13, 3))
        episodes.add(EpisodeItem("IpoQrhHdnvg", "Woody Allen's Fall Project", 15, 3))

    }

    //---------------------------------------------//
    // Click Listeners
    //---------------------------------------------//

    // Click Listener for episode items in RecyclerView adapter
    override fun onEpisodeClicked(episodeItem: EpisodeItem) {
        handleEpisodeClicked(episodeItem)
    }
}
