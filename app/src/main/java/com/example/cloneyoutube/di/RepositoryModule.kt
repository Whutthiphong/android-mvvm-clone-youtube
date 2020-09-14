package jsynctech.com.dhinternalapp.di

import com.example.cloneyoutube.repository.IInitialRepo
import com.example.cloneyoutube.repository.InitialRepo
import org.koin.dsl.module
val repositoryModule = module {

//Inject Repository
    factory<IInitialRepo> { InitialRepo(get()) }
}