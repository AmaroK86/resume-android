package com.spikes.resume.shared;

import android.graphics.Color;
import android.support.annotation.CallSuper;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.spikes.resume.R;

import butterknife.ButterKnife;

/**
 * Created by Luca Rossi
 * (luca.rossi@alea.pro) on 17/01/2017.
 */

/**
 * Extension of {@link AppCompatActivity} implements the management of:
 * - snackbar
 * - coordinatorlayout
 * - toolbar
 * - loadingoverlay
 */
public abstract class AppCompatActivityExt extends AppCompatActivity {

    private CoordinatorLayout mCoordinatorLayout;
    private Snackbar mSnackbar;
    private Toolbar mToolbar;
    private View mLoadingOverlay;

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        setPostContentView();
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        setPostContentView();
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
        setPostContentView();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @CallSuper
    protected void setPostContentView() {
        ButterKnife.bind(this);
        setToolbar(R.id.toolbar);
        setCoordinatorLayout(R.id.coordinatorLayout);
        setLoadingOverlay(R.id.layout_loading_overlay);
    }

    protected Toolbar getToolbar() {
        return mToolbar;
    }

    protected void setToolbar(@IdRes int toolbarRes) {
        mToolbar = (Toolbar) findViewById(toolbarRes);
        if (mToolbar == null) {
            Log.e("Login", "toolbar not found, did you forget to call setContentView()?");
            return;
        }
        setSupportActionBar(mToolbar);
    }

    protected CoordinatorLayout getCoordinatorLayout() {
        return mCoordinatorLayout;
    }

    protected void setCoordinatorLayout(@IdRes int coordinatorLayoutRes) {
        mCoordinatorLayout = (CoordinatorLayout) findViewById(coordinatorLayoutRes);
    }

    protected View getLoadingOverlay() {
        return mLoadingOverlay;
    }

    protected void setLoadingOverlay(@IdRes int loadingOverlayRes) {
        mLoadingOverlay = findViewById(loadingOverlayRes);
    }

    protected Snackbar getSnackbar() {
        return mSnackbar;
    }
    /**
     * Function tha displays a Snackbar with the given:
     * @param message
     * @param duration
     * @param action
     * @param actionListener
     *
     * If there isn't a coordinatorlayout a Toast is shown instead
     */
    protected void showSnackBar(String message, int duration, String action, View.OnClickListener actionListener) {
        if(mCoordinatorLayout != null) {
            mSnackbar = Snackbar.make(mCoordinatorLayout, message, duration);
            TextView tv = (TextView) mSnackbar.getView().findViewById(android.support.design.R.id.snackbar_text);
            tv.setTextColor(Color.WHITE);
            if (action != null && actionListener != null) {
                mSnackbar.setAction(action, actionListener);
                mSnackbar.setActionTextColor(ContextCompat.getColor(this, R.color.textColorPrimary));
            }
            mSnackbar.show();
        }else {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }

    protected void showSnackBar(@StringRes int message, int duration) {
        showSnackBar(getString(message), duration, null, null);
    }

    protected void showSnackBar(String message, int duration) {
        showSnackBar(message, duration, null, null);
    }

    protected void showSnackBar(String message, int duration, @StringRes int action, View.OnClickListener actionListener) {
        showSnackBar(message, duration, getString(action), actionListener);
    }

    protected void showSnackBar(@StringRes int message, int duration, String action, View.OnClickListener actionListener) {
        showSnackBar(getString(message), duration, action, actionListener);
    }

    protected void showSnackBar(@StringRes int message, int duration, @StringRes int action, View.OnClickListener actionListener) {
        showSnackBar(getString(message), duration, getString(action), actionListener);
    }

    public void showError(String errorMessage) {
        showSnackBar(errorMessage, Snackbar.LENGTH_LONG);
    }

    public void showError(Throwable throwable) {
        showSnackBar(throwable.getMessage(), Snackbar.LENGTH_LONG);
    }


    protected void showLoadingOverlay() {
        if (mLoadingOverlay != null)
            mLoadingOverlay.setVisibility(View.VISIBLE);
    }

    protected void hideLoadingOverlay() {
        if (mLoadingOverlay != null)
            mLoadingOverlay.setVisibility(View.GONE);
    }
}