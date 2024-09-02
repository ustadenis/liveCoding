package com.tabby.tabbylivecoding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tabby.tabbylivecoding.dataSource.ImportantDataProvider
import com.tabby.tabbylivecoding.dataSource.ImportantDataProviderImpl
import com.tabby.tabbylivecoding.ui.theme.TabbyLiveCodingTheme

class MainActivity : ComponentActivity() {

    private val importantDataProvider: ImportantDataProvider by lazy {
        ImportantDataProviderImpl()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TabbyLiveCodingTheme {
                var data by remember { mutableStateOf(emptyList<Any>()) }

                LaunchedEffect(key1 = Unit) {
                    data = importantDataProvider.retrieveImportantData()
                }

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LazyColumn(
                        modifier = Modifier.padding(innerPadding),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(data) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .requiredHeight(80.dp)
                                    .background(Color.Gray)
                            )
                        }
                    }
                }
            }
        }
    }
}