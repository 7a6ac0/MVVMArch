package me.tabacowang.mvvmarch.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import me.tabacowang.mvvmarch.shared.domain.pref.OnboardingCompletedUseCase
import me.tabacowang.mvvmarch.shared.result.Event
import me.tabacowang.mvvmarch.shared.result.Result
import me.tabacowang.mvvmarch.shared.util.map
import javax.inject.Inject

class LaunchViewModel @Inject constructor(
    onboardingCompletedUseCase: OnboardingCompletedUseCase
) : ViewModel() {

    private val onboardingCompletedResult = MutableLiveData<Result<Boolean>>()
    val launchDestination: LiveData<Event<LaunchDestination>>

    init {
        // Check if onboarding has already been completed and then navigate the user accordingly
        onboardingCompletedUseCase(Unit, onboardingCompletedResult)
        launchDestination = onboardingCompletedResult.map {
            // If this check fails, prefer to launch main activity than show onboarding too often
            if ((it as? Result.Success)?.data == false) {
                Event(LaunchDestination.ONBOARDING)
            } else {
                Event(LaunchDestination.MAIN_ACTIVITY)
            }
        }
    }
}

enum class LaunchDestination {
    ONBOARDING,
    MAIN_ACTIVITY
}
