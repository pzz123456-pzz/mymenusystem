package com.ac.test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * @author: zhanzheng.pang
 * @time: 2021/11/4
 */
public class ImgCode {


    /**随机的验证码*/
    static String[] strings = {"2","3","4","5","6","7","8","9"};

    public static void main(String[] args) throws IOException {

        /*
        定义宽高
         */
        int width = 550;
        int height = 150;
        //常量  三原色  1
        int type = BufferedImage.TYPE_INT_RGB;
        /*
        定义一个图片  三个参数  宽，高，类型
         */
        BufferedImage bufferedImage = new BufferedImage(width,height,type);

        /*
        定义一个画笔  用于在图片上写字
         */
        Graphics g = bufferedImage.getGraphics();

        /*
        修改画笔颜色
         */
        g.setColor(Color.YELLOW);

        /*
        使用画笔填充图片
         */
        g.fillRect(0,0,width,height);

        /*
        改变画笔颜色并写入随机数
        先定义随机数
         */
        Random random = new Random();
        int x = 100;
        int y = 88;
        g.setColor(Color.green);
        /*
        设置字体
         */
        g.setFont(new Font("微软雅黑",Font.PLAIN,50));
        for (int i = 0; i < 4; i++) {
            int num = random.nextInt(strings.length);
            String s = strings[num];
            g.drawString(s,x,y);
            x += 100;
        }

        /*
        设置划线干扰
        随机6条
         */
        int x1 = 75;
        int y1 = 150;

        int x2 = 75;
        int y2 = 150;
        g.setColor(Color.BLACK);
        for (int i = 0; i < 6; i++) {
            g.drawLine(random.nextInt(x1),random.nextInt(y1),random.nextInt(x2)+400,random.nextInt(y2));
        }

        /*
        存储到磁盘指定位置
         */
        ImageIO.write(bufferedImage,"jpg", new File("C:\\Users\\zhanzheng.pang\\OneDrive - Accenture\\Desktop\\各类文件\\java Test\\aaa.jpg"));


    }
}
