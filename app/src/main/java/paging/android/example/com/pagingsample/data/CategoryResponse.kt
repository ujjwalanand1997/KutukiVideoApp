package paging.android.example.com.pagingsample.data

data class CategoryResponse(
    var code: Int?,
    var response: CatResponse?
)

data class CatResponse(
    var videoCategories: HashMap<String,Description>?
)


data class Description(
    var image: String?,
    var name: String?
)