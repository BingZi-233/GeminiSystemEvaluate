package online.bingzi.gemini.systemEvaluate.internal.util

import java.io.*
import java.util.concurrent.Executors
import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream

class ZipCompressor(private val srcFile: File, private val destFile: File) {
    private val BUFFER_SIZE = 2 * 1024
    private val executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors())

    fun compress() {
        ZipOutputStream(BufferedOutputStream(FileOutputStream(destFile))).use { zos ->
            compress(srcFile, zos, "")
        }
        executor.shutdown()
    }

    private fun compress(srcFile: File, zos: ZipOutputStream, basePath: String) {
        if (srcFile.isDirectory) {
            val files = srcFile.listFiles()
            if (files.isNullOrEmpty()) {
                zos.putNextEntry(ZipEntry("$basePath/"))
                zos.closeEntry()
            } else {
                for (file in files) {
                    executor.execute { compress(file, zos, "$basePath/${srcFile.name}") }
                }
            }
        } else {
            BufferedInputStream(FileInputStream(srcFile)).use { bis ->
                synchronized(zos) {
                    zos.putNextEntry(ZipEntry(basePath))
                    val buffer = ByteArray(BUFFER_SIZE)
                    var count = bis.read(buffer)
                    while (count != -1) {
                        zos.write(buffer, 0, count)
                        count = bis.read(buffer)
                    }
                    zos.closeEntry()
                }
            }
        }
    }
}
