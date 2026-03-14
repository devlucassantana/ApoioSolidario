package dev.lucassantana.apoiosolidario.model

import androidx.annotation.DrawableRes
import java.time.LocalDate

data class Necessity(
    val id:Int=0,
    val category: Category,
    val user: User,
    val urgencyLevel: UrgencyLevel,
    val description: String,
    val createdAt: LocalDate=LocalDate.now(),
    @DrawableRes val image: Int

)
