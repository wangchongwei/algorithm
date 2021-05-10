# 链表

删除指定节点，只需要替换指定节点的值，替换指定节点的next指针，就相当于删除

node.val = node.next.val;
node.next = node.next.next;
将当前指针都替换成下一个指针的内容，就相当于删除了当前节点
