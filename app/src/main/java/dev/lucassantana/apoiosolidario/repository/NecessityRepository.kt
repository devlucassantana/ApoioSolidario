package dev.lucassantana.apoiosolidario.repository

import dev.lucassantana.apoiosolidario.R
import dev.lucassantana.apoiosolidario.model.Category
import dev.lucassantana.apoiosolidario.model.Necessity
import dev.lucassantana.apoiosolidario.model.UrgencyLevel
import dev.lucassantana.apoiosolidario.model.User
import java.time.LocalDate

fun getAllNececities() = listOf<Necessity>(
    Necessity(
        id = 1,
        category = Category(id = 600, name = "Atendimentos"),
        user = User(id = 100, name = "Joana"),
        urgencyLevel = UrgencyLevel.BAIXA,
        description = "Atendimento médico",
        createdAt = LocalDate.now(),
        image = R.drawable.atendimento
    ),
    Necessity(
        id = 2,
        category = Category(id = 700, name = "Alimentos"),
        user = User(id = 200, name = "Carlos"),
        urgencyLevel = UrgencyLevel.INTERMEDIARIA,
        description = "Alimento escasso",
        createdAt = LocalDate.now(),
        image = R.drawable.comida
    ),
    Necessity(
        id = 3,
        category = Category(id = 800, name = "Moradia"),
        user = User(id = 300, name = "Familia Souza"),
        urgencyLevel = UrgencyLevel.ALTA,
        description = "Alagamento deixou desabrigados",
        createdAt = LocalDate.now(),
        image = R.drawable.alagamento
    ),

    )
