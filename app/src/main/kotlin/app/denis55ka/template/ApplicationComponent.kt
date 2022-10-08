package app.denis55ka.template

import app.denis55ka.core.ApplicationScope
import com.squareup.anvil.annotations.MergeComponent
import javax.inject.Singleton

@Singleton
@MergeComponent(ApplicationScope::class)
interface ApplicationComponent
