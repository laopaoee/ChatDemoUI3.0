package com.hyphenate.chatuidemo.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Parcelable;
import android.widget.Toast;

import com.hyphenate.chatuidemo.ui.SplashActivity;

import java.io.ByteArrayOutputStream;

/**
 * Created by lijinfeng on 2016/6/21.
 */
public class ShortcutUtil {

    /**
     * 注意：由于Intent传递数据有大小限制
     *      因此此方法中将icon进行了压缩
     * @param context
     * @param title
     * @param icon
     * @param type
     * @param userId
     */
    public static void InstallShortcutUtil(Context context, String title, Bitmap icon, int type, String userId) {
        //创建快捷方式的Intent
        Intent shortcutintent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        //不允许重复创建
        shortcutintent.putExtra("duplicate", false);
        //快捷方式的名称
        shortcutintent.putExtra(Intent.EXTRA_SHORTCUT_NAME, title);
        //快捷方式的图标
        shortcutintent.putExtra(Intent.EXTRA_SHORTCUT_ICON, zoomImage(icon, 96, 96));
        //点击快捷图片，运行的程序主入口
        Intent intent = new Intent(context,SplashActivity.class).putExtra("from","exp").putExtra("userId",userId);
        shortcutintent.putExtra(Intent.EXTRA_SHORTCUT_INTENT,intent);
        //发送广播
        context.sendBroadcast(shortcutintent);
        Toast.makeText(context, "已添加", Toast.LENGTH_SHORT).show();
    }

    /**
     * Parcelable icon=Intent.ShortcutIconResource.fromContext(
     *  AddShortcut.this, R.drawable.ic_launcher);
     * @param context
     * @param title
     * @param icon
     * @param type
     * @param userId
     */
    public static void InstallShortcutUtil(Context context, String title, Parcelable icon, int type, String userId) {
        //创建快捷方式的Intent
        Intent shortcutintent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        //不允许重复创建
        shortcutintent.putExtra("duplicate", false);
        //快捷方式的名称
        shortcutintent.putExtra(Intent.EXTRA_SHORTCUT_NAME, title);
        //快捷方式的图标
        shortcutintent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, icon);
        //点击快捷图片，运行的程序主入口
        shortcutintent.putExtra(Intent.EXTRA_SHORTCUT_INTENT,
                new Intent("com.itszt.lee").putExtra("position", 1).putExtra("chat", true)
                        .putExtra("userId", userId).putExtra("chatType", type));
        //发送广播
        context.sendBroadcast(shortcutintent);
        Toast.makeText(context, "已添加", Toast.LENGTH_SHORT).show();
    }

    // 缩放到指定大小
    private void imageZoom(Bitmap bitMap) {
        //图片允许最大空间   单位：KB
        double maxSize = 400.00;
        //将bitmap放至数组中，意在bitmap的大小（与实际读取的原文件要大）
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitMap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] b = baos.toByteArray();
        //将字节换成KB
        double mid = b.length / 1024;
        //判断bitmap占用空间是否大于允许最大空间  如果大于则压缩 小于则不压缩
        if (mid > maxSize) {
            //获取bitmap大小 是允许最大大小的多少倍
            double i = mid / maxSize;
            //开始压缩  此处用到平方根 将宽带和高度压缩掉对应的平方根倍 （1.保持刻度和高度和原bitmap比率一致，压缩后也达到了最大大小占用空间的大小）
            bitMap = zoomImage(bitMap, bitMap.getWidth() / Math.sqrt(i),
                    bitMap.getHeight() / Math.sqrt(i));
        }
    }

    /***
     * 图片的缩放方法
     * 压缩到指定宽高
     * @param bgimage   ：源图片资源
     * @param newWidth  ：缩放后宽度
     * @param newHeight ：缩放后高度
     * @return
     */
    public static Bitmap zoomImage(Bitmap bgimage, double newWidth,
                                   double newHeight) {
        // 获取这个图片的宽和高
        float width = bgimage.getWidth();
        float height = bgimage.getHeight();
        // 创建操作图片用的matrix对象
        Matrix matrix = new Matrix();
        // 计算宽高缩放率
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        // 缩放图片动作
        matrix.postScale(scaleWidth, scaleHeight);
        Bitmap bitmap = Bitmap.createBitmap(bgimage, 0, 0, (int) width,
                (int) height, matrix, true);
        return bitmap;
    }

    /**
     * 删除快捷方式
     * */
    public static void deleteShortCut(Context context,String name)
    {
        Intent shortcut = new Intent("com.android.launcher.action.UNINSTALL_SHORTCUT");
        //快捷方式的名称
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_NAME,"HW139");
        /**删除和创建需要对应才能找到快捷方式并成功删除**/
        Intent intent = new Intent("com.hongwu.home");
        System.out.println("ShortcutUtil.deleteShortCut");

        shortcut.putExtra(Intent.EXTRA_SHORTCUT_INTENT,intent);
        context.sendBroadcast(shortcut);
    }
}
