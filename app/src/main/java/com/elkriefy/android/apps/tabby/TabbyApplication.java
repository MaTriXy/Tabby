package com.elkriefy.android.apps.tabby;

import android.app.Application;
import android.content.Context;

import com.elkriefy.android.apps.tabby.injection.component.ApplicationComponent;
import com.elkriefy.android.apps.tabby.injection.component.DaggerApplicationComponent;
import com.elkriefy.android.apps.tabby.injection.module.ApplicationModule;

import timber.log.Timber;

public class TabbyApplication extends Application {

    ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) Timber.plant(new Timber.DebugTree());

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public static TabbyApplication get(Context context) {
        return (TabbyApplication) context.getApplicationContext();
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }

    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }
}
