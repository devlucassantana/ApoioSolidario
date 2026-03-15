package dev.lucassantana.apoiosolidario.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dev.lucassantana.apoiosolidario.R
import dev.lucassantana.apoiosolidario.navigation.Destino
import dev.lucassantana.apoiosolidario.repository.RoomUserRepository
import dev.lucassantana.apoiosolidario.repository.SharedPreferencesUserRepository
import dev.lucassantana.apoiosolidario.repository.UserRepository
import dev.lucassantana.apoiosolidario.ui.theme.ApoioSolidarioTheme

@Composable
fun LoginScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                MaterialTheme.colorScheme.background
            )
    ){
        Column (
            modifier= Modifier
                .padding(32.dp)
                .fillMaxSize()
                .fillMaxWidth()
                .align(alignment = Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            TitleLogin()
            LoginUserForm(navController)


        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    ApoioSolidarioTheme() {
        LoginScreen(rememberNavController())
    }

}

@Composable
fun TitleLogin(modifier: Modifier= Modifier){
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = stringResource(R.string.login),
            color = MaterialTheme.colorScheme.onSurface,
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = stringResource(R.string.login_caption),
            color = MaterialTheme.colorScheme.onSurface,
            style = MaterialTheme.typography.titleSmall
        )
    }
}

@Composable
fun LoginUserForm(navController: NavController) {

    var email by remember{
        mutableStateOf("")
    }
    var password by remember{
        mutableStateOf("")
    }
    var authenticateError by remember{
        mutableStateOf(false)
    }
    var showPassword by remember{
        mutableStateOf(false)
    }

    val userRepository : UserRepository =
        RoomUserRepository(context = LocalContext.current)

    Column(
        modifier= Modifier
            .fillMaxWidth()
            .padding(32.dp)
    ) {
        OutlinedTextField(
            value = email,
            onValueChange = {emailValue ->
                email = emailValue
            },
            modifier = Modifier
                .fillMaxWidth(),
            label = {
                Text(
                    text = stringResource(R.string.your_email),
                    style = MaterialTheme.typography.labelSmall
                )
            },
            shape = CircleShape,
            colors = OutlinedTextFieldDefaults
                .colors(
                    focusedBorderColor = MaterialTheme.colorScheme.secondary,
                    unfocusedBorderColor = MaterialTheme.colorScheme.onSurface
                ),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Mail,
                    contentDescription = stringResource(R.string.mail_icon),
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }
        )

        OutlinedTextField(
            value = password,
            onValueChange = {passwordValue->
                password = passwordValue
            },
            modifier = Modifier
                .fillMaxWidth(),
            label = {
                Text(
                    text = stringResource(R.string.password),
                    style = MaterialTheme.typography.labelSmall
                )
            },
            shape = CircleShape,
            colors = OutlinedTextFieldDefaults
                .colors(
                    focusedBorderColor = MaterialTheme.colorScheme.secondary,
                    unfocusedBorderColor = MaterialTheme.colorScheme.onSurface
                ),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = stringResource(R.string.pass_icon),
                    tint = MaterialTheme.colorScheme.onSurface
                )
            },
            trailingIcon = {
                val image = if(showPassword){
                    Icons.Default.Visibility
                }else{
                    Icons.Default.VisibilityOff
                }
                IconButton(
                    onClick = {showPassword = !showPassword}
                ){
                    Icon(
                        imageVector = image,
                        contentDescription = "",
                        tint = MaterialTheme.colorScheme.tertiary
                    )
                }
            },
            visualTransformation = if(showPassword){
                VisualTransformation.None
            }else{
                PasswordVisualTransformation()
            }
        )
        Spacer(modifier= Modifier.height(32.dp))

        Button(
            onClick = {
                val authenticate=userRepository.login(email, password)
                if(authenticate){
                    authenticateError=false
                }else{
                    authenticateError=true
                }
                navController.navigate(Destino.HomeScreen
                    .createRoute(email))
            },
            colors = ButtonDefaults
                .buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
            border = BorderStroke(
                width = 2.dp,
                color = MaterialTheme.colorScheme.onSurface
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Text(
                text = stringResource(R.string.login_button_screen),
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        if (authenticateError){
            Row {
                Icon(
                    imageVector = Icons.Default.Error,
                    contentDescription = "Error",
                    tint = MaterialTheme.colorScheme.error
                )
                Spacer(Modifier.width(8.dp))
                Text(
                    text= "Authentication Error",
                    color = MaterialTheme.colorScheme.error,
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Row (modifier=Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            Text(
                text = stringResource(R.string.account_confirmation),
                color = MaterialTheme.colorScheme.tertiary,
                style = MaterialTheme.typography.bodyMedium
            )
            TextButton(
                onClick = {
                    navController.navigate(Destino.SignupScreen.route)
                }
            ) {
                Text(
                    text= stringResource(R.string.sign_up),
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}