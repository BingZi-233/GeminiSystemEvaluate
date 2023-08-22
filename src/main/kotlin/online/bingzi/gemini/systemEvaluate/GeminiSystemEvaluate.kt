package online.bingzi.gemini.systemEvaluate

import taboolib.common.platform.Plugin
import taboolib.common.platform.function.console
import taboolib.module.lang.sendInfo

object GeminiSystemEvaluate : Plugin() {

    /**
     * 初始化
     */
    override fun onLoad() {
        console().sendInfo("Loading")
        console().sendInfo("Loaded")
    }

    /**
     * 启动
     *
     */
    override fun onEnable() {
        console().sendInfo("Enabling")
        console().sendInfo("Enabled")
    }

    /**
     * 关闭
     *
     */
    override fun onDisable() {
        console().sendInfo("Disabling")
        console().sendInfo("Disabled")
    }
}