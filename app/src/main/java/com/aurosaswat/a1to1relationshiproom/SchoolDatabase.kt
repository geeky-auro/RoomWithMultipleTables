package com.aurosaswat.a1to1relationshiproom

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.aurosaswat.a1to1relationshiproom.entities.Director
import com.aurosaswat.a1to1relationshiproom.entities.School
import com.aurosaswat.a1to1relationshiproom.entities.Student
import com.aurosaswat.a1to1relationshiproom.entities.Subject
import com.aurosaswat.a1to1relationshiproom.entities.relation.StudentSubjectCrossRef

@Database(
    entities = [
        School::class,
        Student::class,
        Director::class,
        Subject::class,
        StudentSubjectCrossRef::class
    ], version = 1
)

abstract class SchoolDatabase:RoomDatabase() {

    abstract  val schoolDao:SchoolDao

    companion object{
//        Volatile indicates that whenever there takes place any changes to this INSTANCE object immediately
//        it indicates to this all the threads using this instance ;)
        @Volatile
        private var INSTANCE:SchoolDatabase?=null

        fun getInstance(context:Context):SchoolDatabase{
            synchronized(this){
                return INSTANCE?: Room.databaseBuilder(
                    context.applicationContext,
                    SchoolDatabase::class.java,
                    "school_db"
                ).build().also{
                    INSTANCE=it
                }
            }
        }
    }


}