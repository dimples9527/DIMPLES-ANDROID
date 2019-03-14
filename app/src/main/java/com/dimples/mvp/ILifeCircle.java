package com.dimples.mvp;

import android.content.Intent;
import android.os.Bundle;

public interface ILifeCircle {

    void onCreated(Bundle savedInstanceState, Intent intent, Bundle getArguments);

    void onStart();

    void onResume();

    void onPause();

    void onStop();

    void onDestroy();

    void onSaveInstanceState(Bundle bundle);

    void onActivityCreated(Bundle savedInstanceState, Intent intent, Bundle getArguments);

    void destroyView();

    void onViewDestroy();

    void onNewIntent(Intent intent);

    void onActivityResult(int requestCode, int resultCode, Intent data);

    void attachView(IMvpView iMvpView);

}






