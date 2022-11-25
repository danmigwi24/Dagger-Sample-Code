package com.example.daggerwithcopmose.data.model

sealed class NoteOrder(val orderType: OrdetType) {
    class  Title(orderType: OrdetType):NoteOrder(orderType)
    class  Date(orderType: OrdetType):NoteOrder(orderType)
    class  Color(orderType: OrdetType):NoteOrder(orderType)

    fun copy(orderType: OrdetType):NoteOrder{
        return when(this){
            is Title->Title(orderType)
            is Date->Date(orderType)
            is Color->Color(orderType)
        }
    }

}