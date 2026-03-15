package dev.lucassantana.apoiosolidario.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import dev.lucassantana.apoiosolidario.R
import dev.lucassantana.apoiosolidario.components.CategoryItem
import dev.lucassantana.apoiosolidario.repository.getAllCategories
import dev.lucassantana.apoiosolidario.ui.theme.ApoioSolidarioTheme
import dev.lucassantana.apoiosolidario.ui.theme.ralewayFamily

@Composable
fun DonationsScreen(navController: NavController) {
    Scaffold(
        topBar = { MyTopAppBar(email = "...") },
        bottomBar = { MyBottomAppBar(navController) },
        floatingActionButton = { MyFloatingActionButtom(navController) }
    ) { padding ->
        DonationsScreenContent(modifier = Modifier.padding(padding))
    }
}

@Preview
@Composable
private fun DonationsScreenPreview() {
    ApoioSolidarioTheme() {
        DonationsScreen(navController = NavController(LocalContext.current))
    }
}
@Composable
fun DonationsScreenContent(modifier: Modifier = Modifier) {

    val mockDonations: List<String> = listOf(
        "R$ 50,00 - Família Silva (15/03/2026)",
        "R$ 30,00 - Centro Comunitário (10/03/2026)",
        "R$ 100,00 - ONG Criança Feliz (05/03/2026)"
    )

    val categories = getAllCategories()

    Column(modifier = modifier
        .fillMaxSize()
        .padding(horizontal = 0.dp)) {

        OutlinedTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 8.dp),
            label = {
                Text(
                    text = "Pesquisar doações",
                    style = MaterialTheme.typography.labelSmall
                )
            },
            shape = CircleShape,
            colors = OutlinedTextFieldDefaults
                .colors(
                    focusedBorderColor = MaterialTheme.colorScheme.tertiary,
                    unfocusedBorderColor = Color.LightGray,
                    focusedContainerColor = Color.LightGray,
                    unfocusedContainerColor = Color.Gray
                ),
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "barra de pesquisa",
                    tint = MaterialTheme.colorScheme.tertiary
                )
            }
        )

        Spacer(modifier = Modifier.height(12.dp))

        Column(modifier = Modifier
            .padding(horizontal = 10.dp)) {

            Text(
                text = "Suas Doações",
                style = MaterialTheme.typography.headlineMedium,
                fontFamily = ralewayFamily,
                color = MaterialTheme.colorScheme.onSurface,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.padding(12.dp))

            Text(
                text = "Seu impacto financeiro:",
                style = MaterialTheme.typography.headlineMedium,
                fontFamily = ralewayFamily,
                color = MaterialTheme.colorScheme.onSurface,
                fontWeight = FontWeight.Thin
            )

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.onSurface,
                    contentColor = MaterialTheme.colorScheme.primary
                ),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "Total doado: R$ --,00",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Start,
                        color = MaterialTheme.colorScheme.primary
                    )

                    Text(
                        text = "Doações realizadas: --",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.primary,
                        textAlign = TextAlign.Start
                    )

                    Text(
                        text = "Próxima meta: R$ --,00",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.primary.copy(alpha = 0.8f)
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Últimas doações:",
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.headlineMedium,
                fontFamily = ralewayFamily,
                fontWeight = FontWeight.Bold
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .padding(top = 8.dp)
            ) {
                items(mockDonations) { donation ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surfaceVariant
                        )
                    ) {
                        Text(
                            text = "Doações",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            color = MaterialTheme.colorScheme.onSurface,
                            style = MaterialTheme.typography.headlineMedium,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Sugestões para doar:",
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.headlineMedium,
                fontFamily = ralewayFamily,
                fontWeight = FontWeight.Bold
            )

            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                items(categories) { category ->
                    CategoryItem(category)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Card(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .height(116.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.mapacidade),
                    contentDescription = "Impacto das doações",
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}

@Preview
@Composable
private fun DonationsScreenContentPreview() {
    ApoioSolidarioTheme() {
        DonationsScreenContent()
    }
}