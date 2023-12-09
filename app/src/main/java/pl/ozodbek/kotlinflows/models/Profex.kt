@file:Suppress("EXTERNAL_SERIALIZER_USELESS")

package pl.ozodbek.kotlinflows.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class Profex(
    @SerialName("categoryId")
    val categoryId: Int,
    @SerialName("categoryName")
    val categoryName: String,
    @SerialName("createdAt")
    val createdAt: String,
    @SerialName("description")
    val description: String,
    @SerialName("district")
    val district: String,
    @SerialName("firstName")
    val firstName: String,
    @SerialName("id")
    val id: Int,
    @SerialName("imagePath")
    val imagePath: List<String>,
    @SerialName("images")
    val images: List<Image>,
    @SerialName("lastName")
    val lastName: String,
    @SerialName("latidute")
    val latidute: Int,
    @SerialName("longitude")
    val longitude: Int,
    @SerialName("phoneNumber")
    val phoneNumber: String,
    @SerialName("price")
    val price: Int,
    @SerialName("region")
    val region: String,
    @SerialName("title")
    val title: String,
    @SerialName("updatedAt")
    val updatedAt: String,
    @SerialName("userId")
    val userId: Int
)