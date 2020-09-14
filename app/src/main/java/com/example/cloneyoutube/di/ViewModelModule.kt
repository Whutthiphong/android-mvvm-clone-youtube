package jsynctech.com.dhinternalapp.di

import com.example.cloneyoutube.viewmodel.InitialViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { InitialViewModel(get()) }
}