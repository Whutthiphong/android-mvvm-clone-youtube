package com.example.cloneyoutube.di

import com.example.cloneyoutube.BuildConfig
import com.example.cloneyoutube.data.network.IApi
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.CallAdapter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {

    // The Retrofit service using our custom HTTP client instance as a singleton
    //Inject API
    single {
        createWebService<IApi>(
                okHttpClient = createHttpClient(),
                factory = RxJava2CallAdapterFactory.create(),
                baseUrl = BuildConfig.COVID_URL
        )
    }


}

inline fun <reified T> createWebService(okHttpClient: OkHttpClient, factory: CallAdapter.Factory, baseUrl: String): T {
    val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .addCallAdapterFactory(factory)

        .client(okHttpClient)
        .build()
    return retrofit.create(T::class.java)
}
fun createHttpClient(): OkHttpClient {
    val client = OkHttpClient.Builder()
    client.readTimeout(5 * 60, TimeUnit.SECONDS)
    return client.addInterceptor {
        val original = it.request()
        val requestBuilder = original.newBuilder()
        requestBuilder.header("Content-Type", "application/json")
        val request = requestBuilder.method(original.method(), original.body()).build()
        return@addInterceptor it.proceed(request)
    }.build()
}