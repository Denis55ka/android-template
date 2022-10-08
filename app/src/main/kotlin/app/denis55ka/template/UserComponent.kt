package app.denis55ka.template

import app.denis55ka.core.UserComponentScope
import app.denis55ka.core.UserScope
import com.squareup.anvil.annotations.MergeComponent

@UserScope
@MergeComponent(UserComponentScope::class, dependencies = [ApplicationComponent::class])
interface UserComponent
