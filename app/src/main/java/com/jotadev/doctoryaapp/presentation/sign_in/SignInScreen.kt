package com.jotadev.doctoryaapp.presentation.sign_in

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.jotadev.doctoryaapp.R
import com.jotadev.doctoryaapp.data.model.UserDto
import com.jotadev.doctoryaapp.navigation.Home
import com.jotadev.doctoryaapp.presentation.components.AlertComponent
import com.jotadev.doctoryaapp.presentation.components.CustomButton
import com.jotadev.doctoryaapp.ui.theme.PrimaryColor

@Composable
fun SignInScreen(
    viewModel: SignInViewModel = viewModel(),
    onNavigationHome:()->Unit
) {
    val state = viewModel.state

    var email by remember{
        mutableStateOf("postman@gmail.com")
    }
    var password by remember{
        mutableStateOf("12345")
    }
    var visualTransformation by remember{
        mutableStateOf(false) //true = Visualizar, //false = No visualizar
    }
    var showDialog by remember {
        mutableStateOf(false)
    }

    val focusManager = LocalFocusManager.current

    //TOAST
    //val context = LocalContext.current
    //Toast.makeText(context,"Texto", Toast.LENGTH_LONG).show()

    if(state.error != null){
        showDialog = true
    }

    if(state.user != null){
        onNavigationHome()
    }


    if(showDialog) {
        AlertComponent(
            title = "Informativo",
            body = state.error ?: "",
            dismiss = {
                showDialog = false
                viewModel.clearError()
            }
        )
    }

    Column(modifier = Modifier.fillMaxSize()) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.doctorya_logo),
                contentDescription = "DoctorYa Logo",
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .aspectRatio(1f)
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(3f)
                .padding(horizontal = 8.dp)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                border = BorderStroke(
                    width = 1.dp,
                    color = Color.White
                )
            ) {
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)) {
                    Text(
                        text = "Login",
                        style = TextStyle(
                            color = PrimaryColor,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = email,
                        onValueChange = {
                            email = it
                        },
                        label = {
                            Text(text = "Email")
                        },
                        placeholder = {
                            Text(
                                text = "Ingrese tu correo",
                            )
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Filled.Person,
                                contentDescription = "Person Icon"
                            )
                        },
                        shape = RoundedCornerShape(8.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = PrimaryColor,
                            unfocusedBorderColor = Color.Black,
                            cursorColor = PrimaryColor
                        ),
                        isError = false,
                        textStyle = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            lineHeight = 20.sp
                        ),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Next
                        ),
                        keyboardActions = KeyboardActions(
                            onNext = {
                                focusManager.moveFocus(FocusDirection.Down)
                            }
                        )
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = password,
                        onValueChange = {
                            password = it
                        },
                        label = {
                            Text(text = "Contraseña")
                        },
                        placeholder = {
                            Text(
                                text = "Ingresa tu contraseña",
                            )
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Filled.Lock,
                                contentDescription = "Person Icon"
                            )
                        },
                        trailingIcon = {
                            IconButton(onClick = { visualTransformation = !visualTransformation }) {
                                Icon(
                                    imageVector = if(visualTransformation)
                                        Icons.Filled.Visibility
                                    else
                                        Icons.Filled.VisibilityOff,
                                    contentDescription = "VisibilityOff"
                                )
                            }
                        },
                        shape = RoundedCornerShape(8.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = PrimaryColor,
                            unfocusedBorderColor = Color.Black,
                            cursorColor = PrimaryColor
                        ),
                        isError = false,
                        textStyle = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            lineHeight = 20.sp
                        ),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Done
                        ),
                        keyboardActions = KeyboardActions(
                            onDone = {
                                focusManager.clearFocus()
                            }
                        ),
                        visualTransformation = if(visualTransformation)
                            VisualTransformation.None
                        else
                            PasswordVisualTransformation()
                    )

                    Spacer(modifier = Modifier.height(32.dp))

                    CustomButton(
                        label = "Ingresar",
                        isLoading = state.isLoading,
                        onClick = {
                            viewModel.signIn(email,password)
                        }
                    )

                    Spacer(modifier = Modifier.height(16.dp))



                    Text(
                        text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    fontWeight = FontWeight.Medium
                                )
                            ) {
                                append("¿No tienes una cuenta?. Registrate ")
                            }
                            withStyle(
                                style = SpanStyle(
                                    color = PrimaryColor,
                                    fontWeight = FontWeight.Bold,
                                    textDecoration = TextDecoration.Underline,
                                )
                            ) {
                                append("aquí")
                            }
                        }
                    )
                }

            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Green)
        ) {

        }

    }

}

/*@Preview(showSystemUi = true)
@Composable
fun PreviewSignInScreen() {
    SignInScreen()
}*/