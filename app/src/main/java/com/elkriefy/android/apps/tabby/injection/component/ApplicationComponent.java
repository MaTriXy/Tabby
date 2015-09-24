package com.elkriefy.android.apps.tabby.injection.component;

import android.app.Application;

import com.elkriefy.android.apps.tabby.injection.module.ApplicationModule;
import com.elkriefy.android.apps.tabby.activity.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(MainActivity mainActivity);

    Application application();
}