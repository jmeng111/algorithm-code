# algorithm-code
## 时间复杂度

定义：最差情况下操作的流程常数操作的数量表达式，去除低阶项只取最高阶项，忽略高阶项系数。

如：O(n2) = a*n2 +b*n+c

常数操作：一个操作如果和样板的数据量无关，每次都是固定时间完成操作，叫做常数操作。

O(n2)估计的是一个能带来性能瓶颈的上限；算法时间复杂度比较系数越小越好，如系数相同，只能对比常数操作（由于常数操作时间不确定不稳妥）或相同数据量下的实际运算时间

O(n2) < O(n) < O(1)

## 空间复杂度

定义：需要多少额外空间来实现算法（计算方式与时间复杂度类似）

## 位运算

| 符号 | 描述 | 运算规则                                                     | 用途                          |
| ---- | ---- | ------------------------------------------------------------ | ----------------------------- |
| &    | 与   | 两个位都为1时，结果才为1，否则结果为0                        | 清零，取一个数的位 ，判断奇偶 |
| \|   | 或   | 两个位都为0时，结果才为0（只要有一个为1，其值为1）           | 设置某些位为1                 |
| ^    | 异或 | 两个位相同为0，相异为1                                       |                               |
| ~    | 取反 | 0变1，1变0                                                   |                               |
| >>   | 右移 | 各二进位全部右移若干位，高位补0或符号位补齐（操作数每右移一位，相当于该数除以2） |                               |
| <<   | 左移 | 各二进位全部左移若干位，高位丢弃，低位补0（若左移时舍弃的高位不包含1，则每左移一位，相当于该数乘以2） |                               |

3. 异或运算符（^）

**定义**：对参与运算的两个数据的二进制位进行"异或"运算。

**运算规则**：

```
0 ^ 0 = 0
0 ^ 1 = 1
1 ^ 0 = 1
1 ^ 1 = 0
```

**总结**：相应位相同为0，相异为1。

**性质**：

1. 交换律
2. 结合律： `(a ^ b) ^ c == a ^ (b ^ c)`
3. 对于任何数 `x`，都有 `x ^ x = 0`，`x ^ 0 = x`
4. 自反性：`a ^ b ^ b = a ^ 0 = a`

**用途**：

1. **翻转指定位**：例如，将数 `X = 1010 1110` 的低4位翻转，只需另找一个数 `Y = 0000 1111`，然后 `X ^ Y = 1010 0001` 即可得到。
2. **与0相异或值不变**：例如 `1010 1110 ^ 0000 0000 = 1010 1110`
3. **交换两个数**：

```
void Swap(int &a, int &b) {
if (a != b) {
    a ^= b;
    b ^= a;
    a ^= b;
}
}
```

6. 取反运算符（~）

**定义**：对参与运算的一个数据的二进制位进行"取反"运算。

**运算规则**：

```
~1 = 1111 1110
~0 = 1111 1111
```

即：

```
~1 = -2
~0 = -1
```

**总结**：将 0 变 1，1 变 0。

**用途**：

1. **使一个数的最低位为零**：例如，使 `a` 的最低位为0，可以表示为：`a & ~1`。`~1` 的值为 `1111 1111 1111 1110`，再按"与"运算，最低位一定为0。

位运算用法示例：

取int（8位）右侧数第一个为1



## 对数器

使用一个确实有效的算法和另一个待测试的算法对比，控制输入端与输出端相同

## 数据结构

| 类型 | 内存结构                                 | 是否有序 | 插入    | 查询    |
| ---- | ---------------------------------------- | -------- | ------- | ------- |
| 数组 | 一块连续的空间                           | 是       | O(n)    | O(n)    |
| 链表 | 空间上不连续，上一节点记录下一节点的位置 | 是       | O(1)    | O(n)    |
| 栈   | 先进后出，后进先出                       | 是       | O(1)    | O(n)    |
| 堆   | 树形结构的数组                           | 是       | O(logN) | O(logN) |

数组

链表

栈

堆

## 排序算法

### 选择排序

说明：一个长度为N的数组，按下标从左往右查找最小值放到未排序的最左侧下标

第一次排序：0 ~ n-1

第二次：1 ~ n-1 。。。

时间复杂度：O(n2)

空间复杂度：O(1)

~~~java
for(int i = 0; i <= arr.length -1 ;i++){ //遍历0 ~ N-1 
    //i 目前待排序的下标
    int minIndex = i;
    for(int j = i + 1; j <= arr.length - 1 ; j++){//i ~ N-1
         minIndex = arr[j] < arr[minIndex] ? j:minIndex;
    }
    swap(arr,i,minIndex); //交换方法
}
~~~



### 冒泡排序

说明：一个长度为N的数组，按下标从左往右查找，不断对比相邻值将对比后的最大值右移

第一次：0 ~ N-1

第二次：0 ~ N-2 。。。

时间复杂度：O(n2)

空间复杂度：O(1)

~~~java
for (int e = arr.length - 1; e > 0 ; e-- ){
    for (int i = 0; i < e; i++){
        if(arr[i] > arr[i+1]){
            swap(arr,i,i+1);
        }
    }
}
~~~



### 插入排序

