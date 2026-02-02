/*
 * Copyright (c) 2025 Meshtastic LLC
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package org.meshtastic.core.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val MeshtasticGreen = Color(0xFF000000)
val MeshtasticAlt = Color(0xFF1A1A1A)
val HyperlinkBlue = Color(0xFF000000)
val AnnotationColor = Color(0xFF000000)

object TracerouteColors {
    // High-contrast pair that stays legible on light/dark tiles and for most color-blind users.
    // Use partial alpha so polylines don’t overpower markers/tiles.
    val OutgoingRoute = Color(0xCC000000) // black @ ~80% opacity
    val ReturnRoute = Color(0xCC666666) // gray @ ~80% opacity
}

object IAQColors {
    val IAQExcellent = Color(0xFF000000)
    val IAQGood = Color(0xFF333333)
    val IAQLightlyPolluted = Color(0xFF666666)
    val IAQModeratelyPolluted = Color(0xFF888888)
    val IAQHeavilyPolluted = Color(0xFFAAAAAA)
    val IAQSeverelyPolluted = Color(0xFFCCCCCC)
    val IAQExtremelyPolluted = Color(0xFFE0E0E0)
    val IAQDangerouslyPolluted = Color(0xFFE0E0E0)
}

object GraphColors {
    val InfantryBlue = Color(0xFF111111)
    val LightGreen = Color(0xFF333333)
    val Purple = Color(0xFF4D4D4D)
    val Pink = Color(0xFF666666)
    val Orange = Color(0xFF7A7A7A)

    val Green = Color(0xFF2B2B2B)
    val Red = Color(0xFF3D3D3D)
    val Blue = Color(0xFF4F4F4F)
    val Yellow = Color(0xFF616161)
    val Magenta = Color(0xFF737373)
    val Cyan = Color(0xFF858585)
}

object StatusColors {
    val ColorScheme.StatusGreen: Color
        @Composable
        get() =
            if (isSystemInDarkTheme()) {
                Color(0xFFBDBDBD)
            } else {
                Color(0xFF2B2B2B)
            }

    val ColorScheme.StatusYellow: Color
        @Composable
        get() =
            if (isSystemInDarkTheme()) {
                Color(0xFF9E9E9E)
            } else {
                Color(0xFF3D3D3D)
            }

    val ColorScheme.StatusOrange: Color
        @Composable
        get() =
            if (isSystemInDarkTheme()) {
                Color(0xFF8A8A8A)
            } else {
                Color(0xFF4F4F4F)
            }

    val ColorScheme.StatusRed: Color
        @Composable
        get() =
            if (isSystemInDarkTheme()) {
                Color(0xFF757575)
            } else {
                Color(0xFF5C5C5C)
            }

    val ColorScheme.StatusBlue: Color
        @Composable
        get() =
            if (isSystemInDarkTheme()) {
                Color(0xFF9E9E9E)
            } else {
                Color(0xFF5C5C5C)
            }
}

object MessageItemColors {
    val Red = Color(0x4D000000)
}
