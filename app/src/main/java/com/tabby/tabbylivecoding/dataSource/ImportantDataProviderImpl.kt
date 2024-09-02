package com.tabby.tabbylivecoding.dataSource

import kotlinx.coroutines.delay
import java.util.Date
import kotlin.random.Random

class ImportantDataProviderImpl : ImportantDataProvider {

    private val random = Random(Date().time)

    override suspend fun retrieveImportantData(): List<Any> {
        delay(1000)
        return buildList {
            repeat(random.nextInt(0, 10)) {
                add(Unit)
            }
        }
    }
}