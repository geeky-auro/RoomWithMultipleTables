package com.aurosaswat.a1to1relationshiproom.entities.relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.aurosaswat.a1to1relationshiproom.entities.Student
import com.aurosaswat.a1to1relationshiproom.entities.Subject

// We need to tell room that which relation specifies this relation ;)
// associateBy tells/ defines atable where two table Student and Subject are joined ;)

data class StudentWithSubjects(
    @Embedded val Student:Student,
    @Relation(
        parentColumn = "studentName",
        entityColumn = "subjectName",
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val subjects: List<Subject>
)