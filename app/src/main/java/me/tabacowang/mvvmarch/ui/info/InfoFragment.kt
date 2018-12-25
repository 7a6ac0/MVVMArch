package me.tabacowang.mvvmarch.ui.info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment
import me.tabacowang.mvvmarch.MainNavigationFragment
import me.tabacowang.mvvmarch.databinding.FragmentInfoBinding

class InfoFragment : DaggerFragment(), MainNavigationFragment {

    private lateinit var binding: FragmentInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInfoBinding.inflate(inflater, container, false).apply {
            setLifecycleOwner(this@InfoFragment)
        }
        return binding.root
    }
}