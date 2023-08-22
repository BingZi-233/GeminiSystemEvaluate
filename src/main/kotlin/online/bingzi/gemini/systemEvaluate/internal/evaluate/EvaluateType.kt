package online.bingzi.gemini.systemEvaluate.internal.evaluate

/**
 * Evaluate type
 * 评估操作类型
 *
 * @constructor Create empty Evaluate type
 */
enum class EvaluateType(val displayName: String) {
    /**
     * Fast evaluate
     * 快速评估
     *
     * @constructor Create empty Fast evaluate
     */
    FastEvaluate("快速评估"),

    /**
     * Evaluate
     * 完全评估
     *
     * @constructor Create empty Evaluate
     */
    AllEvaluate("完全评估")
}