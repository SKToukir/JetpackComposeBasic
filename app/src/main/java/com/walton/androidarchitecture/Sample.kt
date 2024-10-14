//package com.walton.androidarchitecture
//
//import SampleData
//import android.content.res.Configuration
//import android.os.Bundle
//import android.os.Message
//import android.widget.Space
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.activity.enableEdgeToEdge
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.border
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.layout.statusBarsPadding
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.LazyRow
//import androidx.compose.foundation.lazy.items
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Surface
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.draw.shadow
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.RectangleShape
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.TextStyle
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.lerp
//import com.walton.androidarchitecture.ui.theme.AndroidArchitectureTheme
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            AndroidArchitectureTheme {
//                Surface(
//                    color = MaterialTheme.colorScheme.onBackground,
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .statusBarsPadding()
//                ) {
//                    Conversation(messages = SampleData.conversationSample)
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun MessageCard(msg: Messge) {
//    Row(modifier = Modifier.padding(all = 8.dp)) {
//        Image(
//            painter = painterResource(id = R.drawable.ic_launcher_background),
//            contentDescription = "Test Image",
//            modifier = Modifier
//                .clip(CircleShape)
//                .size(50.dp)
//                .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
//        )
//        Spacer(modifier = Modifier.width(5.dp))
//        Column {
//            Text(
//                text = msg.author,
//                color = MaterialTheme.colorScheme.secondary,
//                style = MaterialTheme.typography.titleSmall
//            )
//            Spacer(
//                modifier = Modifier
//                    .width(5.dp)
//                    .height(5.dp)
//            )
//            Surface(shape = MaterialTheme.shapes.medium, shadowElevation = 4.dp) {
//
//                Text(
//                    text = msg.body,
//                    modifier = Modifier
//                        .padding(all = 4.dp)
//                        .width(200.dp)
//                        .height(100.dp)
//                        .padding(all = 8.dp),
//                    style = MaterialTheme.typography.bodyMedium
//                )
//            }
//        }
//    }
//}
//
//@Composable
//fun Conversation(messages: List<Messge>) {
//    LazyColumn {
//        items(messages) { message ->
//            MessageCard(msg = message)
//        }
//    }
//}
//
//@Preview
//@Composable
//fun PreviewConversation() {
//    AndroidArchitectureTheme {
//        Surface {
//            Box(modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)) {
//                Conversation(messages = SampleData.conversationSample)
//            }
//        }
//    }
//}
//
//
