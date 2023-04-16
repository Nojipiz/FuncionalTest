package com.test.gse.di

import com.skydoves.retrofit.adapters.arrow.EitherCallAdapterFactory
import com.test.gse.common.Constants
import com.test.gse.data.remote.UserApi
import com.test.gse.data.repository.UserRepositoryImpl
import com.test.gse.domain.repository.UserRepository
import com.test.gse.domain.use_case.get_users.GetUsersUseCase
import com.test.gse.presentation.user_list.UserListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AppModule {
    val userModule = module {
        viewModel{UserListViewModel(get())}
        single<UserApi> {
            Retrofit.Builder()
                .baseUrl(Constants.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(EitherCallAdapterFactory.create())
                .build()
                .create(UserApi::class.java)
        }
        single<UserRepository>{ UserRepositoryImpl(get()) }
        single{ GetUsersUseCase(get()) }
    }
}