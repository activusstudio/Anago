package io.github.kobakei.anago.viewmodel;

import javax.inject.Inject;

import io.github.kobakei.anago.activity.BaseActivity;
import io.github.kobakei.anago.activity.SignInActivity;
import io.github.kobakei.anago.usecase.SignOutUseCase;
import io.github.kobakei.anago.viewmodel.base.ActivityViewModel;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * ホーム画面のビューモデル
 * Created by keisuke on 2016/09/19.
 */

public class HomeActivityViewModel extends ActivityViewModel {

    private final SignOutUseCase signOutUseCase;

    @Inject
    public HomeActivityViewModel(BaseActivity activity, SignOutUseCase signOutUseCase) {
        super(activity);
        this.signOutUseCase = signOutUseCase;
    }

    public void onSignOutClick() {
        signOutUseCase.run()
                .compose(bindToLifecycle().forCompletable())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> SignInActivity.startActivity(getContext()), Throwable::printStackTrace);
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }
}