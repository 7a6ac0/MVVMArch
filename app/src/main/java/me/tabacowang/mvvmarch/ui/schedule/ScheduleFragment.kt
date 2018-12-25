package me.tabacowang.mvvmarch.ui.schedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import me.tabacowang.mvvmarch.MainNavigationFragment
import me.tabacowang.mvvmarch.databinding.FragmentScheduleBinding
import me.tabacowang.mvvmarch.shared.result.EventObserver
import me.tabacowang.mvvmarch.shared.util.activityViewModelProvider
import me.tabacowang.mvvmarch.ui.scheduledetail.ScheduleDetailActivity
import javax.inject.Inject

class ScheduleFragment : DaggerFragment(), MainNavigationFragment {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var scheduleViewModel: ScheduleViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        scheduleViewModel = activityViewModelProvider(viewModelFactory)
        val binding = FragmentScheduleBinding.inflate(inflater, container, false).apply {
            setLifecycleOwner(this@ScheduleFragment)
            viewModel = this@ScheduleFragment.scheduleViewModel
            // For Test
            id = "Test ID"
        }

        scheduleViewModel.navigateToScheduleDetail.observe(this, EventObserver { id ->
            openScheduleDetail(id)
        })

        return binding.root
    }

    private fun openScheduleDetail(id: String) {
        startActivity(ScheduleDetailActivity.starterIntent(requireContext(), id))
    }
}