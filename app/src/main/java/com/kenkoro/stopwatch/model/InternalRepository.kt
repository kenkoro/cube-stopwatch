package com.kenkoro.stopwatch.model

import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object InternalRepository {
    private lateinit var directory: File
    private lateinit var currentFile: File

    fun configDirectory(directory: File) {
        InternalRepository.directory = directory
        createTodayFile()
    }

    private fun createTodayFile() {
        val date = getCurrentDate()
        currentFile = File(directory, "$date.txt")
    }

    private fun save(record: String) {
        FileOutputStream(currentFile, true).use { stream ->
            stream.write(("$record\n").toByteArray())
        }
    }

    fun allRecords(): List<String> {
        if (!isTodayFilePresent()) {
            createTodayFile()
        }

        val listOfRecords = mutableListOf<String>()
        File(directory.path).walk().forEach { file ->
            var records = ""
            if (file.exists() && file.isFile) {
                records = FileInputStream(file).bufferedReader().use { it.readText() }
            }
            listOfRecords.add(records)
        }

        return listOfRecords.filter { it.isNotEmpty() }
    }

    fun allDates(): List<String> {
        if (!isTodayFilePresent()) {
            createTodayFile()
        }

        val dates = mutableListOf<String>()
        File(directory.path).walk().forEach {
            dates.add(
                it.path
                    .replace("${directory.toString()}/", "")
                    .replace(".txt", "")
            )
        }

        return dates.filter { it.isNotEmpty() }.sortedDescending()
    }

    private fun getCurrentDate(): String {
        val formatter = SimpleDateFormat("dd_MM_yyyy", Locale.US)
        val timeMillis = System.currentTimeMillis()
        return formatter.format(Date(timeMillis))
    }

    private fun isTodayFilePresent(): Boolean {
        return currentFile.name.equals("${getCurrentDate()}.txt")
    }

    fun saveRecord(record: String) {
        if (!isTodayFilePresent()) {
            createTodayFile()
        }
        save(record)
    }
}