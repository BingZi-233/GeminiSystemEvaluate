package online.bingzi.gemini.systemEvaluate.internal.evaluate

import online.bingzi.gemini.systemEvaluate.internal.entity.Request
import taboolib.common.platform.function.console
import taboolib.module.lang.sendInfo

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
     * Next node
     * 下一个处理器节点
     */
    var nextNode: EvaluateHandler?

    /**
     * Weight
     * 权重
     */
    val weight: Int

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
     * Handle
     * 处理
     *
     * @param request
     */
    fun handle(request: Request) {
        console().sendInfo(
            "NodeStartInfo",
            executionUnitVersion,
            executionUnitName,
            if (isAcceptable(request.evaluateType)) "接受" else "拒绝"
        )
        // 当前链是否能够处理
        if (isAcceptable(request.evaluateType)) {
            when (request.evaluateType) {
                EvaluateType.FastEvaluate -> executeFastEvaluateAction()
                EvaluateType.AllEvaluate -> executeEvaluateAction()
            }
        }
        nextNode?.handle(request)
    }

    /**
     * Set next node
     * 设置下一个处理器节点
     *
     * @param evaluateHandler
     */
    fun setNextHandlerNode(evaluateHandler: EvaluateHandler)

    /**
     * Execute fast evaluate
     * 执行快速评估动作
     *
     */
    fun executeFastEvaluateAction() {
        throw NotImplementedError("执行单元 $executionUnitName 不支持 ${EvaluateType.FastEvaluate.displayName} 动作")
    }

    /**
     * Execute evaluate action
     * 执行完全评估动作
     *
     */
    fun executeEvaluateAction() {
        throw NotImplementedError("执行单元 $executionUnitName 不支持 ${EvaluateType.AllEvaluate.displayName} 动作")
    }
}