package com.example.mymvvmproject.api.data.model


/**
 * 微信公众号列表
 */
data class WeChatArticle(
    val children: List<Any>,
    val courseId: Int,
    val id: Int,
    val name: String,
    val order: Int,
    val parentChapterId: Int,
    val userControlSetTop: Boolean,
    val visible: Int
)

