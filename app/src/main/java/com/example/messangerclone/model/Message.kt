package com.example.messangerclone.model

data class Message(
    var profile: Int,
    var fullname: String,
    var is_online: Boolean = false,

) {
}