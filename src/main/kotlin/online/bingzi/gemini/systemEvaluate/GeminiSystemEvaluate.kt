package online.bingzi.gemini.systemEvaluate

import online.bingzi.gemini.systemEvaluate.internal.util.infoAsLang
import taboolib.common.platform.Plugin

object GeminiSystemEvaluate : Plugin() {

    /**
     * 初始化
     */
    override fun onLoad() {
        infoAsLang("Loading")
        infoAsLang("Loaded")
    }

    /**
     * 启动
     *
     */
    override fun onEnable() {
        infoAsLang("Enabling")
        infoAsLang("Enabled")
    }

    /**
     * 关闭
     *
     */
    override fun onDisable() {
        infoAsLang("Disabling")
        infoAsLang("Disabled")
    }
}