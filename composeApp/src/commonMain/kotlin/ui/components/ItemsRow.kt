package ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource
import ui.pages.Images
import ui.theme.MontFontFamily

@Composable
fun ItemsRow(sectionTitle: String = "", boxHeight: Int = 90, list: MutableList<Images>) {

    val uriHandler = LocalUriHandler.current

    val scrollState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Column(modifier = Modifier.fillMaxWidth()) {
        if (sectionTitle.isNotEmpty()) {
            Text(
                text = (sectionTitle),
                textAlign = TextAlign.Start,
                fontSize = 18.sp,
                color = Color.White,
                fontFamily = MontFontFamily()
            )
        }

        LazyRow(
            state = scrollState,
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
                .navigationBarsPadding()
                .imePadding().pointerInput(Unit) {
                    detectDragGestures { change, dragAmount ->
                        change.consume()
                        coroutineScope.launch {
                            scrollState.scrollBy(-dragAmount.x)
                        }
                    }
                },
        ) {
            items(items = list, key = { item -> item.name }) { item: Images ->

                Box(
                    modifier = Modifier.hoverable(item.mutableInteractionSource).width(boxHeight.dp)
                        .height(boxHeight.dp).clickable {
                            uriHandler.openUri(item.url)
                        }
                ) {
                    Image(
                        painter = painterResource(item.image),
                        contentDescription = "",
                        modifier = Modifier.clip(RoundedCornerShape(15.dp))
                            .background(color = Color(0xFF2A2D35))
                    )

                    Spacer(modifier = Modifier.size(5.dp))
                    val isHovered by item.mutableInteractionSource.collectIsHoveredAsState()
                    if (isHovered) {
                        Text(
                            text = item.name,
                            fontSize = 12.sp,
                            color = Color.White,
                            fontFamily = MontFontFamily(),
                            modifier = Modifier
                                .clip(RoundedCornerShape(5.dp))
                                .background(color = Color(0xFF5B5C5C))
                                .padding(start = 8.dp, end = 8.dp, top = 4.dp, bottom = 4.dp)
                                .align(alignment = Alignment.BottomCenter)
                        )
                    }
                }

            }
        }
    }
}