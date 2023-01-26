package com.kampusmerdeka.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student_table")
data class Student(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    @ColumnInfo(name = "nama_depan") val namaDepan: String?,
    @ColumnInfo(name = "nama_belakang") val namaBelakang: String?,
    @ColumnInfo(name = "nim") val NIM: Int?
)
