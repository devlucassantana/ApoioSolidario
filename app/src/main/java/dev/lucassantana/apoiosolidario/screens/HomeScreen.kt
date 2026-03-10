package dev.lucassantana.apoiosolidario.screens

import android.content.res.Configuration
import android.icu.text.CaseMap
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AutoAwesomeMosaic
import androidx.compose.material.icons.filled.FamilyRestroom
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.lucassantana.apoiosolidario.R
import dev.lucassantana.apoiosolidario.ui.theme.ApoioSolidarioTheme
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Scaffold(
            topBar = {MyTopAppBar()},
            bottomBar = {MyBottomAppBar()},
            floatingActionButton = {MyFloatingActionButtom()},
        ){paddingValues ->
            Column(
                modifier= Modifier
                    .padding(paddingValues)
            ) { }
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    ApoioSolidarioTheme() {
        HomeScreen()
    }

}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(modifier: Modifier = Modifier) {
    TopAppBar(
        modifier = Modifier
            .background(
                color = MaterialTheme.colorScheme.primary
            )
            .fillMaxWidth(),
            //.height(80.dp),
        title = {
            Row (
                modifier= Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Column {
                    Text(
                        text= "Olá, Usuário!",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "usuario@email.com",
                        style = MaterialTheme.typography.displaySmall,
                        color= MaterialTheme.colorScheme.primary
                    )
                }
                Card(
                    modifier= Modifier.size(size = 33.dp),
                    shape= CircleShape,
                    colors = CardDefaults
                        .cardColors(
                            containerColor = Color.Transparent
                        ),
                    border = BorderStroke(
                        width = 2.dp,
                        color = MaterialTheme.colorScheme.primary
                    )
                ) {
                    Image(
                        painter = painterResource(R.drawable.usericon),
                        contentDescription = "icone do usuario",
                        modifier = Modifier
                    )
                }
            }
        }
    )
}

data class BottomNavigation(
    val title: String,
    val icon: ImageVector
)

@Composable
fun MyBottomAppBar(modifier: Modifier = Modifier) {
    val itens = listOf(
        BottomNavigation("Home", icon = Icons.Default.Home),
        BottomNavigation("Family", icon = Icons.Default.FamilyRestroom),
        BottomNavigation("Profile", icon = Icons.Default.Person),
        BottomNavigation("Donations", icon = Icons.Default.AutoAwesomeMosaic)
    )
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.tertiary
    ) {
        itens.forEach{ item ->
            NavigationBarItem(
                selected = false,
                onClick = {},
                icon={
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier=Modifier.size(24.dp)
                    )
                },
                label={
                    Text(
                        text=item.title,
                        style = MaterialTheme.typography.displaySmall,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            )
        }
    }
}

@Composable
fun MyFloatingActionButtom(modifier: Modifier = Modifier) {
    FloatingActionButton(
        onClick = {},
        shape = CircleShape,
        containerColor = MaterialTheme.colorScheme.tertiary,
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Botão Adicionar"
        )
    }
    
}
