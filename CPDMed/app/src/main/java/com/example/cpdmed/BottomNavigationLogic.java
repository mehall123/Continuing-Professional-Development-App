package com.example.cpdmed;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.view.MenuItemCompat;

import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.View;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNavigationLogic implements BottomNavigationView.OnItemSelectedListener {

    private Context context;
    private BottomNavigationView bottomNavigationView;

    public BottomNavigationLogic(Context context, BottomNavigationView bottomNavigationView) {
        this.context = context;
        this.bottomNavigationView = bottomNavigationView;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        switch (itemId) {
            case R.id.menu1_activity_detail:
                Intent menu1Intent = new Intent(context, ActivityDetail.class);
                menu1Intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(menu1Intent);
                return false;

            case R.id.menu2_reflection:
                Intent menu2Intent = new Intent(context, Reflection.class);
                menu2Intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(menu2Intent);
                return true;

            case R.id.menu3_attachments:
                Intent menu3Intent = new Intent(context, Attachments.class);
                menu3Intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(menu3Intent);
                return true;

            case R.id.menu4_development_needs:
                Intent menu4Intent = new Intent(context, DevelopmentNeeds.class);
                menu4Intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(menu4Intent);
                return true;

            case R.id.menu5_relevant_links:
                Intent menu5Intent = new Intent(context, RelevantLinks.class);
                menu5Intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(menu5Intent);
                return true;

            default:
                return false;
        }
    }

    public void changeNavigationLooks(int activeItemId) {
        int menuSize = bottomNavigationView.getMenu().size();

        // Set icon color todo - doesnt work as intended in ur app...
//        for (int i = 0; i < menuSize; i++) {
//            MenuItem menuItem = bottomNavigationView.getMenu().getItem(i);
//            boolean isActive = menuItem.getItemId() == activeItemId;
//
//            View view = bottomNavigationView.findViewById(menuItem.getItemId());
//
//            Drawable iconDrawable = menuItem.getIcon();
//
//            int iconColorResId = isActive ? R.color.navigation_icon_color_selected : R.color.navigation_icon_color;
//            int iconColor = ContextCompat.getColor(context, iconColorResId);
//
//            iconDrawable.setColorFilter(iconColor, PorterDuff.Mode.SRC_IN);
//            menuItem.setIcon(iconDrawable);
//
//
//
//            // Set the updated view back to the menu item (important for icon otherwise dont work)
//            menuItem.setActionView(view);
//
//
//        }

        // Set bg color
        for (int i = 0; i < menuSize; i++) {
            MenuItem menuItem = bottomNavigationView.getMenu().getItem(i);
            boolean isActive = menuItem.getItemId() == activeItemId;

            View view = bottomNavigationView.findViewById(menuItem.getItemId());


            int backgroundResId = isActive ? R.color.navigation_bg_color_selected : R.color.navigation_bg_color;
            view.setBackgroundResource(backgroundResId);
        }
    }

}
