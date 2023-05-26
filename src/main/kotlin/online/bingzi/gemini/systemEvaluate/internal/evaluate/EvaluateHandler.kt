package online.bingzi.gemini.systemEvaluate.internal.evaluate

/**
 * Evaluate handler
 * 评估处理程序
 *
 * @constructor Create empty Evaluate handler
 */
interface EvaluateHandler {
    /**
     * Execution unit name
     * 执行单元名称
     */
    val executionUnitName: String

    /**
     * Supported types
     * 支持类型
     */
    val supportedTypes: List<EvaluateType>

    /**
     * Version
     * 版本
     */
    val executionUnitVersion: String

    /**
     * Is acceptable
     * 是否可接受
     *
     * @param type 执行类型
     * @return
     */
    fun isAcceptable(type: EvaluateType): Boolean {
        return type in supportedTypes
    }

    /**
     * Execute fast evaluate
     * 执行快速评估动作
     *
     */
    fun executeFastEvaluateAction() {
        throw NotImplementedError("执行单元 $executionUnitName 不支持 快速评估 动作")
    }

    /**
     * Execute evaluate action
     * 执行完全评估动作
     *
     */
    fun executeEvaluateAction() {
        throw NotImplementedError("执行单元 $executionUnitName 不支持 完全评估 动作")
    }
}