import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ui.pages.AboutPage
import ui.pages.HomePage
import ui.pages.SkillsPage
import ui.theme.MontFontFamily

@Composable
fun App() {
    val colors = if (isSystemInDarkTheme()) DarkColors else LightColors
    MaterialTheme(colors = colors) {
        var selectedTab by remember {
            mutableStateOf(0)
        }

        val tabList = remember {
            listOf("Home", "About", "Skills"/*, "Work", "Projects"*/)
        }

        val pagerState = rememberPagerState(pageCount = {
            tabList.size
        })

        LaunchedEffect(selectedTab) {
            pagerState.animateScrollToPage(selectedTab)
        }

        MainUI(
            tabList = tabList,
            selectedTab = selectedTab,
            pagerState = pagerState,
            onTabClick = { index ->
                selectedTab = index
            })

    }
}

@Composable
fun MainUI(
    tabList: List<String>,
    selectedTab: Int,
    pagerState: PagerState,
    onTabClick: (Int) -> Unit
) {

    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()

    val uriHandler = LocalUriHandler.current

    Column(
        modifier = Modifier.background(color = backgroundColor).fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(Modifier.fillMaxWidth().size(20.dp))

        TabRow(selectedTabIndex = selectedTab, modifier = Modifier.fillMaxWidth()) {
            tabList.forEachIndexed { index, text ->
                Tab(index == selectedTab, onClick = {

                    onTabClick(index)
                }, text = {
                    Text(
                        text = text.uppercase(),
                        maxLines = 1,
                        fontSize = 16.sp,
                        fontFamily = MontFontFamily()
                    )
                }, selectedContentColor = Color.Yellow)
            }
        }

        Spacer(modifier = Modifier.fillMaxWidth().size(20.dp))

        HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight(1f),
            snapPosition = SnapPosition.Center
        ) { page ->
            when (page) {
                0 -> HomePage()
                1 -> AboutPage()
                2 -> SkillsPage()
                /*3 -> HomePage()
                4 -> HomePage()*/
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth().padding(15.dp).align(Alignment.CenterHorizontally),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Built using ",
                fontFamily = MontFontFamily(),
                color = Color.White,
                textAlign = TextAlign.Center,
                fontSize = 12.sp
            )
            Text(
                text = "Compose Multiplatform",
                modifier = Modifier.hoverable(interactionSource).clickable {
                    val url = "https://www.jetbrains.com/compose-multiplatform"
                    uriHandler.openUri(url)
                },
                fontFamily = MontFontFamily(),
                color = if (isHovered) Color.Yellow else Color.White,
                textAlign = TextAlign.Center,
                fontSize = 12.sp,
                textDecoration = TextDecoration.Underline
            )
        }


    }
}