package android.spaceghost.adapters

import android.content.Context
import android.spaceghost.R
import android.spaceghost.models.EpisodeItem
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_item_episode.view.*

class EpisodeAdapter(val episodes: List<EpisodeItem>, val context: Context, val episodeClickListener: EpisodeClickListener) : RecyclerView.Adapter<EpisodeItemViewHolder>() {

    companion object {
        var mClickListener: EpisodeClickListener? = null
    }

    open interface EpisodeClickListener {
        fun onEpisodeClicked(episode: EpisodeItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeItemViewHolder {
        return EpisodeItemViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item_episode, parent, false))
    }

    override fun onBindViewHolder(holder: EpisodeItemViewHolder, position: Int) {
        val item = episodes.get(position)
        holder?.title?.text = "Episode " + item.getEpisodeNumber() + ": " + item.getTitle()
        holder?.image?.setImageResource(R.drawable.default_background)

        // set click listener for episode item
        mClickListener = episodeClickListener

        holder?.cardView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                println(item.getVideoUrl())
                if (mClickListener != null) {
                    mClickListener?.onEpisodeClicked(item)
                }
            }
        })
    }


    override fun getItemCount(): Int {
        return episodes.size
    }

}

class EpisodeItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val title = view.episodeTitle
    val image = view.characterProfileImage
    val cardView = view.cardView
}

