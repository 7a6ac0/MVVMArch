package me.tabacowang.mvvmarch.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.navigation
import me.tabacowang.mvvmarch.MainNavigationFragment
import me.tabacowang.mvvmarch.R
import me.tabacowang.mvvmarch.shared.util.consume
import me.tabacowang.mvvmarch.shared.util.inTransaction
import me.tabacowang.mvvmarch.shared.util.viewModelProvider
import me.tabacowang.mvvmarch.ui.schedule.ScheduleFragment
import me.tabacowang.mvvmarch.ui.schedule.ScheduleViewModel
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    companion object {
        private const val FRAGMENT_ID = R.id.fragment_container
    }

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var currentFragment: MainNavigationFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // This VM instance is shared between activity and fragments, as it's scoped to MainActivity
        val scheduleViewModel: ScheduleViewModel = viewModelProvider(viewModelFactory)

        navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_schedule -> consume {
                    replaceFragment(ScheduleFragment())
                }
                R.id.navigation_info -> consume {
                    // Scroll to current event next time the schedule is opened.
//                    replaceFragment(InfoFragment())
                }
                R.id.navigation_agenda -> consume {
                    // Scroll to current event next time the schedule is opened.
//                    replaceFragment(AgendaFragment())
                }
                else -> false
            }
        }
        // Add a listener to prevent reselects from being treated as selects.
        navigation.setOnNavigationItemReselectedListener {}

        if (savedInstanceState == null) {
            // Show Schedule on first creation
            if (navigation.selectedItemId == R.id.navigation_schedule) {
                // We need to add the fragment ourselves.
                replaceFragment(ScheduleFragment())
            } else {
                // This will replace the current fragemnt.
                navigation.selectedItemId = R.id.navigation_schedule
            }
        } else {
            // Find the current fragment
            currentFragment =
                    supportFragmentManager.findFragmentById(FRAGMENT_ID) as? MainNavigationFragment
                    ?: throw IllegalStateException("Activity recreated, but no fragment found!")
        }

    }

    private fun <F> replaceFragment(fragment: F) where F : Fragment, F : MainNavigationFragment {
        supportFragmentManager.inTransaction {
            currentFragment = fragment
            replace(FRAGMENT_ID, fragment)
        }
    }

    override fun onBackPressed() {
        if (!currentFragment.onBackPressed()) {
            super.onBackPressed()
        }
    }
}