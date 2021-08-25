package com.example.skill_edu

import android.content.Context
import dagger.BindsInstance
import dagger.Component

@Component(modules = [ModuleA::class])
interface AppComponent {
    fun getFormatters(): Map<String, FormatExporter>

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(context: Context): Builder
        fun build() : AppComponent
    }
}