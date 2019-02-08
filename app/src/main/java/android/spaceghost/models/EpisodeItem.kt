package android.spaceghost.models

class EpisodeItem(id: String?, title: String?, episodeNumber: Int?, seasonNumber: Int?) {
    private var title: String? = null
    private var videoId: String? = null
    private var seasonNumber: Int? = null
    private var episodeNumber: Int? = null

    init {
        this.videoId = id
        this.title = title
        this.episodeNumber = episodeNumber
        this.seasonNumber = seasonNumber
    }

    // This would have worked when using urls straight from adultswim website
    fun titleFromUrl(url: String?): String? {
        var title = ""

        if (url != null) {
            if (url.contains("space-ghost-coast-to-coast")) {
                var splitString = url.split("space-ghost-coast-to-coast/")
                title = splitString[1].slice(IntRange(0, splitString[1].length - 2))
            }

            if (title.contains("-")) {
                var expTitleChars = title.split("-")
                var newTitle = ""

                for (item in expTitleChars) {
                    newTitle = newTitle.plus(item.capitalize() + " ")
                }

                title = newTitle
            } else {
                title = title.capitalize()
            }
        }

        return title
    }

    /**
     * Getters / Setters
     */
    fun getTitle(): String? {
        return title
    }

    fun getVideoId(): String? {
        return videoId
    }

    fun getSeason(): Int? {
        return seasonNumber
    }

    fun getEpisodeNumber(): Int? {
        return episodeNumber
    }


}
