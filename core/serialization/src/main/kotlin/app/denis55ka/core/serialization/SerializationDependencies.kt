package app.denis55ka.core.serialization

import app.denis55ka.core.ApplicationComponentScope
import com.squareup.anvil.annotations.ContributesTo
import kotlinx.serialization.json.Json

@ContributesTo(ApplicationComponentScope::class)
interface SerializationDependencies {

    fun getJson(): Json
}
