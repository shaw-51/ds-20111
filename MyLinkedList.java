package LinkedList;

public class MyLinkedList<E> {

    //定义节点的数据结构内部类
    private static class Node<E>{
        private E item;   //节点存放的数据
        private Node<E> next; //下一个节点

        public Node(E item){
            this.item=item;
            this.next=null;
        }

        @Override
        public String toString() {
            return  item.toString();
        }
    }

    private  Node<E> head;  //链表的头结点
    private int length;  //链表元素个数

    public MyLinkedList(){
        head = null;
        length = 0;
    }

    public boolean add(E data,int pos) {
        //判断非法位置
        if (pos < 0 || pos > length) {
            return false;
        }

        //在pos位置插入一个节点
        //1.构造新节点newNode
        var newNode = new Node<E>(data);

        if (pos == 0) {
            //在头部插入新节点

            //新节点指向当前头结点
            newNode.next = head;
            //头结点变为新节点
            head = newNode;
        } else {
            //非头部
            //2.先找到pos-1位置的节点（pre)
            var pre = head;
            //不会写可以代入例子
            for (int i = 0; i < pos - 1; i++) {
                pre = pre.next;
            }

            //3.新节点指向after节点 newNode->next=pre->next
            newNode.next=pre.next;
            //4.pre节点指向新节点  pre->next=newNode
            pre.next=newNode;
        }
        length++;
        return true;
    }

    public E remove(int pos) {
        //判断pos是否合法
        if (pos < 0 || pos >= length) {
            return null;
         }

        E r = null;  //返回被删除的节点数据
        //1.找到pos-1：  pre
        if (pos == 0) {
            //删除当前的head
            r = head.item;
            head = head.next;
        } else {
            //1.找到pos-1：  pre
            var pre=head;
            for (int i = 0; i < pos-1; i++) {
                pre=pre.next;
            }
            //2.pre.next=pre.next.next
            r=pre.next.item;
            pre.next=pre.next.next;
        }
        length--;
        return r;

    }
    public int size(){
        return length;
    }

    public boolean addAtHead(E e){
        return add(e,0);
    }

    public boolean addAtTail(E e){
        return add(e,length);
    }

    public E removeHead(){
        return remove(0);
    }

    public E removeTail(){
        return remove(length-1);
    }

    public boolean isEmpty(){
        return length==0;
    }




    @Override
    //TODO 作业：完善toString方法
    //LinkedList.MyLinkedList:10->20->25->30->
    //让最后一个节点不输出->
    public String toString() {
        StringBuilder builder=new StringBuilder();
        builder.append(this.getClass().getName());
        builder.append(":");
        var temp=head;
        while(temp!=null){
            //保证在尾节点前一个节点停下
            //if(temp.next!=null) {  //无法保证数据全部输出，出现死循环
                builder.append(temp);
                temp = temp.next;

            if (temp != null) {
                builder.append("->");
            }
           // }
        }
        return builder.toString();
    }

    /**
     * 返回当前链表中e数据对应的位置
     * @param e->Node里的item
     * @return   对应序号   如果无，则返回-1
     * {9->8->7->6->5->4->3->2->1->0}
     * search(6)  ->3
     */
    //TODO 作业：完成search方法
    public int find(E e){
       var temp =head;
       int index=0;   //记录遍历个数
       while(temp.item!=e){
           index++;
           temp=temp.next;
           if(index>length){
               return -1;
           }
       }
       return index;
    }
}
