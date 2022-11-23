package com.kaajjo.libresudoku.ui.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun SelectionDialog(
    title: String,
    selections: List<String>,
    selected: Int = 0,
    onSelect: (Int) -> Unit,
    onDismiss: () -> Unit
) {
    Dialog(onDismissRequest = onDismiss) {
        Surface(
            shape = RoundedCornerShape(28.dp),
            color = MaterialTheme.colorScheme.surface
        ) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.padding(start = 24.dp, end = 24.dp, top = 24.dp)
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        selections.forEachIndexed { index, text ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        onSelect(index)
                                        onDismiss()
                                    }
                                    .padding(start = 12.dp, end = 12.dp)
                                ,
                                verticalAlignment = CenterVertically
                            ) {
                                RadioButton(
                                    selected = selected == index,
                                    onClick = {
                                        onSelect(index)
                                        onDismiss()
                                    }
                                )
                                Text(text)
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 24.dp, end = 24.dp, bottom = 24.dp),
                        horizontalAlignment = Alignment.End,

                        ) {
                        TextButton(onClick = onDismiss) {
                            Text("Отмена")
                        }
                    }
                }
            }
        }
    }
}