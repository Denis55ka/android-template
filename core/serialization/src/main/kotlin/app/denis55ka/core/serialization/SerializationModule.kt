package app.denis55ka.core.serialization

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface SerializationModule {

    @Provides
    @Singleton
    fun provideJson() = Json {
        ignoreUnknownKeys = true
        coerceInputValues = true
    }
}
