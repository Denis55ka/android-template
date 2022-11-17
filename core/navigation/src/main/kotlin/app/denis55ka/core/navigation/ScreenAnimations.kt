package app.denis55ka.core.navigation

import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import kotlin.math.roundToInt

object ScreenAnimations {

    private const val SLIDE_PARALLAX_FACTOR = .2F

    val EnterSlide = slideInHorizontally { width -> width }

    val ExitSlide = slideOutHorizontally { width -> -(width * SLIDE_PARALLAX_FACTOR).roundToInt() }

    val PopEnterSlide = slideInHorizontally { width -> -(width * SLIDE_PARALLAX_FACTOR).roundToInt() }

    val PopExitSlide = slideOutHorizontally { width -> width }
}
