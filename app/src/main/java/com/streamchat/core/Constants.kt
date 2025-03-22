package com.streamchat.core

object Constants {
    // Для отримання API ключа:
    // 1. Перейдіть на https://console.developers.google.com
    // 2. Створіть новий проект або виберіть існуючий
    // 3. Увімкніть YouTube Data API v3
    // 4. Створіть облікові дані (OAuth 2.0 або API ключ)
    // 5. Скопіюйте ключ сюди
    const val YOUTUBE_API_KEY = "AIzaSyBNFqUmAVyODPat0w0HOa6W6POq0N6cook"

    const val APPLICATION_NAME = "StreamChat"
    
    // Налаштування логування
    const val LOG_TAG = "StreamChat"
    const val DEBUG = true
    
    // Налаштування YouTube API
    const val MAX_RESULTS = 200L
    const val POLLING_INTERVAL = 5000L // 5 секунд
    const val MAX_RETRIES = 3
} 