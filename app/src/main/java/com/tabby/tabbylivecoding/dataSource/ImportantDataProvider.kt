package com.tabby.tabbylivecoding.dataSource

interface ImportantDataProvider {
    suspend fun retrieveImportantData(): List<Any>
}