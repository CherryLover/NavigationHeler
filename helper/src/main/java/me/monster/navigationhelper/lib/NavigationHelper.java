package me.monster.navigationhelper.lib;

import android.app.Activity;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.NavigatorProvider;

/**
 * @description
 * @author: Created jiangjiwei in 2019-12-25 14:51
 */
public class NavigationHelper {

    public static void navigateUp(View view, int distId) {
        KeepStateNavigator navigator = getNavigator(Navigation.findNavController(view));
        navigator.navigateUp(distId);
    }

    public static void navigateUp(Activity activity, int viewId, int distId) {
        KeepStateNavigator navigator = getNavigator(Navigation.findNavController(activity, viewId));
        navigator.navigateUp(distId);
    }

    public static void close(View view, int distId) {
        KeepStateNavigator navigator = getNavigator(Navigation.findNavController(view));
        navigator.closeMiddle(distId);
    }

    public static void close(Activity activity, int viewId, int distId) {
        KeepStateNavigator navigator = getNavigator(Navigation.findNavController(activity, viewId));
        navigator.closeMiddle(distId);
    }

    public static void navigateUp(View view) {
        Navigation.findNavController(view)
                .navigateUp();
    }

    public static void navigateUp(Activity activity, int viewId) {
        Navigation.findNavController(activity, viewId)
                .navigateUp();
    }

    private static KeepStateNavigator getNavigator(NavController navController) {
        NavigatorProvider navigatorProvider = navController.getNavigatorProvider();
        return navigatorProvider.getNavigator(KeepStateNavigator.NODE_NAME);
    }
}
