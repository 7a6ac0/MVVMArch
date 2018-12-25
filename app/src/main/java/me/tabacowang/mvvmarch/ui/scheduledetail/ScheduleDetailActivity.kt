package me.tabacowang.mvvmarch.ui.scheduledetail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import me.tabacowang.mvvmarch.R
import me.tabacowang.mvvmarch.shared.util.inTransaction
import timber.log.Timber

class ScheduleDetailActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule_detail)

        val scheduleId = intent.getStringExtra(EXTRA_SCHEDULE_ID)
        if (scheduleId == null) {
            Timber.e("Schedule ID not specified")
            finish()
        } else {
            if (savedInstanceState == null) {
                supportFragmentManager.inTransaction {
                    add(R.id.schedule_detail_container, ScheduleDetailFragment.newInstance(scheduleId))
                }
            }
        }
    }

    companion object {
        private const val EXTRA_SCHEDULE_ID = "SCHEDULE_ID"

        fun starterIntent(context: Context, scheduleId: String): Intent {
            return Intent(context, ScheduleDetailActivity::class.java).apply {
                putExtra(EXTRA_SCHEDULE_ID, scheduleId)
                // Add this flag to avoid big back stacks
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            }
        }
    }
}