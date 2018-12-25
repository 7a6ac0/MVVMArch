package me.tabacowang.mvvmarch.ui.agenda

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import me.tabacowang.mvvmarch.MainNavigationFragment
import me.tabacowang.mvvmarch.databinding.FragmentAgendaBinding
import me.tabacowang.mvvmarch.shared.util.activityViewModelProvider
import javax.inject.Inject

class AgendaFragment : DaggerFragment(), MainNavigationFragment {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: AgendaViewModel
    private lateinit var binding: FragmentAgendaBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = activityViewModelProvider(viewModelFactory)
        binding = FragmentAgendaBinding.inflate(inflater, container, false).apply {
            setLifecycleOwner(this@AgendaFragment)
            viewModel = this@AgendaFragment.viewModel
        }

        return binding.root
    }
}