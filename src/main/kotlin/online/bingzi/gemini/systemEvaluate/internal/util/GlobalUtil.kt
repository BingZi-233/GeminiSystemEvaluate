package online.bingzi.gemini.systemEvaluate.internal.util

/**
 * Timer
 * 计时器
 *
 * @param callback 回调
 * @receiver
 * @return
 */
fun timer(callback: () -> Unit): Int {
    val start = System.currentTimeMillis()
    callback()
    val end = System.currentTimeMillis()
    return (end - start).toInt()
}

fun handlerAction(init: () -> Unit, action: () -> Unit, finally: () -> Unit): Int {
    return timer {
        init()
        action()
        finally()
    }
}