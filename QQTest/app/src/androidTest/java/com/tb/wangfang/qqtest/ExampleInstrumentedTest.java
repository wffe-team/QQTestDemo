package com.tb.wangfang.qqtest;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiSelector;

import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static java.lang.Thread.sleep;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {

        Context context = InstrumentationRegistry.getContext();
        Intent launchIntent = new Intent();
        launchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //启动应用
        launchIntent.setComponent(new ComponentName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.SplashActivity"));
        context.startActivity(launchIntent);

        sleep(3000);

        // 点击 "动态" tab
        UiDevice device = UiDevice.getInstance(getInstrumentation());
        int height = device.getDisplayHeight();
        int width = device.getDisplayWidth();
        device.click(width - 50, height - 50);
        sleep(1000);

        // 点击 "好友动态" 按钮
        UiObject obj_1 = new UiObject(new UiSelector().description("点击进入好友动态"));
        obj_1.click();
        sleep(2000);

        // 点击 左上角返回 "动态"按钮
        UiObject obj_2 = new UiObject(new UiSelector().resourceId("com.tencent.mobileqq:id/ivTitleBtnLeft"));
        String text = obj_2.getText();
        obj_2.click();
        sleep(1000);

        // 点击菜单键
        device.pressMenu();
        sleep(1000);

        // 点击退出qq
        UiObject obj_3 = new UiObject(new UiSelector().text("退出QQ"));
        obj_3.click();
        sleep(1000);

        // 点击确定
        UiObject obj_4 = new UiObject(new UiSelector().text("确定"));
        obj_4.click();
    }
}
