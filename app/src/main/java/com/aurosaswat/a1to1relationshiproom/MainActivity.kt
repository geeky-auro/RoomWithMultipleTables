package com.aurosaswat.a1to1relationshiproom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aurosaswat.a1to1relationshiproom.entities.Director
import com.aurosaswat.a1to1relationshiproom.entities.School
import com.aurosaswat.a1to1relationshiproom.entities.Student
import com.aurosaswat.a1to1relationshiproom.entities.Subject
import com.aurosaswat.a1to1relationshiproom.entities.relation.StudentSubjectCrossRef
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /**
         *
         * 1-1 Relationship model
         * 1-N
         * N-M
         *
         * */

        val dao:SchoolDao=SchoolDatabase.getInstance(this).schoolDao

        val directors = listOf(
            Director("Mike Litoris", "Jake Wharton School"),
            Director("Jack Goff", "Kotlin School"),
            Director("Chris P. Chicken", "JetBrains School")
        )
        val schools = listOf(
            School("Jake Wharton School"),
            School("Kotlin School"),
            School("JetBrains School")
        )
        val subjects = listOf(
            Subject("Dating for programmers"),
            Subject("Avoiding depression"),
            Subject("Bug Fix Meditation"),
            Subject("Logcat for Newbies"),
            Subject("How to use Google")
        )
        val students = listOf(
            Student("Beff Jezos", 2, "Kotlin School"),
            Student("Mark Suckerberg", 5, "Jake Wharton School"),
            Student("Gill Bates", 8, "Kotlin School"),
            Student("Donny Jepp", 1, "Kotlin School"),
            Student("Hom Tanks", 2, "JetBrains School")
        )
        val studentSubjectRelations = listOf(
            StudentSubjectCrossRef("Beff Jezos", "Dating for programmers"),
            StudentSubjectCrossRef("Beff Jezos", "Avoiding depression"),
            StudentSubjectCrossRef("Beff Jezos", "Bug Fix Meditation"),
            StudentSubjectCrossRef("Beff Jezos", "Logcat for Newbies"),
            StudentSubjectCrossRef("Mark Suckerberg", "Dating for programmers"),
            StudentSubjectCrossRef("Gill Bates", "How to use Google"),
            StudentSubjectCrossRef("Donny Jepp", "Logcat for Newbies"),
            StudentSubjectCrossRef("Hom Tanks", "Avoiding depression"),
            StudentSubjectCrossRef("Hom Tanks", "Dating for programmers")
        )

        GlobalScope.launch {
            directors.forEach {
                dao.insertDirector(it)
            }
            schools.forEach {
                dao.insertSchool(it)
            }
            subjects.forEach {
                dao.insertSubject(it)
            }
            students.forEach {
                dao.insertStudent(it)
            }
            studentSubjectRelations.forEach {
                dao.insertStudentSubjectCrossRef(it)
            }

//            For Quering Databases ;0
            val schoolWithDirector=dao.getSchoolAndDirectorWithSchoolName("Kotlin School")
//            to Get Access to Director and School :            schoolWithDirector.first().director
            val schoolWithStudents=dao.getSchoolWithStudnets("Kotlin School")
//            schoolWithStudents.first().student
        }




    }
}