/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package me.tabacowang.mvvmarch.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import me.tabacowang.mvvmarch.shared.di.ActivityScoped
import me.tabacowang.mvvmarch.ui.LaunchModule
import me.tabacowang.mvvmarch.ui.LauncherActivity
import me.tabacowang.mvvmarch.ui.MainActivity
import me.tabacowang.mvvmarch.ui.agenda.AgendaModule
import me.tabacowang.mvvmarch.ui.info.InfoModule
import me.tabacowang.mvvmarch.ui.onboarding.OnboardingActivity
import me.tabacowang.mvvmarch.ui.onboarding.OnboardingModule
import me.tabacowang.mvvmarch.ui.schedule.ScheduleModule
import me.tabacowang.mvvmarch.ui.scheduledetail.ScheduleDetailActivity
import me.tabacowang.mvvmarch.ui.scheduledetail.ScheduleDetailModule

/**
 * We want Dagger.Android to create a Subcomponent which has a parent Component of whichever module
 * ActivityBindingModule is on, in our case that will be [AppComponent]. You never
 * need to tell [AppComponent] that it is going to have all these subcomponents
 * nor do you need to tell these subcomponents that [AppComponent] exists.
 * We are also telling Dagger.Android that this generated SubComponent needs to include the
 * specified modules and be aware of a scope annotation [@ActivityScoped].
 * When Dagger.Android annotation processor runs it will create 2 subcomponents for us.
 */
@Module
abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = [LaunchModule::class])
    internal abstract fun launcherActivity(): LauncherActivity

    @ActivityScoped
    @ContributesAndroidInjector(modules = [OnboardingModule::class])
    internal abstract fun onboardingActivity(): OnboardingActivity

    @ActivityScoped
    @ContributesAndroidInjector(
        modules = [
            ScheduleModule::class,
            InfoModule::class,
            AgendaModule::class
        ]
    )
    internal abstract fun mainActivity(): MainActivity

    @ActivityScoped
    @ContributesAndroidInjector(
        modules = [
            ScheduleDetailModule::class
        ]
    )
    internal abstract fun scheduleDetailActivity(): ScheduleDetailActivity
//
//    @ActivityScoped
//    @ContributesAndroidInjector(
//        modules = [
//            SpeakerModule::class,
//            SignInDialogModule::class,
//            EventActionsViewModelDelegateModule::class,
//            PreferenceModule::class
//        ]
//    )
//    internal abstract fun speakerActivity(): SpeakerActivity
}
