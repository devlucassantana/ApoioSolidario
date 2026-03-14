package dev.lucassantana.apoiosolidario.repository

import androidx.compose.ui.graphics.Color
import dev.lucassantana.apoiosolidario.R
import dev.lucassantana.apoiosolidario.model.Category

fun getAllCategories()= listOf<Category>(
    Category(id =100,name="Aprenda Mais",image = R.drawable.aprendamais, background = Color.LightGray),
    Category(id = 200,name="Indique",image = R.drawable.indicacao, background = Color.LightGray),
    Category(id = 300,name="Oportunidades",image = R.drawable.oportunidades, background = Color.LightGray),
    Category(id = 400,name="Configurações",image = R.drawable.configuracoes, background = Color.LightGray),
    Category(id = 500,name="Recentes",image = R.drawable.doecoes, background = Color.LightGray),
    Category(id = 600,name="Matches",image = R.drawable.matches, background = Color.LightGray),

)