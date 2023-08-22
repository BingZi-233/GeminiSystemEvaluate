package online.bingzi.gemini.systemEvaluate.internal.entity

import online.bingzi.gemini.systemEvaluate.internal.evaluate.EvaluateType

/**
 * Request
 * 请求
 *
 * @property evaluateType 评估类型
 * @constructor Create empty Request
 */
data class Request(
    val evaluateType: EvaluateType
)
