package br.com.android.victorcs.data.di

import br.com.android.victorcs.data.remote.Api
import br.com.android.victorcs.data.repository.MainScreenRepository
import br.com.android.victorcs.data.utils.Constants
import br.com.android.victorcs.domain.repository.IMainScreenRepository
import okhttp3.OkHttpClient
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Koin data setup.
 * @author victorcs
 */
object DataModule {

    val module = module {

        single<IMainScreenRepository> {
            MainScreenRepository(api = get())
        }

        single(DEFAULT_NAMESPACE) { provideDefaultOkHttpClient() }
        single(DEFAULT_NAMESPACE) { provideRetrofit(get(DEFAULT_NAMESPACE)) }
        single { provideApiService(get(DEFAULT_NAMESPACE)) }

    }
}

fun provideDefaultOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
        .connectTimeout(1, TimeUnit.MINUTES)
        .readTimeout(1, TimeUnit.MINUTES)
        .writeTimeout(1, TimeUnit.MINUTES)
        .followRedirects(false)
        .followSslRedirects(false)
        .retryOnConnectionFailure(false)
        .cache(null)
        .build()
}

fun provideRetrofit(client: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(Constants.API_URL_BASE)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
}

fun provideApiService(retrofit: Retrofit): Api = retrofit.create(Api::class.java)

const val DEFAULT_NAMESPACE = "default"