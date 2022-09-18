package com.bahaa.marvelapp.util

import android.view.View
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.bahaa.marvelapp.R
import com.bahaa.marvelapp.model.State
import com.bahaa.marvelapp.view.base.BaseRecyclerViewAdapter

@BindingAdapter("app:isLoading")
fun <T> showWhenLoading(view: View, state: State<T>?) {
    view.isVisible = state is State.OnLoading
}

@BindingAdapter("app:isSuccess")
fun <T> showWhenSuccess(view: View, state: State<T>?) {
    view.isVisible = state is State.OnSuccess
}

@BindingAdapter("app:isError")
fun <T> showWhenError(view: View, state: State<T>?) {
    view.isVisible = state is State.OnFailure
}

@BindingAdapter(value = ["app:items"])
fun <T> setRecyclerItems(view: RecyclerView, items: List<T>?) {
    if (items != null) {
        (view.adapter as BaseRecyclerViewAdapter<T>?)?.setItems(items)
    } else {
        (view.adapter as BaseRecyclerViewAdapter<T>?)?.setItems(emptyList())
    }
}

@BindingAdapter(value = ["app:showImage"])
fun setImage(view: ImageView, url: String?) {
    view.load(url) {
        placeholder(R.drawable.ic_placeholder_image)
    }
}

