package com.sohee.compose

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sohee.compose.ui.theme.ComposeTestTheme

class ComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTestTheme {
                MessageCard(Message("Android", "Jetpack Compose"))
            }
        }
    }
}

data class Message(val author: String, val body: String)

@Composable
fun MessageCard(msg: Message) {
    Row(modifier = Modifier.padding(8.dp)) {
        Image(
            painter = painterResource(id = R.drawable.ic_android_black_24dp),
            contentDescription = "contact profile picture",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.dp, MaterialTheme.colors.secondary, CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(
                text = msg.author,
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle1
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = msg.body,
                style = MaterialTheme.typography.body1
            )
        }
    }
}

@Preview(name = "Light Mode")
@Preview(
    name = "Dark Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true
)
@Composable
fun PreviewMessage() {
    ComposeTestTheme() {
        MessageCard(msg = Message("안드로이드", "제트팩"))
    }

}