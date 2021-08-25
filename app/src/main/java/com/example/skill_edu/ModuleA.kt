package com.example.skill_edu

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import dagger.multibindings.IntoSet
import dagger.multibindings.StringKey


abstract class FormatExporter(context: Context)
class XmlFormatExporter(context: Context) : FormatExporter(context)
class CSVFormatExporter(context: Context) : FormatExporter(context)

@Module
class ModuleA {
    @IntoMap
    @StringKey("xml")
    @Provides
    fun xmlFileExporter(context: Context): FormatExporter {
        return XmlFormatExporter(context)
    }

    @IntoMap
    @StringKey("csv")
    @Provides
    fun provideCSVFileExporter(context: Context): FormatExporter {
        return CSVFormatExporter(context)
    }

}
