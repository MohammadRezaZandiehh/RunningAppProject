package com.example.runningapp.di

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.musicPlayer.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideGlideInstance(
        @ApplicationContext context: Context
    ) = Glide.with(context).setDefaultRequestOptions(
        RequestOptions()
            .placeholder(R.drawable.ic_image)
            .error(R.drawable.ic_image)
            .diskCacheStrategy(DiskCacheStrategy.DATA)
    )
}
/**
 * 1- the app module will provide module/dependency as long as the application lifecycle
 * 2- @Module -> heu dagger this class is a module for us
 * 3- @InstallIn -> specify the lifetime of each module (like glide instance)
 * 4- .diskCacheStrategy(DiskCacheStrategy.DATA) --> the image will be cached with Glide
 * 5- @Singleton -> if we don't write here, every moment that we call Glide , the Glide new instance weill be created for us.
 * 6- ApplicationComponent && @Singleton : don't confuse to their definition !!
 * 7- @ApplicationContext context Context : dagger Hilt behind the scenes provide for us context. from where??? when we write @ApplicationContext it provide for us from App class that we wrote.*/