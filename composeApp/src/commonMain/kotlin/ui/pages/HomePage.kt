package ui.pages

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import coil3.compose.AsyncImagePainter
import coil3.compose.SubcomposeAsyncImage
import coil3.compose.SubcomposeAsyncImageContent
import coil3.request.ImageRequest
import coil3.request.crossfade


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun HomePage() {
    SelectionContainer {

        val width = LocalWindowInfo.current.containerSize.component1()
        val height = LocalWindowInfo.current.containerSize.component2()

        val ratio = width.toFloat() / height.toFloat()
        val imageSize = ratio * 350
        val textSize = ratio * 30

        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            val borderWidth = 8.dp

            Text(
                text = "Tanay\nMondal".uppercase(),
                textAlign = TextAlign.End,
                fontSize = textSize.sp,
                lineHeight = textSize.sp,
                color = Color.White,
                maxLines = 2
            )

            Spacer(modifier = Modifier.size(10.dp))

            SubcomposeAsyncImage(
                model = ImageRequest.Builder(PlatformContext.INSTANCE)
                    .data("https://tanay.pro/images/home/image.jpeg")
                    .crossfade(true)
                    .build(),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(imageSize.dp)
                    .border(
                        BorderStroke(borderWidth, Color.Yellow),
                        CircleShape
                    )
                    .padding(borderWidth)
                    .clip(CircleShape)
            ) {
                val state by painter.state.collectAsState()
                if (state is AsyncImagePainter.State.Success) {
                    SubcomposeAsyncImageContent()
                } else {
                    CircularProgressIndicator(
                        modifier = Modifier.size(50.dp),
                        strokeWidth = 6.dp,
                        color = Color.White
                    )
                }
            }

            Spacer(modifier = Modifier.size(10.dp))

            Text(
                text = "Mobile\nDeveloper".uppercase(),
                textAlign = TextAlign.Start,
                fontSize = textSize.sp,
                lineHeight = textSize.sp,
                color = Color.White,
                maxLines = 2
            )
        }
    }
}
