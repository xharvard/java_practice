package com.xhh.newinjdk6;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.io.File;
import java.io.IOException;
import java.net.URI;

/**
 * JDK6在java.awt包下新增了两个类：Desktop和SystemTray
 *
 * Desktop类：   允许 Java 应用程序启动已在本机桌面上注册的关联应用程序来处理 URI 或文件
 * SystemTray类：代表一个系统托盘桌面。
 *               在微软的Windows上，它被称为“任务栏”状态区域，
 *               在Gnome上，它被称为“通知”，
 *               在KDE上，它被称为“系统托盘”。
 *               该系统托盘由在桌面上运行的所有应用程序共享。
 */
public class Demo {
    public static void main(String[] args) throws IOException, AWTException {
        if(Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            //desktop.browse(URI.create("http://www.baidu.com"));
            //desktop.open(new File(ClassLoader.getSystemResource("file/test.txt").getPath()));
            desktop.print(new File(ClassLoader.getSystemResource("file/test.txt").getPath()));
        }else{
            System.out.println("不支持Desktop类");
        }

        if(SystemTray.isSupported()) {
            SystemTray systemTray = SystemTray.getSystemTray();
            ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/tray.png"));
            Image icon = imageIcon.getImage();
            TrayIcon trayIcon = new TrayIcon(icon, "系统托盘");
            trayIcon.setImageAutoSize(true);
            systemTray.add(trayIcon);
        }else{
            System.out.println("不支持SystemTray类");
        }
    }
}
