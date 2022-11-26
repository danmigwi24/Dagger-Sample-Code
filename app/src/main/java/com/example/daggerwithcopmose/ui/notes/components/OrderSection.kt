package com.example.daggerwithcopmose.ui.notes.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.RadioButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.daggerwithcopmose.data.model.NoteOrder
import com.example.daggerwithcopmose.data.model.OrdetType

@Composable
fun OrderSection(
    modifier: Modifier = Modifier,
    noteOrder: NoteOrder = NoteOrder.Date(OrdetType.Descending),
    onOrderChange: (NoteOrder) -> Unit
) {
    Column(modifier = modifier) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            DefaultRadioButton(
                text = "Title",
                selected = noteOrder is NoteOrder.Title,
                onSelected = {
                    onOrderChange(NoteOrder.Title(noteOrder.orderType))
                }
            )

            DefaultRadioButton(
                text = "Date",
                selected = noteOrder is NoteOrder.Title,
                onSelected = {
                    onOrderChange(NoteOrder.Date(noteOrder.orderType))
                }
            )
            DefaultRadioButton(
                text = "Color",
                selected = noteOrder is NoteOrder.Title,
                onSelected = {
                    onOrderChange(NoteOrder.Color(noteOrder.orderType))
                }
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(
                text = "Ascending",
                selected = noteOrder.orderType is OrdetType.Ascending,
                onSelected = {
                    onOrderChange(noteOrder.copy(OrdetType.Ascending))
                }
            )

            DefaultRadioButton(
                text = "Descending",
                selected = noteOrder.orderType is OrdetType.Ascending,
                onSelected = {
                    onOrderChange(noteOrder.copy(OrdetType.Descending))
                }
            )
        }
    }
}