说明：一个长度为N的数组，排列0~0,0~1,0~2。。。让数据在范围内有序；拿后加入的数据往左对比排序

时间复杂度：最优O(n) || 最差O(n2)

空间复杂度：O(1) 

~~~java
// 0~0有序
// 0~i想有序
for(int i = 1; i < arr.length; i++){
    for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--){ //新加数与原左侧有序数对比交换位置
        swap(arr,j,j+1)
    }
}
~~~

### 归并排序

说明：先分别对arr左侧与arr右侧排序，后选择一侧arr对比另一侧arr将两个有序的arr merge 到一起，一侧arr下标越界后，直接将另一侧arr剩余的元素直接复制到结果集中

<img src="img\归并排序.png" alt="image-20240812145333608" style="zoom:50%;" />

### 荷兰国旗

说明：给定一个数将数组中>这个数的元素放左边，< 这个元素的放右边，= 放中间

时间复杂度O(N) 

空间复杂度O(1)

代码：

~~~java
    public static void main(String[] args) {
        int[] ints = buildArray();
        showArray(ints);
        System.out.println(ints[(ints.length-1)>>1]);
        queryNumber(ints,ints[(ints.length-1)>>1]);
        showArray(ints);

    }
    public static void queryNumber(int[] arr,int number){
        int left = 0;
        int right = arr.length-1;
        int i = 0;
        while (i <= right){
            if(arr[i] < number){
                swap(arr,left++,i++);
            }
            if(arr[i] > number){
                swap(arr,i,right--);
            }
            if(arr[i] == number){
                i++;
            }
        }
    }
~~~



### 快速排序

说明：使用递归与荷兰国旗，为对比值取用合理在选取的范围内随机取值

时间复杂度O(N*logN)

空间复杂度O(1)

代码：

~~~java
public static void main(String[] args) {
        int[] arr = buildArray();
        showArray(arr);
        sort(arr, 0, arr.length - 1);
        showArray(arr);

    }
    public static void sort(int[] arr,int start,int end){
        if(start < end) {
            swap(arr, start + (int) (Math.random() * (end - start + 1)), end);
            int[] p = partition(arr, start, end);
            sort(arr, start, p[0] - 1);
            sort(arr, p[1] + 1, end);
        }
    }
    public static int[] partition(int[] arr,int L,int R){
        int less = L - 1;// <右
        int more = R;//>左
        while (L < more){
            if(arr[L] < arr[R]){
                swap(arr,++less,L++);
            }else if(arr[L] > arr[R]){
                swap(arr,--more,L);
            }else {
                L++;
            }
        }
        swap(arr,more,R);
        return new int[]{less + 1, more};
    }
~~~



### 堆排序



## 查询算法

### 二分法

说明：在一个有序或有一定规律的数组中，不断对比中位数据；确定查询的范围，最终查询到数据。

时间复杂度：O(logN)

例如：

1. 在一个有序集合中，找某个数是否存在
2. 在一个有序集合中，找>=这个数的最左侧元素的位置（注意需要二分到底，以确定元素的位置）
3. 局部最小值- 在一个arr中无序，相邻元素一定不相等（这个arr的数据放到坐标图中，连接起来一定是波浪线，满足使用二分的要求）

例3：取0到N的范围，先看0与1 N与N-1对比

最好情况:arr[0] < arr[1] && arr[N-1] < arr[N] 或 arr[0]>arr[1] && arr[N-1] > arr[N]

最差情况：不满足以上条件，对比中间值M 看M两侧 M+1、M-1走向，往向下走的方向切分



### 奇数次的元素（亦或运算）

一种数

时间复杂度O(N)，空间复杂度O(1)

~~~java
int eor = 0 
for(int i = 0; i <= arr.length -1 ;i++){ //遍历0 ~ N-1 
    eor ^ = arr[i];
}
System.Out.Println(eor);
~~~

两种数

时间复杂度O(N)，空间复杂度O(1)

~~~java
int eor = 0 
for(int i = 0; i <= arr.length -1 ;i++){ //遍历0 ~ N-1 
    eor ^ = arr[i];
}
// eor = A ^ B
int rightOne = eor & (~eor + 1);//提取最右位的1
// 亦或运算后相同为0相异为1 取最右侧位的1就是取两数最右侧不相同的位
int onlyOne = 0;
for(int cur : arr){
    if((cur & rightOne) == 0){
        onlyOne ^=cur;
    }
}
onlyOne && (eor ^ onlyOne)

~~~

### 递归查询（分治、master表达式）

分治：将数据分为两部分处理

master表达式是一种表示递归时间复杂度的公式，a为调用的次数，b为切分的子数据集，O(N^b)表示除递归外的常数操作

T(N) = a * T(N/b) + O(N^d)

log b a < d == O(N^d)

log b a > d == O(N^log b a)

log b a = d == O(N^d * logN)

例：查询最大值

时间复杂度：O(logN)，空间复杂度O(1)

代码：

~~~java
public static int process(int[] arr, int start, int end){
        if(start == end){
            return arr[start];
        }
        int mid = start + ((end - start) >> 1);
        int leftMax = process(arr, start, mid);
        int rightMax = process(arr, mid + 1, end);
        return Math.max(leftMax,rightMax);
 }
~~~

