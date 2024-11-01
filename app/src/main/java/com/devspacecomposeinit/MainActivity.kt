package com.devspacecomposeinit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.provider.FontsContractCompat.Columns
import com.devspacecomposeinit.ui.theme.ComposeInitTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeInitTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val marcos = Contact(
                        name = "Marcos",
                        phone = "(55) 21 965889957",
                        icon = R.drawable.sample12
                    )
                    val nicole = Contact(
                        name = "Nicole",
                        phone = "(55) 21 985689043",
                        icon = R.drawable.sample1
                    )
                    val melissa = Contact(
                        name = "Melissa",
                        phone = "(55) 21 967945876",
                        icon = R.drawable.sample3
                    )
                    val rogerio = Contact(
                        name = "Rogerio",
                        phone = "(55) 21 9808957894",
                        icon = R.drawable.sample2
                    )
                    val vivian = Contact(
                        name = "Vivian",
                        phone = "(55) 21 967438905",
                        icon = R.drawable.sample6
                    )
                    val roberta = Contact(
                        name = "Roberta",
                        phone = "(55) 21 968547890",
                        icon = R.drawable.sample16
                    )
                    val carlos = Contact(
                        name = "Carlos",
                        phone = "(55) 21 978459607",
                        icon = R.drawable.sample8
                    )
                    val shirley = Contact(
                        name = "Shirley",
                        phone = "(55) 21 968945635",
                        icon = R.drawable.sample7
                    )
                    val manuel = Contact(
                        name = "Manuel",
                        phone = "(55) 21 973690469",
                        icon = R.drawable.sample10
                    )

                    val contacts = listOf(
                        marcos,
                        nicole,
                        melissa,
                        rogerio,
                        vivian,
                        roberta,
                        carlos,
                        shirley,
                        manuel
                    )

                    LazyColumn {

                        items(contacts) { contact ->
                            ContactCard(contact = contact)
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun ContactTitle() {
        Column {

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    modifier = Modifier.padding(end = 180.dp),
                    fontSize = 40.sp,
                    text = "Contact",
                    fontWeight = FontWeight.Bold
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_list),
                    contentDescription = "List Icon"
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_grid),
                    contentDescription = "Grid Icon"
                )
            }
        }


    }

    @Composable
    fun ContactCard(contact: Contact) {
        Column(
            modifier = Modifier.padding(top = 8.dp, start = 8.dp, end = 8.dp)
        ) {
            Spacer(modifier = Modifier.size(16.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    modifier = Modifier.size(80.dp),
                    painter = painterResource(id = contact.icon),
                    contentDescription = "Contact Image"
                )
                Spacer(modifier = Modifier.size(8.dp))
                Column {
                    Text(
                        text = contact.name,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = contact.phone,
                        color = Color.DarkGray,
                        fontSize = 24.sp,
                    )
                }
            }
        }
    }

    @Composable
    fun ContactInfo(contact: Contact) {
        Column {
            ContactTitle()
            Spacer(modifier = Modifier.height(8.dp))
            ContactCard(contact = contact)
        }
    }

    data class Contact(
        val name: String,
        val phone: String,
        @DrawableRes val icon: Int
    )

    @Preview(showBackground = true)
    @Composable
    fun ContactCardPreview() {

        ComposeInitTheme {
            val contact = Contact(
                name = "Marcos",
                phone = "(55) 21 965889957",
                icon = R.drawable.sample12
            )
            ContactCard(contact = contact)
            ContactTitle()
        }
    }
}