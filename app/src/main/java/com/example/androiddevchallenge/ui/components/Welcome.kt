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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MySootheTheme

@Composable
fun Welcome(onSignUp: () -> Unit = {}, onLogIn: () -> Unit = {}) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.ic_welcome),
            contentDescription = "Login Background",
            contentScale = ContentScale.FillBounds
        )

        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val buttonHeight = 72.dp
            val padding = 16.dp

            Image(
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = "Logo Image"
            )

            Button(
                onClick = onSignUp,
                modifier = Modifier
                    .padding(top = padding * 2)
                    .requiredHeight(buttonHeight)
                    .fillMaxWidth()
                    .padding(horizontal = padding),
                shape = RoundedCornerShape(16.dp),

                ) {
                Text(text = "SIGN UP")
            }

            Button(
                onClick = onLogIn,
                modifier = Modifier
                    .padding(top = 8.dp)
                    .requiredHeight(buttonHeight)
                    .fillMaxWidth()
                    .padding(horizontal = padding),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.secondary
                )
            ) {
                Text(text = "LOG IN")
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun WelcomePreviewLight() {
    MySootheTheme {
        Welcome()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun WelcomePreviewDark() {
    MySootheTheme(darkTheme = true) {
        Welcome()
    }
}
