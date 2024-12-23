import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ui.pages.AboutPage
import ui.pages.HomePage
import ui.theme.MontFontFamily

@Composable
fun App() {
    val colors = if (isSystemInDarkTheme()) DarkColors else LightColors
    MaterialTheme(colors = colors) {
        var selectedTab by remember {
            mutableStateOf(0)
        }

        val tabList = remember {
            listOf("Home", "About", "Skills", "Work", "Projects")
        }

        val pagerState = rememberPagerState(pageCount = {
            5
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
    Column(
        modifier = Modifier.fillMaxSize().background(color = backgroundColor),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(Modifier.size(20.dp))

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

        Spacer(modifier = Modifier.size(20.dp))

        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize(),
            snapPosition = SnapPosition.Center
        ) { page ->
            when (page) {
                0 -> HomePage()
                1 -> AboutPage()
                2 -> HomePage()
                3 -> HomePage()
                4 -> HomePage()
            }
        }
    }
}