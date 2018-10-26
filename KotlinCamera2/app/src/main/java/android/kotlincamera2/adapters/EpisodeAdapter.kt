package android.kotlincamera2.adapters

import android.content.Context
import android.kotlincamera2.R
import android.kotlincamera2.models.EpisodeItem
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_item_episode.view.*

class EpisodeAdapter(val episodes: List<EpisodeItem>, val context: Context) : RecyclerView.Adapter<EpisodeItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeItemViewHolder {
        return EpisodeItemViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item_episode, parent, false))
    }

    override fun onBindViewHolder(holder: EpisodeItemViewHolder, position: Int) {
        val item = episodes.get(position)
        holder?.title?.text = "Episode " + item.getEpisodeNumber() + ": " + item.getTitle()
        holder?.image?.setImageResource(R.drawable.default_background)
    }


    override fun getItemCount(): Int {
        return episodes.size
    }

}

class EpisodeItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val title = view.episodeTitle
    val image = view.characterProfileImage
}