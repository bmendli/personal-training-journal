package ru.ok.technopolis.training.personal.utils.thread

import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

object ThreadUtils {

    val executor = createThreadPoolExecutor()

    private val MAX_THREAD = 2 * 2.coerceAtLeast(Runtime.getRuntime().availableProcessors())

    private fun createThreadPoolExecutor(): ThreadPoolExecutor {
        val threadPoolExecutor = ThreadPoolExecutor(
                MAX_THREAD,
                MAX_THREAD,
                1,
                TimeUnit.MINUTES,
                LinkedBlockingQueue())
        threadPoolExecutor.allowCoreThreadTimeOut(true)
        return threadPoolExecutor
    }
}