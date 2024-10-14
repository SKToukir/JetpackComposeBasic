import com.walton.androidarchitecture.Body
import com.walton.androidarchitecture.FavoriteItem
import com.walton.androidarchitecture.FavoriteItems
import com.walton.androidarchitecture.Messge
import com.walton.androidarchitecture.R

/**
 * SampleData for Jetpack Compose Tutorial 
 */
object SampleData {
    // Sample conversation data
    val conversationSample = listOf(
        Messge(
            "Lexi",
            "Test...Test...Test..."
        ),
        Messge(
            "Lexi",
            """List of Android versions:
            |Android KitKat (API 19)
            |Android Lollipop (API 21)
            |Android Marshmallow (API 23)
            |Android Nougat (API 24)
            |Android Oreo (API 26)
            |Android Pie (API 28)
            |Android 10 (API 29)
            |Android 11 (API 30)
            |Android 12 (API 31)""".trim()
        ),
        Messge(
            "Lexi",
            """I think Kotlin is my favorite programming language.
            |It's so much fun!""".trim()
        ),
        Messge(
            "Lexi",
            "Searching for alternatives to XML layouts..."
        ),
        Messge(
            "Lexi",
            """Hey, take a look at Jetpack Compose, it's great!
            |It's the Android's modern toolkit for building native UI.
            |It simplifies and accelerates UI development on Android.
            |Less code, powerful tools, and intuitive Kotlin APIs :)""".trim()
        ),
        Messge(
            "Lexi",
            "It's available from API 21+ :)"
        ),
        Messge(
            "Lexi",
            "Writing Kotlin for UI seems so natural, Compose where have you been all my life?"
        ),
        Messge(
            "Lexi",
            "Android Studio next version's name is Arctic Fox"
        ),
        Messge(
            "Lexi",
            "Android Studio Arctic Fox tooling for Compose is top notch ^_^"
        ),
        Messge(
            "Lexi",
            "I didn't know you can now run the emulator directly from Android Studio"
        ),
        Messge(
            "Lexi",
            "Compose Previews are great to check quickly how a composable layout looks like"
        ),
        Messge(
            "Lexi",
            "Previews are also interactive after enabling the experimental setting"
        ),
        Messge(
            "Lexi",
            "Have you tried writing build.gradle with KTS?"
        ),
    )

    val bodyItemList = listOf(
        Body(R.string.app_name, R.drawable.align),
        Body(R.string.app_name, R.drawable.align),
        Body(R.string.app_name, R.drawable.align),
        Body(R.string.app_name, R.drawable.align),
        Body(R.string.app_name, R.drawable.align),
        Body(R.string.app_name, R.drawable.align),
        Body(R.string.app_name, R.drawable.align),
        Body(R.string.app_name, R.drawable.align),
        Body(R.string.app_name, R.drawable.align),
        Body(R.string.app_name, R.drawable.align)
    )

    val favoriteItems = listOf(
        FavoriteItem(R.string.app_name, R.drawable.align),
        FavoriteItem(R.string.app_name, R.drawable.align),
        FavoriteItem(R.string.app_name, R.drawable.align),
        FavoriteItem(R.string.app_name, R.drawable.align),
        FavoriteItem(R.string.app_name, R.drawable.align),
        FavoriteItem(R.string.app_name, R.drawable.align),
        FavoriteItem(R.string.app_name, R.drawable.align),
        FavoriteItem(R.string.app_name, R.drawable.align),
        FavoriteItem(R.string.app_name, R.drawable.align),
        FavoriteItem(R.string.app_name, R.drawable.align)
    )
}
