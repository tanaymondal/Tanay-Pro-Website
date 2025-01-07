package ui.pages

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.DrawableResource
import tanay_website.composeapp.generated.resources.Res
import tanay_website.composeapp.generated.resources.android
import tanay_website.composeapp.generated.resources.c
import tanay_website.composeapp.generated.resources.cmp
import tanay_website.composeapp.generated.resources.dart
import tanay_website.composeapp.generated.resources.firebase
import tanay_website.composeapp.generated.resources.flutter
import tanay_website.composeapp.generated.resources.git
import tanay_website.composeapp.generated.resources.graphql
import tanay_website.composeapp.generated.resources.java
import tanay_website.composeapp.generated.resources.kotlin
import tanay_website.composeapp.generated.resources.mongodb
import tanay_website.composeapp.generated.resources.netlify
import tanay_website.composeapp.generated.resources.postgre
import tanay_website.composeapp.generated.resources.spring
import tanay_website.composeapp.generated.resources.sql
import tanay_website.composeapp.generated.resources.webrtc
import ui.components.ItemsRow

@Composable
fun SkillsPage() {

    val language = mutableListOf<Images>().apply {
        add(Images("Kotlin", Res.drawable.kotlin))
        add(Images("Java", Res.drawable.java))
        add(Images("Dart", Res.drawable.dart))
        add(Images("C", Res.drawable.c))
        add(Images("SQL", Res.drawable.sql))
    }

    val technology = mutableListOf<Images>().apply {
        add(Images("Android", Res.drawable.android))
        add(Images("Flutter", Res.drawable.flutter))
        add(Images("Compose Multi Platform", Res.drawable.cmp))
        add(Images("Git", Res.drawable.git))
        add(Images("Firebase", Res.drawable.firebase))
        add(Images("GraphQl", Res.drawable.graphql))
        add(Images("WebRTC", Res.drawable.webrtc))
        add(Images("Spring", Res.drawable.spring))
        add(Images("Netlify", Res.drawable.netlify))
        add(Images("MongoDB", Res.drawable.mongodb))
        add(Images("Postgre", Res.drawable.postgre))
    }
    Column(
        modifier = Modifier.fillMaxSize().padding(start = 100.dp, end = 100.dp),
        verticalArrangement = Arrangement.Center
    ) {
        ItemsRow(sectionTitle = "Programming Languages", list = language)

        Spacer(modifier = Modifier.size(100.dp))

        ItemsRow(sectionTitle = "Tools and Technology", list = technology)
    }
}

data class Images(
    val name: String,
    val image: DrawableResource,
    var mutableInteractionSource: MutableInteractionSource = MutableInteractionSource()
)