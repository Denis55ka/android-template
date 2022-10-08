package app.denis55ka.core.serialization

import app.denis55ka.core.ApplicationComponentScope
import com.squareup.anvil.annotations.ContributesTo
import dagger.Module
import dagger.Provides
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
@ContributesTo(ApplicationComponentScope::class)
interface SerializationModule {

    companion object {

        @Provides
        @Singleton
        fun provideJson(): Json = Json {
            ignoreUnknownKeys = true
            coerceInputValues = true
        }
    }
}
