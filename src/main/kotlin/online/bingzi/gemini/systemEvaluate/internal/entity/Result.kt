package online.bingzi.gemini.systemEvaluate.internal.entity

import java.time.LocalDateTime

/**
 * Result
 *
 * @property point 评估分数
 * @property testCount 测试项目数量
 * @property startTime 开始时间
 * @constructor Create empty Result
 */
data class Result(
    var point: Int,
    var testCount: Int,
    val startTime: LocalDateTime
)
