package dev.lucassantana.apoiosolidario.screens

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.lucassantana.apoiosolidario.R
import dev.lucassantana.apoiosolidario.ui.theme.ApoioSolidarioTheme
import dev.lucassantana.apoiosolidario.ui.theme.ralewayFamily

@Composable
fun InitialScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = MaterialTheme.colorScheme.background
            )
    ) {
        //os () definem o formato e aparencia enquanto os {} definem o que tem nele
        Column(
            modifier = Modifier

                .fillMaxWidth()
                .align(alignment = Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Image(
                painter = painterResource(id = R.drawable.apoiosolidariogrey),
                contentDescription = "Logotipo do aplicativo",
                modifier = Modifier
                    .size(120.dp)
                    .align(alignment = Alignment.CenterHorizontally)
            )

            Text(
                text = stringResource(R.string.main_title),
                color = MaterialTheme.colorScheme.surface,
                style = MaterialTheme.typography.displayMedium
            )
            Text(
                text = stringResource(R.string.subtitle),
                color = MaterialTheme.colorScheme.surface,
                style = MaterialTheme.typography.titleSmall,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(top = 10.dp, bottom = 15.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = {},
                    colors = ButtonDefaults
                        .buttonColors(
                            containerColor = MaterialTheme.colorScheme.secondary
                        ),
                    border = BorderStroke(
                        width = 2.dp,
                        color = MaterialTheme.colorScheme.surface
                    ),
                    modifier = Modifier

                        .size(width = 150.dp, height = 150.dp)

                ) {
                    Text(
                        text = stringResource(R.string.login_button),
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.surface,
                        style = MaterialTheme.typography.labelSmall
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                Button(
                    onClick = {},
                    colors = ButtonDefaults
                        .buttonColors(
                            containerColor = MaterialTheme.colorScheme.tertiary
                        ),
                    border = BorderStroke(
                        width = 2.dp,
                        color = MaterialTheme.colorScheme.surface
                    ),
                    modifier = Modifier
                        .size(width = 150.dp, 150.dp)
                ) {
                    Text(
                        text = stringResource(R.string.signup_button),
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.primary,
                        style = MaterialTheme.typography.labelSmall
                    )
                }
            }
            Spacer(modifier = Modifier.height(50.dp))
            Row() {
                Button(
                    onClick = {},
                    colors = ButtonDefaults
                        .buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary
                        ),
                    border = BorderStroke(
                        width = 2.dp,
                        color = MaterialTheme.colorScheme.surface
                    ),
                    modifier = Modifier
                        .size(width = 300.dp, height = 80.dp)
                        .padding(top = 20.dp)
                ) {
                    Text(
                        text = stringResource(R.string.anonymous_button),
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.surface
                    )
                }
            }
        }
    }
}


@Composable
@Preview(
    showSystemUi = true,
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
fun InitialScreenPreview(){
    ApoioSolidarioTheme{
        InitialScreen()
    }
}
