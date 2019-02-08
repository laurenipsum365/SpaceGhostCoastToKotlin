import android.content.Intent
import android.os.Bundle
import android.spaceghost.R
import android.spaceghost.activities.VideoPlayerActivity
import android.spaceghost.activities.WebViewActivity
import android.spaceghost.adapters.EpisodeAdapter
import android.spaceghost.models.EpisodeItem
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_episode_list.*

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
        // load urls from adult swim website into array of EpisodeItems
        addEpisodes()

        // Creates a vertical Layout Manager
        episodeRecyclerView.layoutManager = LinearLayoutManager(context) as RecyclerView.LayoutManager?

        // Access the RecyclerView Adapter and load the data into it
        episodeRecyclerView.adapter = EpisodeAdapter(episodes, context, this)

        super.onStart()
    }

    fun handleEpisodeClicked(episodeItem: EpisodeItem) {
        val intent = Intent(context, VideoPlayerActivity::class.java)
        intent.putExtra(WebViewActivity.VIDEO_OBJECT_URL, episodeItem.getVideoUrl())
        startActivity(intent)
    }

    fun addEpisodes() {
        episodes.add(EpisodeItem("http://www.adultswim.com/videos/space-ghost-coast-to-coast/spanish-translation/", "Spanish Translation"))
        episodes.add(EpisodeItem("http://www.adultswim.com/videos/space-ghost-coast-to-coast/hungry/", "Hungry"))
        episodes.add(EpisodeItem("http://www.adultswim.com/videos/space-ghost-coast-to-coast/elevator/", "Elevator"))
        episodes.add(EpisodeItem("http://www.adultswim.com/videos/space-ghost-coast-to-coast/spanish-translation/", "Spanish Translation"))
        episodes.add(EpisodeItem("http://www.adultswim.com/videos/space-ghost-coast-to-coast/hungry/", "Hungry"))
        episodes.add(EpisodeItem("http://www.adultswim.com/videos/space-ghost-coast-to-coast/elevator/", "Elevator"))
        episodes.add(EpisodeItem("http://www.adultswim.com/videos/space-ghost-coast-to-coast/spanish-translation/", "Spanish Translation"))
        episodes.add(EpisodeItem("http://www.adultswim.com/videos/space-ghost-coast-to-coast/hungry/", "Hungry"))
        episodes.add(EpisodeItem("http://www.adultswim.com/videos/space-ghost-coast-to-coast/elevator/", "Elevator"))
        episodes.add(EpisodeItem("http://www.adultswim.com/videos/space-ghost-coast-to-coast/spanish-translation/", "Spanish Translation"))
        episodes.add(EpisodeItem("http://www.adultswim.com/videos/space-ghost-coast-to-coast/hungry/", "Hungry"))
        episodes.add(EpisodeItem("http://www.adultswim.com/videos/space-ghost-coast-to-coast/elevator/", "Elevator"))
    }

    //---------------------------------------------//
    // Click Listeners
    //---------------------------------------------//

    // Click Listener for episode items in RecyclerView adapter
    override fun onEpisodeClicked(episodeItem: EpisodeItem) {
        handleEpisodeClicked(episodeItem)
    }
}
