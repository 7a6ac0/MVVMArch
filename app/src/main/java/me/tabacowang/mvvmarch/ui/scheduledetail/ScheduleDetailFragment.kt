package me.tabacowang.mvvmarch.ui.scheduledetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.NavUtils
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import me.tabacowang.mvvmarch.databinding.FragmentScheduleDetailBinding
import me.tabacowang.mvvmarch.shared.util.viewModelProvider
import javax.inject.Inject

class ScheduleDetailFragment : DaggerFragment() {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var scheduleDetailViewModel: ScheduleDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        scheduleDetailViewModel = viewModelProvider(viewModelFactory)

        val binding = FragmentScheduleDetailBinding.inflate(inflater, container, false).apply {
            viewModel = scheduleDetailViewModel
            setLifecycleOwner(this@ScheduleDetailFragment)
            up.setOnClickListener {
                NavUtils.navigateUpFromSameTask(requireActivity())
            }
            id = requireNotNull(arguments).getString(EXTRA_SCHEDULE_ID)
        }

        return binding.root
    }

    companion object {
        private const val EXTRA_SCHEDULE_ID = "SCHEDULE_ID"

        fun newInstance(scheduleId: String): ScheduleDetailFragment {
            val bundle = Bundle().apply { putString(EXTRA_SCHEDULE_ID, scheduleId) }
            return ScheduleDetailFragment().apply { arguments = bundle }
        }
    }
}