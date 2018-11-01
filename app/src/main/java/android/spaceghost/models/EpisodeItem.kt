package android.spaceghost.models

class EpisodeItem(url: String?, episodeNumber: Int?) {
    private var title: String? = null
    private var videoUrl: String? = null
    private var seasonNumber: Int? = null
    private var episodeNumber: Int? = null

    init {
        this.videoUrl = url;
        this.title = titleFromUrl(url)
        this.episodeNumber = episodeNumber
    }

    fun titleFromUrl(url: String?) : String? {
        var title = ""

        if (url != null) {
            if (url.contains("space-ghost-coast-to-coast")) {
                var splitString = url.split("space-ghost-coast-to-coast/")
                title = splitString[1].slice(IntRange(0, splitString[1].length-2))
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
    fun getTitle() : String? {
        return title
    }

    fun getVideoUrl() : String? {
        return videoUrl
    }

    fun getSeason() : Int? {
        return seasonNumber
    }

    fun getEpisodeNumber() : Int? {
        return episodeNumber
    }


}
