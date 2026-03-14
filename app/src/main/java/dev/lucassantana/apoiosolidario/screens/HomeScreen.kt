package dev.lucassantana.apoiosolidario.screens

import android.graphics.Bitmap
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AutoAwesomeMosaic
import androidx.compose.material.icons.filled.FamilyRestroom
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import dev.lucassantana.apoiosolidario.R
import dev.lucassantana.apoiosolidario.components.CategoryItem
import dev.lucassantana.apoiosolidario.repository.RoomUserRepository
import dev.lucassantana.apoiosolidario.repository.UserRepository
import dev.lucassantana.apoiosolidario.repository.getAllCategories
import dev.lucassantana.apoiosolidario.ui.theme.ApoioSolidarioTheme
import dev.lucassantana.apoiosolidario.ui.theme.ralewayFamily
import dev.lucassantana.apoiosolidario.utils.convertByteArrayToBitmap

@Composable
fun HomeScreen(navController: NavController, email: String?) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Scaffold(
            topBar = {MyTopAppBar(email!!)},
            bottomBar = {MyBottomAppBar()},
            floatingActionButton = {MyFloatingActionButtom()},
        ){paddingValues ->
            ScreenContent(modifier = Modifier.padding(paddingValues))
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    ApoioSolidarioTheme() {
        HomeScreen(rememberNavController(), email = "")
    }

}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(email: String?) {

    val userRepository: UserRepository=
        RoomUserRepository(context= LocalContext.current)

    val user=userRepository.getUserByEmail(email)

    var profileBitmap by remember {
        mutableStateOf<Bitmap>(
            convertByteArrayToBitmap(user!!.userImage!!)
        )
    }


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
                        text= "Olá, ${user!!.name}!",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "${user!!.email}",
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
                        bitmap = profileBitmap.asImageBitmap(),
                        contentDescription = "Imagem de perfil",
                        modifier= Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
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

@Composable
fun ScreenContent(modifier: Modifier = Modifier) {

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
                    text = "Pesquisar",
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
        Spacer(modifier=Modifier.height(12.dp))
        Column(modifier = Modifier
            .padding(horizontal = 10.dp)) {
            Text(
                text = "Bem-Vindo(a) de volta!",
                style = MaterialTheme.typography.headlineMedium,
                fontFamily = ralewayFamily,
                color = MaterialTheme.colorScheme.onSurface,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier= Modifier.padding(12.dp))
            Text(
                text = "Seu impacto até agora:",
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
                        text = "Seu apoio ajudou -- famílias esse mês",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Start,
                        color = MaterialTheme.colorScheme.primary
                    )

                    Text(
                        text = "Seu progresso mensal: --% da meta de doação",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.primary,
                        textAlign = TextAlign.Start
                    )
                }
            }
            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(15.dp),
                modifier = Modifier

            ) {
                items(categories){ category ->
                    CategoryItem(category)
                }
            }
            Spacer(modifier= Modifier.padding(12.dp))
            Text(
                text="Sugestões locais:",
                color= MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.headlineMedium,
                fontFamily = ralewayFamily,
                fontWeight = FontWeight.Bold
            )
            Card(
                modifier= Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .height(116.dp)

            ) {
                Image(
                    painter = painterResource(R.drawable.mapacidade),
                    contentDescription = "Mapa cidade",
                    modifier= Modifier
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}