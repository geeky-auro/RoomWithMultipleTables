package com.aurosaswat.a1to1relationshiproom.entities.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.aurosaswat.a1to1relationshiproom.entities.School
import com.aurosaswat.a1to1relationshiproom.entities.Student

data class SchoolWithStudents (
    @Embedded val school:School,
    @Relation(
    parentColumn = "schoolName",
    entityColumn = "schoolName"
    )
    val student:List<Student>
)