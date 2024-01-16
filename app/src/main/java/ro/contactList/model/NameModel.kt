package ro.contactList.model

import android.media.MediaCodec.OnFirstTunnelFrameReadyListener

data class NameModel (
    val title: String,
    val first: OnFirstTunnelFrameReadyListener,
    val last: String,

        )