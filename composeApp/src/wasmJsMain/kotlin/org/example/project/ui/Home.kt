package org.example.project.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
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
import org.jetbrains.compose.resources.painterResource
import tanay_website.composeapp.generated.resources.Res
import tanay_website.composeapp.generated.resources.image


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun showHome() {
    SelectionContainer {

        val width = LocalWindowInfo.current.containerSize.component1()
        val height = LocalWindowInfo.current.containerSize.component2()

        val ratio = width.toFloat() / height.toFloat()
        val imageSize = ratio * 400
        val textSize = ratio * 30

        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            val borderWidth = 4.dp

            Text(
                text = "Tanay\nMondal",
                textAlign = TextAlign.End,
                fontSize = textSize.sp,
                lineHeight = textSize.sp,
                color = Color.White,
                maxLines = 2
            )

            Spacer(modifier = Modifier.size(10.dp))

            Image(
                painter = painterResource(Res.drawable.image),
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
            )

            Spacer(modifier = Modifier.size(10.dp))

            Text(
                text = "Mobile\nDeveloper",
                textAlign = TextAlign.Start,
                fontSize = textSize.sp,
                lineHeight = textSize.sp,
                color = Color.White,
                maxLines = 2
            )
        }
    }
}
