package com.example.ex01hello

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform