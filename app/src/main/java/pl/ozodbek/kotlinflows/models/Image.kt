package pl.ozodbek.kotlinflows.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Image(
    @SerialName("createdAt")
    val createdAt: String,
    @SerialName("id")
    val id: Int,
    @SerialName("imagePath")
    val imagePath: String,
    @SerialName("postId")
    val postId: Int,
    @SerialName("updatedAt")
    val updatedAt: String
)