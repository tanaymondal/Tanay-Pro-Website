package ui.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.PlatformContext
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import org.jetbrains.compose.resources.painterResource
import tanay_website.composeapp.generated.resources.Res
import tanay_website.composeapp.generated.resources.loading
import ui.theme.MontFontFamily

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun AboutPage() {
    SelectionContainer {

        val width = LocalWindowInfo.current.containerSize.component1()
        val height = LocalWindowInfo.current.containerSize.component2()

        val ratio = width.toFloat() / height.toFloat()
        val imageSize = ratio * 350

        Row(
            modifier = Modifier.fillMaxSize().padding(50.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            AsyncImage(
                model = ImageRequest.Builder(PlatformContext.INSTANCE)
                    .data("https://tanay.pro/images/about/mobile_app.jpg")
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                placeholder = painterResource(Res.drawable.loading),
                modifier = Modifier
                    .weight(1f)
                    .size(imageSize.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.size(10.dp))

            Text(
                text = ("I am a Senior Android Developer with 9 years of extensive experience in delivering impactful mobile applications.\n\n" +
                        "My expertise encompasses Android Development and technologies like Kotlin, Jetpack Compose, Kotlin Multiplatform, Flutter. I specialize in creating high-quality, user-centric applications, demonstrated through my collaborations with leading clients such as PayPal and projects that leverage cutting-edge technologies.\n\n" +
                        "My commitment to continuous learning drives my ability to innovate in dynamic development environments."),
                textAlign = TextAlign.Start,
                fontSize = 18.sp,
                color = Color.White,
                fontFamily = MontFontFamily(),
                modifier = Modifier.weight(1f)
            )
        }
    }
}