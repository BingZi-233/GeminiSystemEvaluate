package online.bingzi.gemini.systemEvaluate.internal.evaluate.handle

import online.bingzi.gemini.systemEvaluate.internal.evaluate.EvaluateHandler
import online.bingzi.gemini.systemEvaluate.internal.evaluate.EvaluateType
import online.bingzi.gemini.systemEvaluate.internal.util.ZipCompressor
import online.bingzi.gemini.systemEvaluate.internal.util.handlerAction
import taboolib.common.platform.function.console
import taboolib.module.lang.sendInfo
import taboolib.platform.util.bukkitPlugin
import java.io.File
import java.util.*

/**
 * Disk spark handler
 * 磁盘火花处理器
 *
 * @constructor Create empty Disk spark handler
 */
class DiskSparkHandler : EvaluateHandler {
    override val executionUnitName: String
        get() = "DiskSparkHandler"
    override val supportedTypes: List<EvaluateType>
        get() = listOf(EvaluateType.FastEvaluate, EvaluateType.AllEvaluate)
    override val executionUnitVersion: String
        get() = "1.0.0"
    override var nextNode: EvaluateHandler? = null
    override val weight: Int
        get() = 1

    override fun setNextNode(evaluateHandler: EvaluateHandler) {
        nextNode = evaluateHandler
    }

    private val baseUrl = bukkitPlugin.dataFolder.absolutePath + File.pathSeparator + "diskSpark"

    override fun executeFastEvaluateAction() {
        handlerAction({ initializeTheEnvironment() }, { multithreadedCompression() }, { clearVestige() })
    }

    override fun executeEvaluateAction() {
        handlerAction({ initializeTheEnvironment(200) }, { multithreadedCompression() }, { clearVestige() })
    }


    /**
     * Initialize the environment
     * 初始化环境
     *
     */
    private fun initializeTheEnvironment(max: Int = 50) {
        val diskSpark = File(baseUrl)
        if (!diskSpark.exists()) {
            diskSpark.mkdirs()
        }
        val random: Random = Random()
        for (i in 1..max) {
            val file = File("${baseUrl}${File.pathSeparator}file_${i}.txt")
            if (file.exists()) {
                file.delete()
            }
            file.createNewFile()
            val writer = file.bufferedWriter()

            for (j in 1..10_000_000) {
                val char = (random.nextInt(26) + 'a'.code)
                writer.write(char)
            }
            writer.close()
        }
        console().sendInfo("NodeInitializeInfo", executionUnitName, executionUnitVersion)
    }

    /**
     * Clear vestige
     * 清理产生的痕迹
     *
     */
    private fun clearVestige() {
        File(baseUrl).deleteRecursively()
        console().sendInfo("NodeClearVestigeInfo", executionUnitName, executionUnitVersion)
    }

    /**
     * Multithreaded compression
     * 多线程压缩
     *
     */
    private fun multithreadedCompression() {
        ZipCompressor(File(baseUrl), File("${baseUrl + File.pathSeparator}test.zip")).compress()
    }
}