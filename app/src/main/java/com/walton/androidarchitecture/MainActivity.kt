package com.walton.androidarchitecture

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.DurationBasedAnimationSpec
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.repeatable
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.walton.androidarchitecture.ui.theme.AndroidArchitectureTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.unit.coerceAtLeast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidArchitectureTheme(darkTheme = false) {
                MyApp()
            }
        }
    }
}


@Composable
fun OnBoardingScreen(
    modifier: Modifier = Modifier,
    OnContinueClicked: () -> Unit,
    OnToastMessageShowButtonCliked: (String) -> Unit,
    onClick: () -> Unit
) {

    var valueTextField by rememberSaveable {
        mutableStateOf("")
    }

    val counterState = remember {
        mutableStateOf(CounterState(0))
    }

//    var counter by remember {
//        mutableStateOf(0)
//    }
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Counter(count = counterState.value.counter)
        IncrementButton(onClick = {
            counterState.value = counterState.value.copy(
                counterState.value.counter + 1
            )
        })

        Text(text = "Welcome to the basics Codelab")
        Button(
            onClick = OnContinueClicked
        ) {
            Text(text = "Continue")
        }

        TextField(
            value = valueTextField,
            shape = RoundedCornerShape(8.dp),
            onValueChange = {
                valueTextField = it
            },
            placeholder = {
                Text(
                    text = "Enter Name", color = Color.Gray
                )
            },
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Transparent,
            ),
            singleLine = true,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle, contentDescription = null
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            keyboardActions = KeyboardActions(onDone = {
                keyboardController?.hide()
                Log.d("TAG", "OnBoardingScreen: " + valueTextField)
            })
        )

        Button(onClick = {
            OnToastMessageShowButtonCliked
            onClick
        }) {
            Text(text = "Show Toast")
        }
    }
}


@Composable
fun Counter(count: Int) {
    Text(
        text = "$count",
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth(),
        style = TextStyle(
            color = Color.Black, fontSize = 24.sp
        )
    )
}


@Composable
fun IncrementButton(onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text(text = "Increment")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

//    var expanded by rememberSaveable {
//        mutableStateOf(false)
//    }
//
//    val extraPadding by animateDpAsState(
//        targetValue = if (expanded) 48.dp else 0.dp, animationSpec = spring(
//            dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = Spring.StiffnessLow
//        ), label = ""
//    )
//
//    val newExtraTweennPadding by animateDpAsState(
//        targetValue = if (expanded) 48.dp else 0.dp,
//        animationSpec = tween(durationMillis = 1000, delayMillis = 100)
//    )
//
//
//    Surface(
//        color = MaterialTheme.colorScheme.primary,
//        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
//    ) {
//        Row(modifier = Modifier.padding(24.dp)) {
//            Column(
//                modifier = Modifier
//                    .weight(1f)
//                    .padding(bottom = newExtraTweennPadding.coerceAtLeast(0.dp))
//            ) {
//                Text(
//                    text = "Hello", modifier, style = MaterialTheme.typography.titleSmall.copy(
//                        fontWeight = FontWeight.Light
//                    )
//                )
//                Text(
//                    text = if (!expanded) name else name.repeat(4),
//                    modifier,
//                    style = MaterialTheme.typography.titleMedium.copy(
//                        fontWeight = FontWeight.Bold
//                    )
//                )
//            }
//            IconButton(onClick = {
//                expanded = !expanded
//            }) {
//                Icon(
//                    imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
//                    contentDescription = if (expanded) stringResource(id = R.string.show_less)
//                    else stringResource(
//                        id = R.string.show_more
//                    )
//                )
//            }
//        }
//    }

    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ), modifier = Modifier.padding(vertical = 8.dp, horizontal = 8.dp)
    ) {
        CardContent(name = name)
    }
}

@Composable
fun CardContent(name: String) {
    var expanded by rememberSaveable {
        mutableStateOf(false)
    }

    Row(
        modifier = Modifier
            .padding(12.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(12.dp)
        ) {
            Text(
                text = name, style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.Bold
                )
            )
            Text(
                text = if (!expanded) name else "This is text of example" + "\n" + "This is second line example".repeat(4),
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.Light
                )
            )
        }
        IconButton(onClick = { expanded = !expanded }) {
            Icon(
                imageVector = if (!expanded) Icons.Default.ExpandMore else Icons.Default.ExpandLess,
                contentDescription = if (!expanded) stringResource(id = R.string.show_more)
                else stringResource(
                    id = R.string.show_less
                )
            )
        }
    }
}

@Composable
fun MyApp(modifier: Modifier = Modifier) {

    var count by remember {
        mutableStateOf(0)
    }

    val context = LocalContext.current

    var shouldShowOnBoarding by rememberSaveable {
        mutableStateOf(true)
    }

    Surface(
        modifier = modifier, color = MaterialTheme.colorScheme.background
    ) {
        if (shouldShowOnBoarding) {
            OnBoardingScreen(OnContinueClicked = {
                shouldShowOnBoarding = false
            }, OnToastMessageShowButtonCliked = {
                Toast.makeText(context, "Hello", Toast.LENGTH_LONG).show()
            }, onClick = {
                count
            })
        } else {
            Greetings()
        }
    }
}


@Composable
fun Greetings(modifier: Modifier = Modifier, names: List<String> = List(1000) { "$it" }) {
    LazyColumn(modifier = modifier.padding(vertical = 8.dp)) {
        items(items = names) { name ->
            Greeting(name = name)
        }
    }
}

@Preview(device = Devices.PIXEL_4_XL, showBackground = true)
@Composable
fun PreviewMainApp() {
    AndroidArchitectureTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column {
//                MyApp()
//
//                OnBoardingScreen(OnContinueClicked = {
//
//                }, OnToastMessageShowButtonCliked = {
//
//                }, onClick = {
//
//                })
                Greeting(name = "Hello")
            }
        }
    }
}
