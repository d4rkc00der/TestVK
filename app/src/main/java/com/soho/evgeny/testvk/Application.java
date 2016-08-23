package com.soho.evgeny.testvk;

import android.content.Intent;
import android.support.annotation.Nullable;

import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKAccessTokenTracker;
import com.vk.sdk.VKSdk;

/**
 * Created by evgeny on 24.08.16.
 */
public class Application extends android.app.Application {
    VKAccessTokenTracker tracker = new VKAccessTokenTracker() {
        @Override
        public void onVKAccessTokenChanged(@Nullable VKAccessToken oldToken, @Nullable VKAccessToken newToken) {
            if(newToken == null){
                Intent intent = new Intent(Application.this,MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        tracker.startTracking();
        VKSdk.initialize(this);

    }
}
