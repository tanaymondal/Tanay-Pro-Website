package org.example.project.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import tanay_website.composeapp.generated.resources.Res
import tanay_website.composeapp.generated.resources.image

@Composable
fun showHome() {
    Row {
        Image(
            painter = painterResource(Res.drawable.image),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(400.dp)
        )
        Spacer(modifier = Modifier.size(20.dp))
        Text(text = "I am a Senior Android Developer with 9 years of extensive experience in delivering impactful mobile applications. My expertise encompasses Android Development and technologies like Kotlin, Jetpack Compose, Kotlin Multiplatform, Flutter. I specialize in creating high-quality, user-centric applications, demonstrated through my collaborations with leading clients such as PayPal and projects that leverage cutting-edge technologies. My commitment to continuous learning drives my ability to innovate in dynamic development environments.")
    }
}
