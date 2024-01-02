package com.enes.common.presentation.utils

import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

fun <T : ViewBinding> Fragment.fragmentViewBinding(viewBinder: (View) -> T): FragmentViewBindingProperty<T> =
    FragmentViewBindingProperty(viewBinder)

open class ViewBindingProperty<T : ViewBinding> : DefaultLifecycleObserver {
    protected var binding: T? = null
    protected var lifecycle: Lifecycle? = null

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        lifecycle?.removeObserver(this)
        lifecycle = null
        binding = null
    }
}

class FragmentViewBindingProperty<T : ViewBinding>(private val viewBinder: (View) -> T) :
    ViewBindingProperty<T>(), ReadOnlyProperty<Fragment, T> {

    override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
        return binding ?: run {
            thisRef.viewLifecycleOwnerLiveData.observe(thisRef) { lifeCyclerOwner ->
                lifeCyclerOwner.lifecycle.let {
                    it.addObserver(this)
                    lifecycle = it
                    /*binding?.let { bind ->
                        if (bind is ViewDataBinding){
                            (bind as ViewDataBinding).lifecycleOwner = thisRef.viewLifecycleOwner
                        }
                    }*/
                }
            }
            viewBinder.invoke(thisRef.requireView()).also {
                binding = it
            }
        }
    }

}