package ui.pages

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import tanay_website.composeapp.generated.resources.github
import tanay_website.composeapp.generated.resources.graphql
import tanay_website.composeapp.generated.resources.java
import tanay_website.composeapp.generated.resources.kotlin
import tanay_website.composeapp.generated.resources.leetcode
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
        add(
            Images(
                name = "Kotlin",
                image = Res.drawable.kotlin,
                url = "https://kotlinlang.org/")
        )
        add(
            Images(
                name = "Java",
                image = Res.drawable.java,
                url = "https://en.wikipedia.org/wiki/Java_(programming_language)"
            )
        )
        add(
            Images(
                name = "Dart",
                image = Res.drawable.dart,
                url = "https://dart.dev/")
        )
        add(
            Images(
                name = "C",
                image = Res.drawable.c,
                url = "https://en.wikipedia.org/wiki/C_(programming_language)"
            )
        )
        add(
            Images(
                name = "SQL",
                image = Res.drawable.sql,
                url = "https://en.wikipedia.org/wiki/SQL"
            )
        )
    }

    val technology = mutableListOf<Images>().apply {
        add(
            Images(
                name = "Android",
                image = Res.drawable.android,
                url = "https://developer.android.com/"
            )
        )
        add(
            Images(
                name = "Compose Multi Platform",
                image = Res.drawable.cmp,
                url = "https://www.jetbrains.com/compose-multiplatform/"
            )
        )
        add(
            Images(
                name = "Flutter",
                image = Res.drawable.flutter,
                url = "https://flutter.dev/")
        )
        add(
            Images(
                name = "Git",
                image = Res.drawable.git,
                url = "https://git-scm.com/")
        )
        add(
            Images(
                name = "Firebase",
                image = Res.drawable.firebase,
                url = "https://firebase.google.com/"
            )
        )
        add(
            Images(
                name = "GraphQL",
                image = Res.drawable.graphql,
                url = "https://graphql.org/")
        )
        add(
            Images(name = "WebRTC",
                image = Res.drawable.webrtc,
                url = "https://webrtc.org/")
        )
        add(
            Images(
                name = "Spring",
                image = Res.drawable.spring,
                url = "https://spring.io/")
        )
        add(
            Images(
                name = "Netlify",
                image = Res.drawable.netlify,
                url = "https://www.netlify.com/"
            )
        )
        add(
            Images(
                name = "MongoDB",
                image = Res.drawable.mongodb,
                url = "https://www.mongodb.com/"
            )
        )
        add(
            Images(
                name = "Postgre SQL",
                image = Res.drawable.postgre,
                url = "https://www.postgresql.org/"
            )
        )
    }

    val other = mutableListOf<Images>().apply {
        add(
            Images(
                name = "Github",
                image = Res.drawable.github,
                url = "https://github.com/tanaymondal"
            )
        )
        add(
            Images(
                name = "Leetcode",
                image = Res.drawable.leetcode,
                url = "https://leetcode.com/u/tanaymondal/"
            )
        )
    }
    Row {
        Column(
            modifier = Modifier.fillMaxSize().weight(0.6f).padding(start = 100.dp, end = 100.dp),
            verticalArrangement = Arrangement.Center
        ) {
            ItemsRow(sectionTitle = "Programming Languages", list = language)

            Spacer(modifier = Modifier.size(100.dp))

            ItemsRow(sectionTitle = "Tools and Technology", list = technology)
        }

        Column(
            modifier = Modifier.fillMaxSize().weight(0.4f),
            verticalArrangement = Arrangement.Center
        ) {
            ItemsRow(boxHeight = 150, list = other)
        }

    }


}

data class Images(
    val name: String,
    val image: DrawableResource,
    val url: String = "",
    var mutableInteractionSource: MutableInteractionSource = MutableInteractionSource()
)