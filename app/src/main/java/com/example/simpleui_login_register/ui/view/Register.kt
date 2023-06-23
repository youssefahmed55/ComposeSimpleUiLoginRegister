package com.example.simpleui_login_register.ui.view

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.simpleui_login_register.R
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp


@Preview(showBackground = true, device = "id:Nexus One")
@Composable
fun RegisterPage(navController: NavController? = null) {
    val context = LocalContext.current
    var nameVal by remember { mutableStateOf("") }
    var emailVal by remember { mutableStateOf("") }
    var phoneVal by remember { mutableStateOf("") }
    var passwordVal by remember { mutableStateOf("") }
    var confirmPasswordVal by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }
    var confirmPasswordVisibility by remember { mutableStateOf(false) }


    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.sdp), color = MaterialTheme.colorScheme.background
    ) {

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Image(
                modifier = Modifier
                    .width(250.sdp)
                    .height(170.sdp),
                painter = painterResource(id = R.drawable.register),
                contentDescription = stringResource(R.string.sign_up_image),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.size(5.sdp))

            OutlinedTextField(
                value = nameVal,
                onValueChange = { value -> if (value.length < 20) nameVal = value },
                label = {
                    Text(
                        text = stringResource(R.string.name), color = Color.Black
                    )
                },
                placeholder = {
                    Text(
                        text = stringResource(R.string.name), color = Color.Black
                    )
                },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(51.sdp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = Color.Black, textColor = Color.Black
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    capitalization = KeyboardCapitalization.Sentences,
                    imeAction = ImeAction.Next
                )
            )
            Spacer(modifier = Modifier.size(2.sdp))
            OutlinedTextField(
                value = emailVal,
                onValueChange = { value -> emailVal = value },
                label = {
                    Text(
                        text = stringResource(R.string.email_address), color = Color.Black
                    )
                },
                placeholder = {
                    Text(
                        text = stringResource(R.string.email_address), color = Color.Black
                    )
                },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(51.sdp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = Color.Black, textColor = Color.Black
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                )
            )

            Spacer(modifier = Modifier.size(2.sdp))
            OutlinedTextField(
                value = phoneVal,
                onValueChange = { value -> if (value.length < 20) phoneVal = value },
                label = {
                    Text(
                        text = stringResource(R.string.phone_number), color = Color.Black
                    )
                },
                placeholder = {
                    Text(
                        text = stringResource(R.string.phone_number), color = Color.Black
                    )
                },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(51.sdp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = Color.Black, textColor = Color.Black
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                )
            )

            Spacer(modifier = Modifier.size(2.sdp))
            OutlinedTextField(value = passwordVal,
                onValueChange = { value -> if (value.length < 20) passwordVal = value },
                label = {
                    Text(
                        text = stringResource(R.string.password), color = Color.Black
                    )
                },
                placeholder = {
                    Text(
                        text = stringResource(R.string.password), color = Color.Black
                    )
                },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(51.sdp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = Color.Black, textColor = Color.Black
                ),
                trailingIcon = {
                    IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_remove_red_eye_24),
                            contentDescription = stringResource(R.string.password_icon),
                            tint = if (passwordVisibility) Color.Gray else Color.Black
                        )
                    }
                },
                visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Next
                )
            )

            Spacer(modifier = Modifier.size(2.sdp))
            OutlinedTextField(value = confirmPasswordVal,
                onValueChange = { value -> if (value.length < 20) confirmPasswordVal = value },
                label = {
                    Text(
                        text = stringResource(R.string.confirm_password), color = Color.Black
                    )
                },
                placeholder = {
                    Text(
                        text = stringResource(R.string.confirm_password), color = Color.Black
                    )
                },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(51.sdp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = Color.Black, textColor = Color.Black
                ),
                trailingIcon = {
                    IconButton(onClick = {
                        confirmPasswordVisibility = !confirmPasswordVisibility
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_remove_red_eye_24),
                            contentDescription = stringResource(R.string.password_icon),
                            tint = if (passwordVisibility) Color.Gray else Color.Black
                        )
                    }
                },
                visualTransformation = if (confirmPasswordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                )
            )
            Spacer(modifier = Modifier.size(10.sdp))
            Button(
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.buttonColor)),
                modifier = Modifier.wrapContentSize(),
                onClick = {

                    if (nameVal.isEmpty()) Toast.makeText(
                        context,
                        context.getString(R.string.please_enter_name),
                        Toast.LENGTH_LONG
                    ).show()
                    else if (emailVal.isEmpty()) Toast.makeText(
                        context,
                        context.getString(R.string.email_address),
                        Toast.LENGTH_LONG
                    ).show()
                    else if (phoneVal.isEmpty()) Toast.makeText(
                        context,
                        context.getString(R.string.please_enter_the_phone_number),
                        Toast.LENGTH_LONG
                    ).show()
                    else if (passwordVal.isEmpty()) Toast.makeText(
                        context,
                        context.getString(R.string.password),
                        Toast.LENGTH_LONG
                    ).show()
                    else if (confirmPasswordVal.isEmpty()) Toast.makeText(
                        context,
                        context.getString(R.string.please_enter_the_confirm_password),
                        Toast.LENGTH_LONG
                    ).show()
                    else if (passwordVal != confirmPasswordVal) Toast.makeText(
                        context,
                        context.getString(R.string.the_password_does_not_match),
                        Toast.LENGTH_LONG
                    ).show()
                    else Toast.makeText(
                        context,
                        context.getString(R.string.registered_successfully),
                        Toast.LENGTH_LONG
                    ).show()

                }) {
                Text(
                    text = stringResource(R.string.sign_up),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.ssp,
                    color = Color.Black
                )
            }

            Spacer(modifier = Modifier.size(5.sdp))
            Text(
                text = stringResource(R.string.login_instead),
                fontWeight = FontWeight.Normal,
                fontSize = 10.ssp,
                color = Color.Black,
                modifier = Modifier.clickable { navController?.navigate("login_page") })


        }


    }


}