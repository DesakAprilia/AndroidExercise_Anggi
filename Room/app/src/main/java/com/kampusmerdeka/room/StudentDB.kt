package com.kampusmerdeka.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface StudentDB {
    @Query("SELECT * FROM student_table")
    fun getAll(): List<Student>

    @Query("SELECT * FROM student_table WHERE nim LIKE :nim LIMIT 1")
    fun findByRoll(nim: Int): Student

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(student: Student)

    @Delete
    fun delete(student: Student)

    @Query("DELETE FROM student_table")
    fun deleteAll()

    @Query("UPDATE student_table SET nama_depan=:namaDepan, nama_belakang=:namaBelakang WHERE NIM LIKE :nim")
    fun update(namaDepan : String, namaBelakang : String, nim : Int)
}