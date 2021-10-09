package paging.android.example.com.pagingsample.data

data class VideosResponse(
    var code: Int?,
    var response: VidResponse?
)

data class VidResponse(
    var videos: HashMap<String,VideoDescription>?
)


data class VideoDescription(
    var categories: String?,
    var description: String?,
    var thumbnailURL: String?,
    var title: String?,
    var videoURL: String?
)