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
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import tanay_website.composeapp.generated.resources.Res
import tanay_website.composeapp.generated.resources.image

@Composable
fun showHome() {
    SelectionContainer {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            val borderWidth = 4.dp

            Text(
                text = "Tanay\nMondal",
                textAlign = TextAlign.End,
                fontSize = 40.sp,
                lineHeight = 40.sp,
                color = Color.White
            )

            Spacer(modifier = Modifier.size(10.dp))

            Image(
                painter = painterResource(Res.drawable.image),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .sizeIn(
                        minHeight = 200.dp,
                        minWidth = 200.dp,
                        maxWidth = 500.dp,
                        maxHeight = 500.dp
                    )
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
                fontSize = 40.sp,
                lineHeight = 40.sp,
                color = Color.White
            )
        }
    }
}
