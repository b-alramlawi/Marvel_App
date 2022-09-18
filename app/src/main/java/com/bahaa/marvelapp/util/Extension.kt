package com.bahaa.marvelapp.util

import android.content.Context
import android.widget.Toast
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import java.math.BigInteger
import java.security.MessageDigest

fun String.md5(): String {
    val messageDigest = MessageDigest.getInstance("md5")
    return BigInteger(1, messageDigest.digest(toByteArray())).toString(16).padStart(32, '0')
}


fun Disposable.addTo(compositeDisposable: CompositeDisposable) {
    compositeDisposable.add(this)
}

fun Context.showToast(message: String) {
    Toast.makeText(this.applicationContext, message, Toast.LENGTH_SHORT).show()
}
