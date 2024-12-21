package org.example.project

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.example.project.ui.showHome
import org.example.project.ui.showResume

@Composable
fun App() {
    MaterialTheme {
        var isHome by remember {
            mutableStateOf(true)
        }

        Column(
            Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.size(20.dp))
            Column(
                Modifier.size(1000.dp)
            ) {
                TabRow(
                    selectedTabIndex = if (isHome) 0 else 1,
                    modifier = Modifier.size(width = 200.dp, height = 40.dp),
                    backgroundColor = Color.White
                ) {
                    Tab(isHome, onClick = {
                        isHome = true
                    }, text = {
                        Text("Home")
                    })
                    Tab(isHome, onClick = {
                        isHome = false
                    }, text = {
                        Text("Resume")
                    })
                }
                Spacer(modifier = Modifier.size(20.dp))
                if (isHome) {
                    showHome()
                } else {
                    showResume()
                }
            }
        }


    }
}