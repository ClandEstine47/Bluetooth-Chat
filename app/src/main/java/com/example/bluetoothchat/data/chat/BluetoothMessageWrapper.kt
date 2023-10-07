package com.example.bluetoothchat.data.chat

import com.example.bluetoothchat.domain.chat.BluetoothMessage

fun String.toBluetoothMessage(isFromLocaluser: Boolean): BluetoothMessage {
    val name = substringBeforeLast("#")
    val message = substringAfter("#")
    return BluetoothMessage(
        message = message,
        senderName = name,
        isFromLocalUser = isFromLocaluser
    )
}

fun BluetoothMessage.toByteArray(): ByteArray {
    return "$senderName#$message".encodeToByteArray()
}