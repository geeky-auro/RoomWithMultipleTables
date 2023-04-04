package com.aurosaswat.a1to1relationshiproom

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.aurosaswat.a1to1relationshiproom.entities.Director
import com.aurosaswat.a1to1relationshiproom.entities.School
import com.aurosaswat.a1to1relationshiproom.entities.Student
import com.aurosaswat.a1to1relationshiproom.entities.relation.SchoolAndDirector
import com.aurosaswat.a1to1relationshiproom.entities.relation.SchoolWithStudents

@Dao
interface SchoolDao {
//    onConflict is used so that if a room has new entry which already exist then it wont replace it instead it will add another column
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(school: School)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(director: Director)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: Student)


    //    :schoolName refers to the variable :schoolName passed ;)
//    public annotation Transaction. Marks a method in a Dao class as a transaction method. ... Room will only perform at most one transaction at a time
    @Transaction
    @Query("SELECT * FROM school WHERE schoolName=:schoolName")
    suspend fun getSchoolAndDirectorWithSchoolName(schoolName:String):List<SchoolAndDirector>


    /**
     * 1-N relationship
     * */
    @Transaction
    @Query("SELECT * FROM school WHERE schoolName=:schoolName")
    suspend fun getSchoolWithStudnets(schoolName:String):List<SchoolWithStudents>
}