/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MySootheTheme

@Composable
fun Login(onLogin: (email: String, password: String) -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.ic_login),
            contentDescription = "Login Background",
            contentScale = ContentScale.FillBounds
        )

        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var email by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }

            Text(text = "LOG IN", style = MaterialTheme.typography.h1)

            Spacer(modifier = Modifier.requiredHeight(32.dp))

            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .requiredHeight(56.dp)
                    .padding(horizontal = 16.dp),
                value = email,
                onValueChange = {
                    email = it
                },
                placeholder = {
                    Text(text = "Email Address")
                },
                textStyle = MaterialTheme.typography.body1,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = MaterialTheme.colors.surface
                ),
                singleLine = true,
            )

            Spacer(modifier = Modifier.requiredHeight(8.dp))

            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .requiredHeight(56.dp)
                    .padding(horizontal = 16.dp),
                value = password,
                onValueChange = {
                    password = it
                },
                placeholder = {
                    Text(text = "Password")
                },
                textStyle = MaterialTheme.typography.body1,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = MaterialTheme.colors.surface
                ),
                singleLine = true
            )

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .requiredHeight(72.dp)
                    .padding(top = 8.dp)
                    .padding(horizontal = 16.dp),
                onClick = {
                    onLogin(email, password)
                }
            ) {
                Text(text = "LOG IN")
            }

            Text(
                text = "Don't have an account? Sign up",
                modifier = Modifier.paddingFromBaseline(top = 32.dp),
                style = MaterialTheme.typography.body1
            )
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LoginPreviewLight() {
    MySootheTheme {
        Login(
            onLogin = { email, password ->
            }
        )
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun LoginPreviewDark() {
    MySootheTheme(darkTheme = true) {
        Login(onLogin = { email, password -> })
    }
}
