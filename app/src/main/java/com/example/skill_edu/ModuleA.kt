package com.example.skill_edu

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.BindsInstance
import dagger.Component


abstract class Feature(context: Context)
class FeatureImpl(context: Context) : Feature(context)

@Module
class AppModule {
    @Provides
    fun feature1(context: Context): Feature {
        return FeatureImpl(context)
    }


}


@Component(modules = [AppModule::class])
interface AppComponent {
    fun getFeature1(): Feature

    fun inject(mainActivity: MainActivity)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(context: Context): Builder
        fun build(): AppComponent
    }
}

