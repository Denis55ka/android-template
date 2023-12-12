package app.denis55ka.template

import app.denis55ka.feature1.Feature1Module
import app.denis55ka.feature2.Feature2Module
import app.denis55ka.feature3.Feature3Module
import dagger.Module

@Module(
    includes = [
        Feature1Module::class,
        Feature2Module::class,
        Feature3Module::class,
    ]
)
interface FeatureModule
