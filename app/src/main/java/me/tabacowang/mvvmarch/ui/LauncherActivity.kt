package me.tabacowang.mvvmarch.ui

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerAppCompatActivity
import me.tabacowang.mvvmarch.shared.result.EventObserver
import me.tabacowang.mvvmarch.shared.util.checkAllMatched
import me.tabacowang.mvvmarch.shared.util.viewModelProvider
import me.tabacowang.mvvmarch.ui.onboarding.OnboardingActivity
import javax.inject.Inject

class LauncherActivity: DaggerAppCompatActivity() {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: LaunchViewModel = viewModelProvider(viewModelFactory)
        viewModel.launchDestination.observe(this, EventObserver { destination ->
            when (destination) {
                LaunchDestination.MAIN_ACTIVITY -> startActivity(Intent(this, MainActivity::class.java))
                LaunchDestination.ONBOARDING -> startActivity(Intent(this, OnboardingActivity::class.java))
            }.checkAllMatched
            finish()
        })
    }
}