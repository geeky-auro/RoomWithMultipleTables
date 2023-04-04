package com.aurosaswat.a1to1relationshiproom.entities.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.aurosaswat.a1to1relationshiproom.entities.Director
import com.aurosaswat.a1to1relationshiproom.entities.School

data class SchoolAndDirector(
//    @Embedded will make sure that all the fields of School are inserted to this class for room
    @Embedded val school:School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val director: Director
)
