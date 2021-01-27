package LinkedList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
//单元测试
class MyLinkedListTest {

    @Test
    void add() {
        var list=new MyLinkedList<>();
        Assertions.assertFalse(list.add(10,1));
        list.add(10,0);
        list.add(20,1);
        list.add(30,2);
        list.add(25,2);
        list.add(5,0);
        System.out.println(list.toString());

        Assertions.assertEquals(25,list.remove(3));
        //创建断言
        System.out.println(list);
        Assertions.assertEquals(5, list.remove(0));
        Assertions.assertEquals(30, list.remove(list.size() - 1));
        System.out.println(list);

    }
    @Test
    void iterate(){
        var list = new MyLinkedList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.addAtHead(i);
        }
        System.out.println(list);
        int out =0;
        while(!list.isEmpty()){
            Assertions.assertEquals(out++, list.removeTail());
            System.out.println(list);
        }
    }

    @Test
    void find(){
        var list =new MyLinkedList<Integer>();
        list.add(10,0);
        list.add(20,1);
        list.add(30,2);
        list.add(25,2);
        list.add(5,0);
        System.out.println(list);
        int index = list.find(25);
        if(index<0){
            System.out.println("未查找到");
        }else{
            System.out.println("元素下标为"+index);
        }
    }


}