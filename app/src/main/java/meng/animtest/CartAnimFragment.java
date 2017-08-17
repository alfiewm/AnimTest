package meng.animtest;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.PopupWindow;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import meng.animtest.ui.DurationSettingView;
import meng.animtest.utils.AnimUtils;

/**
 * Created by meng on 16/6/26.
 */
public class CartAnimFragment extends Fragment {

    public static CartAnimFragment newInstance() {
        CartAnimFragment fragment = new CartAnimFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public CartAnimFragment() {
    }

    @BindView(R.id.cart_container)
    View cartContainer;
    @BindView(R.id.cart_icon)
    View cartView;
    @BindView(R.id.btn_add_to_cart)
    View addToCartView;
    @BindView(R.id.anim_dot)
    View animDot;
    @BindView(R.id.bottom_bar)
    View bottomBar;
    @BindView(R.id.duration_settings)
    DurationSettingView durationSettingView;
    @BindView(R.id.anim_container)
    View animContainer;
    @BindView(R.id.cart_badge)
    TextView cartBadge;
    @BindView(R.id.anim_cart_badge)
    TextView animCartBadge;
    @BindView(R.id.pop_anchor)
    View popAnchor;

    private int cartItemCount = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_cart_anim, container, false);
        ButterKnife.bind(this, rootView);
        updateBadge();
        return rootView;
    }

    private void updateBadge() {
        if (cartItemCount > 0) {
            animCartBadge.setText(String.valueOf(cartItemCount));
            cartBadge.setText(String.valueOf(cartItemCount));
            animCartBadge.setVisibility(View.VISIBLE);
            cartBadge.setVisibility(View.VISIBLE);
        } else {
            animCartBadge.setVisibility(View.INVISIBLE);
            cartBadge.setVisibility(View.INVISIBLE);
        }
    }

    private View popRoot;
    private View popContent;
    private PopupWindow popupWindow;

    @OnClick(R.id.btn_buy)
    void onBuyNowClicked() {
        popRoot = LayoutInflater.from(getActivity()).inflate(R.layout.view_popup, null, false);
        popupWindow = new PopupWindow(popRoot,
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        popContent = popRoot.findViewById(R.id.pop_content);
        popRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismissPopWindow();
            }
        });
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setAnimationStyle(0);
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        popupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        popupWindow.showAtLocation(popAnchor, Gravity.CENTER, 0, 0);
    }

    private void dismissPopWindow() {
        popContent.animate().translationY(popContent.getHeight()).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                popupWindow.dismiss();
                onAddToCartClicked();
            }
        });
    }

    @OnClick(R.id.btn_add_to_cart)
    void onAddToCartClicked() {
        final float dotRadius = animDot.getWidth() / 2;
        final float startX = addToCartView.getX() + addToCartView.getWidth() / 2 - dotRadius;
        final float startY = 0;
        final float endX = cartContainer.getX() + cartContainer.getWidth() / 2 - dotRadius
                + getResources().getDisplayMetrics().density * 1;
        final float endY = cartView.getY() + cartView.getHeight() / 4;
        final float control1X = addToCartView.getX() + addToCartView.getWidth() / 2;
        final float control1Y = -bottomBar.getHeight() * 3 / 2;
        final float control2X = cartContainer.getX() + cartContainer.getWidth() / 2;
        final float control2Y = -bottomBar.getHeight() * 3 / 2;

        animContainer.setVisibility(View.VISIBLE);
        Keyframe startFrame = Keyframe.ofFloat(0f, 0f);
        Keyframe upFrame = Keyframe.ofFloat(0.5f, 0.5f);
        upFrame.setInterpolator(new DecelerateInterpolator());
        Keyframe downFrame = Keyframe.ofFloat(1f, 1f);
        downFrame.setInterpolator(new AccelerateInterpolator());
        PropertyValuesHolder propertyValuesHolder = PropertyValuesHolder.ofKeyframe("f", startFrame, upFrame,
                downFrame);
        ValueAnimator animator = ValueAnimator.ofPropertyValuesHolder(propertyValuesHolder);
        animator.setDuration(durationSettingView.getDuration());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float fraction = (float) animation.getAnimatedValue();
                float currentCx = AnimUtils.cubicBezier(fraction, startX, endX, control1X, control2X);
                float currentCy = AnimUtils.cubicBezier(fraction, startY, endY, control1Y, control2Y);
                animDot.setX(currentCx);
                animDot.setY(currentCy);
            }
        });
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                animContainer.setVisibility(View.INVISIBLE);
                increaseBadge();
            }
        });
        animator.start();
    }

    private void increaseBadge() {
        cartItemCount++;
        updateBadge();
        cartBadge.setScaleX(1);
        cartBadge.setScaleY(1);
        cartBadge.setVisibility(View.VISIBLE);
        ValueAnimator animator = ValueAnimator.ofFloat(1.0f, 1.4f, 0.7f, 1.0f);
        animator.setDuration(durationSettingView.getDuration());
        animator.setInterpolator(new DecelerateInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float scale = (float) animation.getAnimatedValue();
                cartBadge.setScaleX(scale);
                cartBadge.setScaleY(scale);
            }
        });
        animator.start();
    }
}
