package com.aurosaswat.a1to1relationshiproom.entities.relation

import androidx.room.Entity


/**
 *
 * For M to N relationships
 * We make a separate entity and include the primary key of both the tables..!
 *Since there should exist a jointly primary key so..!
 *
 * */

@Entity(primaryKeys = ["studentName","subjectName"])
data class StudentSubjectCrossRef(
    val studentName:String,
    val subjectName:String
)