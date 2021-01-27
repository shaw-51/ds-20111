package ArrayList;

import ArrayList.MyArrayList;

import java.util.ArrayList;

public class MainD {

    public static void main(String[] args) {
        MyArrayList<Integer> intlist =new MyArrayList();
        //list.add(元素);
        //list.remove(位置);  移除某个位置的元素
        var r=intlist.add(10,1);
        System.out.println(r);
        System.out.println(intlist.toString());

        for (int i = 0; i < 10; i++) {
            intlist.add(i,0);
        }

        System.out.println(intlist);

        intlist.removeBegin();
        System.out.println(intlist);
        System.out.println(intlist.size());
        intlist.removeEnd();
        System.out.println(intlist);
        System.out.println(intlist.size());

        //测试get()是否正常工作
        int result= intlist.get(5);
        System.out.println("get(5)结果为："+result);
        //TODO get()无法正常工作
        //报错：Exception in thread "main" java.lang.NullPointerException
//        result= intlist.get(10);
//        System.out.println("get(10)结果为："+result);


        int index=intlist.find(8);
        if(index==-1) {
            System.out.println("元素不存在");
        }else{
            System.out.println("元素的下标为："+index);
        }


//        intlist.remove(0);
//        System.out.println(intlist);
//        System.out.println(intlist.size());
//        intlist.remove(intlist.size() - 1);
//        System.out.println(intlist);
//        intlist.remove(5);
//        System.out.println(intlist);


    }
}
