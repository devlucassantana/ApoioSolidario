package dev.lucassantana.apoiosolidario.screens

import android.R.attr.onClick
import android.content.res.Configuration
import android.util.Patterns
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.lucassantana.apoiosolidario.R
import dev.lucassantana.apoiosolidario.ui.theme.ApoioSolidarioTheme
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddAPhoto
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.TextButton
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.ActivityNavigator
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dev.lucassantana.apoiosolidario.model.User
import dev.lucassantana.apoiosolidario.navigation.Destino
import dev.lucassantana.apoiosolidario.repository.SharedPreferencesUserRepository

@Composable
fun SignupScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                MaterialTheme.colorScheme.background
            )
    ){
        Column (
            modifier= Modifier
                .fillMaxSize()
                .align(alignment = Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            TitleSignup()
            Spacer(modifier = Modifier.height(40.dp))
            UserImage()
            SignUpUserForm(navController)
        }
    }

}

@Preview(showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun SignUpScreenPreview() {
    ApoioSolidarioTheme() {
        SignupScreen(rememberNavController())
    }
    
}

@Composable
fun TitleSignup(modifier: Modifier= Modifier){
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = stringResource(R.string.sign_up),
            color = MaterialTheme.colorScheme.onSurface,
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = stringResource(R.string.create_new_account),
            color = MaterialTheme.colorScheme.onSurface,
            style = MaterialTheme.typography.titleSmall
        )
    }
}

@Composable
fun UserImage(modifier: Modifier = Modifier) {
    Box(
        modifier= Modifier
            .size(120.dp)
    ){
        Image(
            painter = painterResource(R.drawable.usericon),
            contentDescription = stringResource(R.string.user_image),
            modifier= Modifier
                .size(110.dp)
                .align(alignment = Alignment.Center)
        )
        Icon(
            imageVector = Icons.Default.AddAPhoto,
            contentDescription = stringResource(R.string.image_icon),
            tint = MaterialTheme.colorScheme.tertiary,
            modifier = Modifier
                .align(alignment= Alignment.BottomEnd),
        )

    }
    
}

@Composable
fun SignUpUserForm(navController: NavHostController) {

    var name by remember{
        mutableStateOf("")
    }
    var email by remember{
        mutableStateOf("")
    }
    var password by remember{
        mutableStateOf("")
    }

    var isNameError by remember{
        mutableStateOf(false)
    }
    var isEmailError by remember{
        mutableStateOf(false)
    }
    var isPasswordError by remember{
        mutableStateOf(false)
    }

    var showDialogError by remember{ mutableStateOf(false) }
    var showDialogSuccess by remember{ mutableStateOf(false) }

    fun validate():Boolean{
        isNameError = name.trim().length < 3
        isNameError = email.length<3 || !Patterns.EMAIL_ADDRESS.matcher(email).matches()
        isPasswordError = password.length<6
        return !isNameError && !isEmailError && !isPasswordError
    }



    val userRepository = SharedPreferencesUserRepository(context = LocalContext.current)


    Column(
        modifier= Modifier
            .fillMaxWidth()
            .padding(32.dp)
    ) {
        OutlinedTextField(
            value = name,
            onValueChange = {
                name=it
            },
            modifier = Modifier
                .fillMaxWidth(),
            label = {
                Text(
                    text = stringResource(R.string.your_name),
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
                    imageVector = Icons.Default.Person,
                    contentDescription = stringResource(R.string.person_icon),
                    tint = MaterialTheme.colorScheme.onSurface
                )
            },
            isError = isNameError,
            trailingIcon = {
                if (isNameError){
                    Icon(
                        imageVector = Icons.Default.Error,
                        contentDescription = "Error",
                        tint= MaterialTheme.colorScheme.error
                    )
                }
            },
            supportingText = {
                if (isNameError){
                    Text(
                        text = "Nome precisa ter pelo menos 3 caracteres",
                        color = MaterialTheme.colorScheme.error,
                        textAlign = TextAlign.End
                    )
                }
            }
        )

        OutlinedTextField(
            value = email,
            onValueChange = {
                email=it
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
            },
            isError = isEmailError,
            trailingIcon = {
                if (isEmailError){
                    Icon(
                        imageVector = Icons.Default.Error,
                        contentDescription = "Error",
                        tint= MaterialTheme.colorScheme.error
                    )
                }
            },
            supportingText = {
                if (isEmailError){
                    Text(
                        text = "Email precisa ter pelo menos 3 caracteres",
                        color = MaterialTheme.colorScheme.error,
                        textAlign = TextAlign.End
                    )
                }
            }
        )

        OutlinedTextField(
            value = password,
            onValueChange = {
                password=it
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
            isError = isPasswordError,
            trailingIcon = {
                if (isPasswordError){
                    Icon(
                        imageVector = Icons.Default.Error,
                        contentDescription = "Error",
                        tint= MaterialTheme.colorScheme.error
                    )
                }
            },
            supportingText = {
                if (isPasswordError){
                    Text(
                        text = "Senha precisa ter pelo menos 3 caracteres",
                        color = MaterialTheme.colorScheme.error,
                        textAlign = TextAlign.End
                    )
                }
            }
        )
        Spacer(modifier= Modifier.height(32.dp))

        Button(
            onClick = {
                if(validate()){
                    userRepository.saveUser(
                        User(
                            name=name,
                            email=email,
                            password=password
                        )
                    )
                    showDialogSuccess = true
                }
                else{
                    showDialogError = true
                }
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
                text = stringResource(R.string.create_account),
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
        Spacer(modifier= Modifier.height(32.dp))
        Button(
            onClick = {
                navController.navigate(Destino.HomeScreen.route)
            },
            colors = ButtonDefaults
                .buttonColors(
                    containerColor = MaterialTheme.colorScheme.secondary
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
                text = stringResource(R.string.anonymous_button),
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }


    if (showDialogSuccess){
        AlertDialog(
            onDismissRequest = {showDialogError = false},
            title = {Text(text="Sucesso")},
            text = {Text(text = "Conta registrada com sucesso")},
            confirmButton = {
                TextButton(onClick={
                    navController.navigate(Destino.LoginScreen.route)
                }
                ){Text(text="Ok")}

            }
        )
    }


    if (showDialogError){
        AlertDialog(
            onDismissRequest = {showDialogError = false},
            title = {Text(text="Erro")},
            text = {Text(text = "Preencha todos os campos corretamente")},
            confirmButton = {
                TextButton(onClick={showDialogError = false}
        ){Text(text="Ok")}

            }
        )
    }
    
}