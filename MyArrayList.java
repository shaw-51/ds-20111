package ArrayList;

import java.util.Arrays;

public class MyArrayList<E> {
    private E[]  data;//用于存放数据->列表元素
    private int size =8;   //表示当前内部数组的容量
    private int curr;  //用于指示当前存储了多少元素在数组中

    public MyArrayList(){
        size=8;
        curr=0;
        data=(E[]) new Object[size];
    }

    /**
     * e-添加到list的元素
     * pos-添加到的位置
     * return -成功/失败
     * @param e
     * @param pos
     * @return
     */
    public boolean add(E e,int pos){
        //考虑pos有效范[0,curr]
        //[1,2,3]  (5,?)
        if(pos<0||pos>curr){
            //添加的元素的位置不正确，返回失败
            return false;
        }
        // [a,b,c]  (d,1) ->[a,d,b,c]
        if(curr==size){
            //当前内部数组已经满了   将原数组扩张两倍，放入原数组元素
            data= Arrays.copyOf(data,size*2);
            size =size*2;
        }
        //将pos开始的元素依次往后移动一个位置
        //[a,b,c] ->[a, ,b,c]
        for (int i = curr-1; i >=pos ; i--) {
            data[i+1]=data[i];
        }
      // System.arraycopy(data,pos,data,pos+1,curr-pos);
        data[pos]=e;
        curr++;
        return true;
    }

    public boolean addAtHead(E e){
        return add(e,0);
    }

    public boolean addAtRail(E e){
        return add(e,curr);
    }

    //TODO 作业：在main方法中测试get是否正常工作
    public E get(int pos){
        if(pos<0 ||pos>=curr){
            return null;
        }else{
            return data[pos];
        }
    }

    //TODO 作业：增加删除第0个元素和最后一个元素的方法
    public E remove(int pos){
        if(pos<0|pos>=curr){
            return null;
        }else{
            //删除pos位置的元素
            var r=data[pos];
            //从pos+1开始到curr结束的元素都向左边移动一个位置
            //[1,2,3]删除pos为1的元素
            //curr =3, pos=1,实际拷贝了1个元素
            System.arraycopy(data,pos+1,data,pos,curr-pos-1);
            curr--;
            return r;
        }
    }

    public E removeBegin( ){
        if(data==null){
            return null;
        }
        var r=data[0];
        //将1开始到curr结束的元素向左移动一个位置
        System.arraycopy(data,1,data,0,curr-1);
        curr--;
        return r;
    }

    public E removeEnd(){
        if(data==null){
            return null;
        }
        var r=data[curr-1];
        curr--;
        return r;
    }

    /**
     * search  查找列表中对应元素的位置
     * TODO
     * @return
     */
    public int find(E e){
         for(int i=0;i<curr;i++){
             if(data[i].equals(e)){
                 return i;
             }
         }
        return -1;
    }




  @Override
  /**
   * TODO 作业：修正下面的toString方法，最后的一个元素不出现逗号和空格
   */
    public String toString() {
      StringBuilder builder=new StringBuilder();
      builder.append(this.getClass().getName());
      builder.append("：[");
        for (int i = 0; i < curr; i++) {
            builder.append(data[i].toString());
            if(i<curr-1)
            builder.append("，");
        }
        builder.append("]");
        return builder.toString();

    }

    //返回当前内部数组的位置
    public int size(){
        return curr;
    }
}
