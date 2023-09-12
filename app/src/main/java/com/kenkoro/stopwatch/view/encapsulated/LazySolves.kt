package com.kenkoro.stopwatch.view.encapsulated

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.kenkoro.stopwatch.view.locals.Paddings

@Composable
fun LazySolves(
    records: String,
    date: String,
    paddings: Paddings
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            modifier = Modifier
                .clip(RoundedCornerShape(15.dp))
                .background(MaterialTheme.colorScheme.onPrimary)
                .padding(paddings.default),
            text = date.replace("_", "."),
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Left,
            color = MaterialTheme.colorScheme.primary
        )
        val recordsOfConcreteDay =
            records.split("\n").filter { it.isNotEmpty() }
        recordsOfConcreteDay.forEach { record ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(paddings.small),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = record,
                    color = MaterialTheme.colorScheme.onPrimary
                )
                Spacer(modifier = Modifier.width(30.dp))
                Button(
                    modifier = Modifier
                        .clip(RoundedCornerShape(15.dp))
                        .border(
                            2.dp,
                            MaterialTheme.colorScheme.onPrimary,
                            RoundedCornerShape(15.dp)
                        )
                        .size(100.dp, 40.dp),
                    onClick = { /*TODO*/ }
                ) {
                    Text(
                        text = "remove",
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(5.dp))
    }
}
