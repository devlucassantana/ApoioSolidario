package dev.lucassantana.apoiosolidario

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.SnapPosition
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.*
import dev.lucassantana.apoiosolidario.ui.theme.ApoioSolidarioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ApoioSolidarioTheme {
            }
        }
    }
}

@Composable
fun InitialScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {


        //os () definem o formato e aparencia enquanto os {} definem o que tem nele
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(alignment = Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Apoio Solidário",
                fontSize = 40.sp,
                color = Color(0xFF000000),
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Conecte-se para ajudar ou receber apoio. Promova inclusão e equidade social.",
                fontSize = 20.sp,
                color = Color(0xFF000000),
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(top = 10.dp, bottom = 15.dp)
            )
            //row sao como linhas, objetos um to lado do outro
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
            ){
                Button(
                    onClick = {},
                    colors = ButtonDefaults
                        .buttonColors(
                            containerColor = Color(0xFFFFFFFF)
                        ),
                    border = BorderStroke(
                        width = 2.dp,
                        color = Color(0xFF000000)
                    ),
                    modifier = Modifier

                        .size(width = 150.dp, height = 150.dp)

                ) {
                    Text(
                        text = """Quero Ajudar""",
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF000000)
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                Button(
                    onClick = {},
                    colors = ButtonDefaults
                        .buttonColors(
                            containerColor = Color(0xFFFFFFFF)
                        ),
                    border = BorderStroke(
                        width = 2.dp,
                        color = Color(0xFF000000)
                    ),
                    modifier = Modifier
                        .size(width = 150.dp, 150.dp)
                ) {
                    Text(
                        text = """ Preciso
                            |de ajuda""".trimMargin(),
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF000000)
                    )
                }

            }
            Spacer(modifier = Modifier.height(50.dp))
            Row (){
                Button(
                    onClick = {},
                    colors = ButtonDefaults
                        .buttonColors(
                            containerColor = Color(0xFFFFFFFF)
                        ),
                    border = BorderStroke(
                        width = 2.dp,
                        color = Color(0xFF000000)
                    ),
                    modifier = Modifier
                        .size(width = 300.dp, height = 80.dp)
                ) {
                    Text(
                        text = """Entrar anonimamente""",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF000000)
                    )
                }
            }
        }
}
    }


@Composable
@Preview(showSystemUi = true, showBackground = true)
fun InitialScreenPreview(){
    ApoioSolidarioTheme{
        InitialScreen()
    }
}
