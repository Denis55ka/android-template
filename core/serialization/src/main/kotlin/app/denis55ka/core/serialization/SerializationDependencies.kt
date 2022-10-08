package app.denis55ka.core.serialization

import app.denis55ka.core.ApplicationScope
import com.squareup.anvil.annotations.ContributesTo
import kotlinx.serialization.json.Json

@ContributesTo(ApplicationScope::class)
interface SerializationDependencies {

    fun getJson(): Json
}
