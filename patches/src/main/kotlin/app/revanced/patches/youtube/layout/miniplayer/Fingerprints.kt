package app.revanced.patches.youtube.layout.miniplayer

import app.revanced.patcher.fingerprint
import app.revanced.util.containsWideLiteralInstructionValue
import app.revanced.util.literal
import com.android.tools.smali.dexlib2.AccessFlags
import com.android.tools.smali.dexlib2.Opcode

internal val miniplayerDimensionsCalculatorParentFingerprint = fingerprint {
    accessFlags(AccessFlags.PUBLIC, AccessFlags.FINAL)
    returns("V")
    parameters("L")
    literal { floatyBarButtonTopMargin }
}

/**
 * Matches using the class found in [miniplayerModernViewParentFingerprint].
 */
internal val miniplayerModernAddViewListenerFingerprint = fingerprint {
    accessFlags(AccessFlags.PUBLIC, AccessFlags.FINAL)
    returns("V")
    parameters("Landroid/view/View;")
}

/**
 * Matches using the class found in [miniplayerModernViewParentFingerprint].
 */

internal val miniplayerModernCloseButtonFingerprint = fingerprint {
    accessFlags(AccessFlags.PUBLIC, AccessFlags.FINAL)
    returns("Landroid/widget/ImageView;")
    parameters()
    literal { modernMiniplayerClose }
}

const val MODERN_FEATURE_FLAGS_ENABLED_KEY_LITERAL = 45622882L

// In later targets this feature flag does nothing and is dead code.
const val MODERN_MINIPLAYER_ENABLED_OLD_TARGETS_FEATURE_KEY = 45630429L
const val DOUBLE_TAP_ENABLED_FEATURE_KEY_LITERAL = 45628823L
const val DRAG_DROP_ENABLED_FEATURE_KEY_LITERAL = 45628752L
const val INITIAL_SIZE_FEATURE_KEY_LITERAL = 45640023L
const val ANIMATION_INTERPOLATION_FEATURE_KEY = 45647018L
const val DROP_SHADOW_FEATURE_KEY = 45652223L
const val ROUNDED_CORNERS_FEATURE_KEY = 45652224L

internal val miniplayerModernConstructorFingerprint = fingerprint {
    accessFlags(AccessFlags.PUBLIC, AccessFlags.CONSTRUCTOR)
    parameters("L")
    literal { 45623000L }
}

/**
 * Matches using the class found in [miniplayerModernViewParentFingerprint].
 */
internal val miniplayerModernExpandButtonFingerprint = fingerprint {
    accessFlags(AccessFlags.PUBLIC, AccessFlags.FINAL)
    returns("Landroid/widget/ImageView;")
    parameters()
    literal { modernMiniplayerExpand }
}

/**
 * Matches using the class found in [miniplayerModernViewParentFingerprint].
 */
internal val miniplayerModernExpandCloseDrawablesFingerprint = fingerprint {
    accessFlags(AccessFlags.PUBLIC, AccessFlags.FINAL)
    returns("V")
    parameters("L")
    literal { ytOutlinePictureInPictureWhite24 }
}

/**
 * Matches using the class found in [miniplayerModernViewParentFingerprint].
 */
internal val miniplayerModernForwardButtonFingerprint = fingerprint {
    accessFlags(AccessFlags.PUBLIC, AccessFlags.FINAL)
    returns("Landroid/widget/ImageView;")
    parameters()
    literal { modernMiniplayerForwardButton }
}

/**
 * Matches using the class found in [miniplayerModernViewParentFingerprint].
 */
internal val miniplayerModernOverlayViewFingerprint = fingerprint {
    accessFlags(AccessFlags.PUBLIC, AccessFlags.FINAL)
    returns("V")
    parameters()
    literal { scrimOverlay }
}

/**
 * Matches using the class found in [miniplayerModernViewParentFingerprint].
 */
internal val miniplayerModernRewindButtonFingerprint = fingerprint {
    accessFlags(AccessFlags.PUBLIC, AccessFlags.FINAL)
    returns("Landroid/widget/ImageView;")
    parameters()
    literal { modernMiniplayerRewindButton }
}

internal val miniplayerModernViewParentFingerprint = fingerprint {
    accessFlags(AccessFlags.PUBLIC, AccessFlags.FINAL)
    returns("Ljava/lang/String;")
    parameters()
    strings("player_overlay_modern_mini_player_controls")
}

internal val miniplayerMinimumSizeFingerprint = fingerprint {
    accessFlags(AccessFlags.PUBLIC, AccessFlags.CONSTRUCTOR)
    custom { method, _ ->
        method.containsWideLiteralInstructionValue(192) &&
            method.containsWideLiteralInstructionValue(128) &&
            method.containsWideLiteralInstructionValue(miniplayerMaxSize)
    }
}

internal val miniplayerOverrideFingerprint = fingerprint {
    accessFlags(AccessFlags.PUBLIC, AccessFlags.FINAL)
    returns("L")
    strings("appName")
}

internal val miniplayerOverrideNoContextFingerprint = fingerprint {
    accessFlags(AccessFlags.PRIVATE, AccessFlags.FINAL)
    returns("Z")
    opcodes(Opcode.IGET_BOOLEAN) // Anchor to insert the instruction.
}

internal val miniplayerResponseModelSizeCheckFingerprint = fingerprint {
    accessFlags(AccessFlags.PUBLIC, AccessFlags.FINAL)
    returns("L")
    parameters("Ljava/lang/Object;", "Ljava/lang/Object;")
    opcodes(
        Opcode.RETURN_OBJECT,
        Opcode.CHECK_CAST,
        Opcode.CHECK_CAST,
        Opcode.INVOKE_STATIC,
        Opcode.MOVE_RESULT,
        Opcode.IF_NEZ,
    )
}

internal const val YOUTUBE_PLAYER_OVERLAYS_LAYOUT_CLASS_NAME =
    "Lcom/google/android/apps/youtube/app/common/player/overlay/YouTubePlayerOverlaysLayout;"

internal val playerOverlaysLayoutFingerprint = fingerprint {
    custom { method, _ ->
        method.definingClass == YOUTUBE_PLAYER_OVERLAYS_LAYOUT_CLASS_NAME
    }
}