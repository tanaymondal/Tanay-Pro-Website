package org.example.project

import DarkColors
import LightColors
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import backgroundColor
import org.example.project.ui.showHome
import org.example.project.ui.showResume

@Composable
fun App() {
    val colors = if (isSystemInDarkTheme()) DarkColors else LightColors
    MaterialTheme(colors = colors) {
        var selectedTab by remember {
            mutableStateOf(0)
        }

        val tabList = remember {
            listOf("Home", "About", "Skills", "Work", "Projects", "Extra")
        }

        Column(
            modifier = Modifier.fillMaxSize().background(color = backgroundColor),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.size(20.dp))
            TabRow(
                selectedTabIndex = selectedTab,
                modifier = Modifier.fillMaxWidth()
            ) {

                tabList.forEachIndexed { index, text ->
                    Tab(index == selectedTab, onClick = {
                        selectedTab = index
                    }, text = {
                        Text(text = text.uppercase())
                    })
                }
            }
            Spacer(modifier = Modifier.size(20.dp))

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                when (selectedTab) {
                    0 -> showHome()
                    1 -> showResume()
                    2 -> showHome()
                    3 -> showResume()
                    4 -> showHome()
                    5 -> showResume()
                }
            }


        }


    }
}