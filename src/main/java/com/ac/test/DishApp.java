package com.ac.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * //点菜主程序
 * @author: zhanzheng.pang
 * @time: 2021/11/3
 */

public class DishApp {

    /** 定义集合（表示拥有的菜品）*/
    static List<Dish> dishList = new ArrayList<>();

    static List<Dish> persionDishList = new ArrayList<>();

    public static void main(String[] args) {
//        初始化菜品
        initDish();

//        创建扫描器对象
        Scanner scanner = new Scanner(System.in);

     /*   System.out.println("请输入菜品编号:");
        获取输入的内容，又阻塞的效果   只能是整数
        int i = scanner.nextInt();
        */

//      写一个死循环
        while (true){
            //     给用户展示主菜单
            showMenu();
            //     获取菜品编号
            int num = scanner.nextInt();
            switch (num){
                case 1:
                    while (true){
//                       把菜品展示出来
                        showDishMenu();
                        int id = scanner.nextInt();
                        if (id == 0){
                           break;
                        }
//                        从集合中获取菜品对象
                        Dish dish = dishList.get(id -1);
                        System.out.println("点了" + dish.name);
//                        存到已点菜单
                        persionDishList.add(dish);
                    }
                case 2:
//                    查看已经点的菜
                    System.out.println("您点了：");
                    showPersonDish();
                    break;
                case 3:
//                    买单
                    buy();
                    return;
                default:
                    throw new IllegalStateException("Unexpected value: " + num);
            }
        }

    }

    /**
     * 展示菜单
        * @Param:
        * @return: void
        * @Author: zhanzheng.pang
        * @Date: 2021/11/3 16:38
    */
    public static void showDishMenu(){
        System.out.println("请点菜：");
//        遍历集合
        for (int i = 0; i < dishList.size(); i++) {
            Dish dish = dishList.get(i);
            System.out.println(dish.id + "\t" + dish.name + "\t" + dish.price);
        }
        System.out.println("-----------输入序号点菜，按0返回");
    }

    /**
     * 点的菜
        * @Param:
        * @return: void
        * @Author: zhanzheng.pang
        * @Date: 2021/11/3 16:39
    */
    public static void showPersonDish(){
        for (int i = 0; i < persionDishList.size(); i++) {
            Dish dish = persionDishList.get(i);
            System.out.println(dish.id + "\t" + dish.name + "\t" + dish.price);
        }
    }

    /**
     * 买单
        * @Param:
        * @return: void
        * @Author: zhanzheng.pang
        * @Date: 2021/11/3 16:39
    */
    public static void buy(){
        System.out.println("正在结算");
//        定义总金额
        double total = 0f;
//        遍历已点菜品
        for (int i = 0; i < persionDishList.size(); i++) {
            Dish dish = persionDishList.get(i);
            total += dish.price;
        }
        System.out.println("一共： " + total);
    }

    /**
     * 展示菜单
        * @Param:
        * @return: void
        * @Author: zhanzheng.pang
        * @Date: 2021/11/3 16:26
    */
    public static void showMenu(){
        System.out.println("======主菜单=========");
        System.out.println("菜单\t\t\t1");
        System.out.println("已点菜品\t\t2");
        System.out.println("结账\t\t\t3");
        System.out.println("========根据编号点菜：===");
    }

   /**初始化菜品
       * @Param:
       * @return: void
       * @Author: zhanzheng.pang
       * @Date: 2021/11/3 16:26
   */
    public static void initDish(){
        Dish dish = new Dish(1,"炖白菜",19.9);
        Dish dish2 = new Dish(2,"土豆丝",68.9);
        Dish dish3 = new Dish(3,"凉菜",10);
        Dish dish4 = new Dish(4,"热菜",20);
        Dish dish5 = new Dish(5,"豆腐",55);
        dishList.add(dish);
        dishList.add(dish2);
        dishList.add(dish3);
        dishList.add(dish4);
        dishList.add(dish5);
    }
}
