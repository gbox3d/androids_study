package com.example.ex02timer

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform