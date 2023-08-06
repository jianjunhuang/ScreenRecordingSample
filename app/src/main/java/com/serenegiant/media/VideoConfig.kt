package com.serenegiant.media

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class VideoConfig(
    val width: Int,
    val height: Int,
    val fps: Int,
    val iFrameInterval: Int,
    val bits: Int,
    val frameInterpolation: Boolean
): Parcelable {

    companion object {
        @kotlin.jvm.JvmField
        var DEFAULT: VideoConfig = VideoConfig(1080, 1920, 24, 5, 1000, false)
    }
}
