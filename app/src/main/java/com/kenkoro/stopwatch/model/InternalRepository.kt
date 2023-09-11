package com.kenkoro.stopwatch.model

import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object InternalRepository {
    private lateinit var directory: File
    private lateinit var todayFile: File

    fun configDirectory(directory: File) {
        InternalRepository.directory = directory
        createTodayFile()
    }

    private fun createTodayFile() {
        val date = getCurrentDate()
        todayFile = File(directory, "$date.txt")
    }

    private fun save(record: String) {
        FileOutputStream(todayFile, true).use { stream ->
            stream.write(("$record\n").toByteArray())
        }
    }

    fun todayRecords(): String {
        if (!isTodayFilePresent()) {
            createTodayFile()
        }

        var records = ""
        if (todayFile.exists()) {
            records = FileInputStream(todayFile).bufferedReader().use { it.readText() }
        }
        return records
    }

    private fun getCurrentDate(): String {
        val formatter = SimpleDateFormat("dd_MM_yyyy", Locale.US)
        val timeMillis = System.currentTimeMillis()
        return formatter.format(Date(timeMillis))
    }

    private fun isTodayFilePresent(): Boolean {
        return todayFile.name.equals("${getCurrentDate()}.txt")
    }

    fun saveRecord(record: String) {
        if (!isTodayFilePresent()) {
            createTodayFile()
        }
        save(record)
    }
}