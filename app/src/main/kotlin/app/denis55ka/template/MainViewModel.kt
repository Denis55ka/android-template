package app.denis55ka.template

import androidx.lifecycle.ViewModel
import app.denis55ka.core.ApplicationScope
import app.denis55ka.core.ui.ViewModelKey
import com.squareup.anvil.annotations.ContributesMultibinding
import javax.inject.Inject

@ViewModelKey(MainViewModel::class)
@ContributesMultibinding(ApplicationScope::class)
class MainViewModel @Inject constructor() : ViewModel()
