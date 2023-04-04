package com.aurosaswat.a1to1relationshiproom.entities.relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.aurosaswat.a1to1relationshiproom.entities.Student
import com.aurosaswat.a1to1relationshiproom.entities.Subject

data class SubjectWithStudents(
    @Embedded val subject: Subject,
    @Relation(
        parentColumn = "subjectName",
        entityColumn = "subjectName",
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val subjects: List<Subject>
)