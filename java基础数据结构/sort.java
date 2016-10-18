��Ҫ�����У� 
һ��ð�ݣ�Bubble�����򡪡����ڽ��� 
����ѡ�����򡪡�ÿ����С/��������Ӧ��λ�� 
�����������򡪡�����һ���������źõ������� 
�ġ��ǣ�Shell�����򡪡���С���� 
�塢�鲢���� 
������������ 
�ߡ������� 
�ˡ��������� 
�š����������� 
ʮ���������� 
  
  
 
һ��ð�ݣ�Bubble������ 
 
----------------------------------Code ��С��������n����------------------------------------ 
void BubbleSortArray() 
{ 
      for(int i=1;i<n;i++) 
      { 
        for(int j=0;i<n-i;j++) 
         { 
              if(a[j]>a[j+1])//�ȽϽ�������Ԫ�� 
               { 
                   int temp; 
                   temp=a[j]; a[j]=a[j+1]; a[j+1]=temp; 
               } 
         } 
      } 
} 
-------------------------------------------------Code------------------------------------------------ 
Ч�� O��n2��,����������С�б� 
  
  
����ѡ������ 
----------------------------------Code ��С��������n����-------------------------------- 
void SelectSortArray() 
{ 
    int min_index; 
    for(int i=0;i<n-1;i++) 
    { 
         min_index=i; 
         for(int j=i+1;j<n;j++)//ÿ��ɨ��ѡ����С�� 
            if(arr[j]<arr[min_index])  min_index=j; 
         if(min_index!=i)//�ҵ���С�����������һ���Ƶ��б��е���ȷλ�� 
         { 
             int temp; 
             temp=arr[i]; arr[i]=arr[min_index]; arr[min_index]=temp; 
} 
} 
} 
-------------------------------------------------Code----------------------------------------- 
Ч��O��n2��������������С���б� 
  
  
������������ 
--------------------------------------------Code ��С��������n����------------------------------------- 
void InsertSortArray() 
{ 
for(int i=1;i<n;i++)//ѭ���ӵڶ�������Ԫ�ؿ�ʼ����Ϊarr[0]��Ϊ��������򲿷� 
{ 
    int temp=arr[i];//temp���Ϊδ�����һ��Ԫ�� 
    int j=i-1; 
while (j>=0 && arr[j]>temp)/*��temp��������Ԫ�ش�С����Ƚϣ�Ѱ��tempӦ�����λ��*/ 
{ 
    arr[j+1]=arr[j]; 
    j--; 
} 
arr[j+1]=temp; 
} 
} 
------------------------------Code-------------------------------------------------------------- 
���Ч��O��n��������Ч��O��n2����ð�ݡ�ѡ����ͬ������������С�б� 
���б������������������ð�ݡ�ѡ�����Ч�ʡ� 
  
  
�ġ��ǣ�Shell�����򡪡���С�������� 
-------------------------------------Code ��С��������n����------------------------------------- 
void ShellSortArray() 
{ 
  for(int incr=3;incr<0;incr--)//�����ݼ���������3��2��1Ϊ�� 
{ 
       for(int L=0;L<(n-1)/incr;L++)//�ظ��ֳɵ�ÿ�����б� 
{ 
   for(int i=L+incr;i<n;i+=incr)//��ÿ�����б�Ӧ�ò������� 
   { 
      int temp=arr[i]; 
      int j=i-incr; 
      while(j>=0&&arr[j]>temp) 
      { 
          arr[j+incr]=arr[j]; 
          j-=incr; 
} 
arr[j+incr]=temp; 
} 
} 
} 
} 
--------------------------------------Code------------------------------------------- 
����������С�б� 
Ч�ʹ���O��nlog2^n��~O��n^1.5����ȡ��������ֵ�������С������ʹ��������Ϊ����ֵ����Ϊ�������ֵ��2���ݣ�������һ��ͨ���л��ٴαȽ���ͬ��Ԫ�ء� 
�ǣ�Shell������Ľ��˲������򣬼����˱ȽϵĴ������ǲ��ȶ���������Ϊ���������Ԫ�ؿ��ܻ�ǰ����Ծ�� 
  
  
�塢�鲢���� 
----------------------------------------------Code ��С��������--------------------------------------- 
void MergeSort(int low,int high) 
{ 
   if(low>=high)   return;//ÿ�����б���ʣ��һ��Ԫ��ʱֹͣ 
   else int mid=(low+high)/2;/*���б��ֳ���ȵ��������б�,����������Ԫ�أ�����������б�����Ҳ����б�*/ 
   MergeSort(low,mid);//���б��һ������ 
   MergeSort(mid+1,high); 
   int [] B=new int [high-low+1];//�½�һ�����飬���ڴ�Ź鲢��Ԫ�� 
   for(int i=low,j=mid+1,k=low;i<=mid && j<=high;k++)/*�������б��������鲢��ֱ���������б��е�һ������*/ 
   { 
       if (arr[i]<=arr[j];) 
{ 
    B[k]=arr[i]; 
    I++; 
} 
else
    { B[k]=arr[j]; j++; } 
} 
for(   ;j<=high;j++,k++)//����ڶ������б�����Ȼ��Ԫ�أ���׷�ӵ����б� 
      B[k]=arr[j]; 
   for(   ;i<=mid;i++,k++)//����ڵ�һ�����б�����Ȼ��Ԫ�أ���׷�ӵ����б��� 
      B[k]=arr[i]; 
   for(int z=0;z<high-low+1;z++)//�����������B�� ����Ԫ�ظ��Ƶ�ԭʼ����arr�� 
      arr[z]=B[z]; 
} 
-----------------------------------------------------Code--------------------------------------------------- 
Ч��O��nlogn�����鲢����ѡ�ƽ������������Ч��֮��û�в��졣 
������������б����ڷ��η��� 
  
������������ 
------------------------------------Code-------------------------------------------- 
/*����������㷨˼�룺ѡ��һ����ŦԪ�أ��Դ��������н��зָ�ָ�֮�������һ������С����ŦԪ�أ�һ�����ִ�����ŦԪ�أ��ٶ��������ָ�õ������н��������Ĺ��̡�*/                  void swap(int a,int b){int t;t =a ;a =b ;b =t ;} 
        int Partition(int [] arr,int low,int high) 
        { 
            int pivot=arr[low];//���������еĵ�һ��Ԫ����Ϊ��ŦԪ�� 
            while (low < high) 
            { 
                //�Ӻ���ǰ�Ժ�벿����Ѱ�ҵ�һ��С����ŦԪ�ص�Ԫ�� 
                while (low < high && arr[high] >= pivot) 
                { 
                    --high; 
                } 
                //���������ŦԪ��С��Ԫ�ؽ�����ǰ�벿�� 
                swap(arr[low], arr[high]); 
                //��ǰ������ǰ�벿����Ѱ�ҵ�һ��������ŦԪ�ص�Ԫ�� 
                while (low <high &&arr [low ]<=pivot ) 
                { 
                    ++low ; 
                } 
                swap (arr [low ],arr [high ]);//�������ŦԪ�ش��Ԫ�ؽ�������벿�� 
            } 
            return low ;//������ŦԪ�����ڵ�λ�� 
        } 
        void QuickSort(int [] a,int low,int high) 
        { 
            if (low <high ) 
            { 
                int n=Partition (a ,low ,high ); 
                QuickSort (a ,low ,n ); 
                QuickSort (a ,n +1,high ); 
            } 
        } 
----------------------------------------Code------------------------------------- 
ƽ��Ч��O��nlogn����������������б� 
���㷨����ʱ��ȡ������Ŧֵ��λ�ã�ѡ���һ��Ԫ����Ϊ��Ŧ�����ܵ���O��n2������������Ч�ʡ�������������Ч�ʷ�����ѡ���м�ֵ��Ϊ��Ŧ��Ч����O��nlogn���� 
���ڷ��η��� 
  
  
 
�ߡ������� 
���ѣ�������һ���ն˽ڵ�Ĺؼ��־����ڻ�����������Һ��ӵĹؼ��֣���ʱλ�ڶѶ��Ľڵ�Ĺؼ������������������ġ� 
˼�룺 
(1)��i=l,����temp�� kl ; 
(2)����i������j=2i+1; 
(3)��j<��n��1����ת(4),����ת(6); 
(4)�Ƚ�kj��kj+1,��kj+1>kj,����j��j��1������j���䣻 
(5)�Ƚ�temp��kj����kj>temp������ki����kj������i=j,j=2i+1,��ת(3),����ת(6) 
(6)��ki����temp�������� 
-----------------------------------------Code--------------------------- 
void HeapSort(SeqIAst R) 
 
    { //��R[1..n]���ж����򣬲�����R[0]���ݴ浥Ԫ    int I;    BuildHeap(R)�� //��R[1-n]���ɳ�ʼ��for(i=n;i>1��i--) //�Ե�ǰ������R[1..i]���ж����򣬹���n-1�ˡ�{      R[0]=R[1]; R[1]=R[i]; R[i]=R[0]; //���Ѷ��Ͷ������һ����¼����      Heapify(R,1,i-1);  //��R[1..i-1]���µ���Ϊ�ѣ�����R[1]����Υ��������     }    } ---------------------------------------Code-------------------------------------- 
 
  
�������ʱ�䣬��Ҫ�ɽ�����ʼ�Ѻͷ����ؽ����������ֵ�ʱ�俪�����ɣ����Ǿ���ͨ������Heapifyʵ�ֵġ� 
 
      ��������ʱ�临�Ӷ�ΪO(nlgn)���������ƽ�����ܽϽӽ�������ܡ�     ���ڽ���ʼ������ıȽϴ����϶࣬���Զ����������ڼ�¼�����ٵ��ļ���     �������Ǿ͵����򣬸����ռ�ΪO(1)��     ���ǲ��ȶ������򷽷��� 
 
  
��������ֱ�Ӳ������������: 
     ֱ��ѡ�������У�Ϊ�˴�R[1..n]��ѡ���ؼ�����С�ļ�¼���������n-1�αȽϣ�Ȼ����R[2..n]��ѡ���ؼ�����С�ļ�¼������Ҫ��n-2�αȽϡ���ʵ�ϣ������n-2�αȽ��У������ȽϿ�����ǰ���n-1�αȽ����Ѿ�������������ǰһ������ʱδ������Щ�ȽϽ�������Ժ�һ������ʱ���ظ�ִ������Щ�Ƚϲ����� 
     �������ͨ�����νṹ���沿�ֱȽϽ�����ɼ��ٱȽϴ����� 
  
 
�ˡ��������� 
�� ��ѧ��ѡ�޿��ſ��Ⱥ�˳�� 
�������򣺰�����ͼ�и����㰴�������໥֮������ȹ�ϵ���г�һ���������еĹ��̡� 
������ 
������ͼ��ѡһ��û��ǰ���Ķ�������� 
��ͼ��ɾ���ö������������Ϊβ�Ļ� 
�ظ�����������ֱ��ȫ����������������������ɹ��������ߵ�ͼ�в�������ǰ���Ķ��㣨ͼ���л�·��Ϊֹ�� 
---------------------------------------Code-------------------------------------- 
void TopologicalSort()/*�����������������G�޻�·�������G�Ķ����һ���������в�����OK�����򷵻�ERROR*/ 
{ 
      int indegree[M]; 
      int i,k,j; 
      char n; 
      int count=0; 
      Stack thestack; 
      FindInDegree(G,indegree);//�Ը����������indegree[0....num] 
      InitStack(thestack);//��ʼ��ջ 
      for(i=0;i<G.num;i++) 
          Console.WriteLine("���"+G.vertices[i].data+"�����Ϊ"+indegree[i]); 
      for(i=0;i<G.num;i++) 
      { 
           if(indegree[i]==0) 
              Push(thestack.vertices[i]); 
      } 
      Console.Write("�����������˳��Ϊ��"); 
      while(thestack.Peek()!=null) 
      { 
               Pop(thestack.Peek()); 
               j=locatevex(G,n); 
               if (j==-2) 
                  { 
                         Console.WriteLine("�������󣬳��������"); 
                         exit(); 
                  } 
                Console.Write(G.vertices[j].data); 
                count++; 
                for(p=G.vertices[j].firstarc;p!=NULL;p=p.nextarc) 
                { 
                     k=p.adjvex; 
                     if (!(--indegree[k])) 
                         Push(G.vertices[k]); 
                } 
      } 
      if (count<G.num) 
          Cosole.WriteLine("��ͼ�л������ִ����޷�����"); 
      else
          Console.WriteLine("����ɹ���"); 
} 
----------------------------------------Code-------------------------------------- 
�㷨��ʱ�临�Ӷ�O��n+e���� 
  
  
 
�š����������� 
������������㷨˼���������������ơ� 
    ���Ƚ�n������Ԫ���������飬�ֱ𰴹ؼ��ֽ��бȽϣ��õ�n��2���Ƚϵ���ʤ��(�ؼ���С��)����Ϊ��һ���ȽϵĽ������������ 
    Ȼ�����n��2������Ԫ�����������飬�ֱ𰴹ؼ��ֽ��бȽϣ���������ظ���ֱ��ѡ��һ���ؼ�����С������Ԫ��Ϊֹ�� 
 
 
  
--------------------------------Code in C--------------------------------------- 
#include <stdio.h> 
#include <stdlib.h> 
#include <string.h> 
#include <math.h> 
#define SIZE 100000 
#define MAX 1000000 
struct node 
{ 
 long num;//�ؼ��� 
 char str[10]; 
 int lastwin;//���ʤ�Ķ��� 
 int killer;//�����ܵĶ��� 
 long times;//�������� 
}data[SIZE]; 
long CompareNum=0; 
long ExchangeNum=0; 
long Read(char name[])//��ȡ�ļ�a.txt�е����ݣ������������data[]�У���󷵻����ݵĸ��� 
{ 
 FILE *fp; 
 long i=1; 
 fp=fopen(name,"rw"); 
 fscanf(fp,"%d%s",&data[i].num,data[i].str); 
 while(!feof(fp)) 
 { 
  i++; 
  fscanf(fp,"%d%s",&data[i].num,data[i].str);  
 } 
 return (i-1); 
} 
long Create(long num)//����ʤ���������عھ�����С����������data[]�е��±� 
{ 
 int i,j1,j2,max,time=1; 
 long min;//��¼��ǰ�ھ����±� 
 for(i=1;pow(2,i-1)<num;i++) 
  ; 
 max=pow(2,i-1);//��Ҷ�ӽ����Ŀ 
 for(i=1;i<=max;i++)//��ʼ��Ҷ�ӽ�� 
 { 
  data[i].killer=0; 
  data[i].lastwin=0; 
  data[i].times=0; 
  if(i>num) 
   data[i].num=MAX; 
 } 
 for(i=1;i<=max;i+=2)//��һ�ֱ��� 
 { 
  ++CompareNum; 
  if(data[i].num <= data[i+1].num) 
  { 
   data[i].lastwin = i+1; 
   data[i+1].killer=i; 
   ++data[i].times; 
   ++data[i+1].times; 
   min=i; 
  } 
  else
  { 
   data[i+1].lastwin=i; 
   data[i].killer=i+1; 
   ++data[i].times; 
   ++data[i+1].times; 
   min=i+1; 
  } 
 } 
 j1=j2=0;//��¼����������δ����̭��ѡ�ֵ��±� 
 while(time <= (log(max)/log(2)))//������̭�� 
 { 
  for(i=1;i<=max;i++) 
  { 
   if(data[i].times==time && data[i].killer==0)//�ҵ�һ��ѡ�� 
   { 
    j2=i;//Ĭ����Ϊ��ѡ���еĺ����� 
    if(j1==0)//�����һλ���ǿյģ��������ѡ�������� 
     j1=j2; 
    else//���������ѡ���Ǻ����ģ���ôѡ�ֶ��ѵ���������ʼ 
    { 
     ++CompareNum; 
     if(data[j1].num <= data[j2].num)//������ѡ�ֻ�ʤ 
     { 
      data[j1].lastwin = j2;//���Ӯ����j2 
      data[j2].killer=j1;//j2�Ǳ�j1��̭�� 
      ++data[j1].times; 
      ++data[j2].times;//��ѡ�ֳ��ξ���1  
      min=j1;//��С���±�Ϊj1 
      j1=j2=0;//��j1��j2��0 
     } 
     else//ͬ�� 
     { 
      data[j2].lastwin=j1; 
      data[j1].killer=j2; 
      ++data[j1].times; 
      ++data[j2].times;      
      min=j2; 
      j1=j2=0; 
     } 
    } 
   } 
   
  } 
  time++;//������1 
 } 
 return min;//���عھ����±� 
} 
void TournamentSort(long num)//���������� 
{ 
 long tag=Create(num);//������С���±� 
 FILE *fp1; 
 fp1=fopen("sort.txt","w+");//Ϊд�봴�������ļ�sort.txt 
 while(data[tag].num != MAX)//����Сֵ���������ʱ 
 { 
  printf("%d %s\n",data[tag].num,data[tag].str);//������� 
  fprintf(fp1,"%d %s\n",data[tag].num,data[tag].str);//д������ 
  data[tag].num=MAX;//����ǰ�ھ���������滻 
  tag=Create(num);//������һ���ھ����±�  
 } 
} 
int main() 
{ 
 int num; 
 char name[10]; 
 printf("Input name of the file:"); 
 gets(name); 
 num=Read(name);//���ļ� 
 TournamentSort(num);//���������� 
 printf("CompareNum=%d\nExchangeNum=%d\n",CompareNum,ExchangeNum); 
 return 0; 
} 
------------------------------------------Code------------------------------------- 
  
  
ʮ���������� 
���������ֱ���ΪͰ������ǰ����ܵļ������򷽷���Ƚϣ�������������������ԵĲ�ͬ�� 
    ǰ�������ܵ����򷽷����ǽ����ڶ�����Ԫ�عؼ��ֽ��бȽϵĻ����ϣ����Կ��Գ�Ϊ���ڱȽϵ����� 
    �������������Ƚ�����������Ԫ�����Ρ����䡱����ͬ��Ͱ�Ȼ���ٰѸ�Ͱ�е�����Ԫ�ء��ռ�����һ�� 
ͨ��ʹ�öԶ�ؼ��ֽ�����������֡����䡱�͡��ռ����ķ�������������ʵ���˶Զ�ؼ��ֽ������� 
������������������������������������������������������������������������������ 
���� 
    ÿ���˿������������ؼ��֡�����ɫ����ֵ�����С˳��Ϊ�� 
    ��ɫ���주����?��a 
    ��ֵ��2��3��������K��A 
    �˿��ƵĴ�С�ȸ��ݻ�ɫ�Ƚϣ���ɫ����ƱȻ�ɫС���ƴ󣻻�ɫһ�������ٸ�����ֵ�Ƚϴ�С�����ԣ����˿��ư���С����Ĵ������У��ɵõ��������У� 
 ��2��������A����2��������A��?2������?A��a2������aA 
    ���������൱���������ؼ��ֵ�����һ�������ַ���ʵ�֡� 
    ��һ�������Ȱ���ɫ�ֳ��Ķѣ�ÿһ���ƾ�����ͬ�Ļ�ɫ����Ȼ����ÿһ�������ٰ���ֵ��С����Ĵ��������������ź�����Ķ��ư���ɫ��С������������һ��͵õ�����Ľ���� 
����������Ȱ���ֵ����ֳ�ʮ���ѣ�ÿһ���ƾ�����ͬ����ֵ����Ȼ����ʮ�����ư���ֵ��С�����˳�������һ���ٰ������ư�˳����ݻ�ɫ�ٷֳ��Ķѣ�ÿһ�����Ѱ���ֵ��С�����˳�����򣩣�������Ķ��ư���ɫ��С�������һ��͵õ�����Ľ���� 
������������������������������������������������������������������������������ 
ʵ�ַ����� 
�������λ����(Most Significant Digit first)�������MSD�����Ȱ�k1������飬ͬһ���м�¼���ؼ���k1��ȣ��ٶԸ��鰴k2����ֳ����飬֮�󣬶Ժ���Ĺؼ������������������飬ֱ�������λ�ؼ���kd�Ը�����������ٽ�����������������õ�һ���������С� 
�������λ����(Least Significant Digit first)�������LSD�����ȴ�kd��ʼ�����ٶ�kd-1�������������ظ���ֱ����k1������õ�һ���������С� 
---------------------------------Code in C#------------------------------------------ 
����using System; 
����using System.Collections.Generic; 
����using System.Linq; 
����using System.Text; 
����namespace LearnSort 
����{ 
����class Program 
����{ 
����static void Main(string[] args) 
����{ 
����int[] arr = CreateRandomArray(10);//����������� 
����Print(arr);//������� 
����RadixSort(ref arr);//���� 
����Print(arr);//��������Ľ�� 
����Console.ReadKey(); 
����} 
����public static void RadixSort(ref int[] arr) 
����{ 
����int iMaxLength = GetMaxLength(arr); 
����RadixSort(ref arr, iMaxLength); 
����} 
����private static void RadixSort(ref int[] arr, int iMaxLength) 
����{ 
����List<int> list = new List<int>();//���ÿ��������Ԫ�� 
����List<int>[] listArr = new List<int>[10];//ʮ��Ͱ 
����char currnetChar;//��ŵ�ǰ���ַ�����˵ĳ��Ԫ��123 �е�2 
����string currentItem;//��ŵ�ǰ��Ԫ�ر���˵ĳ��Ԫ��123 
����for (int i = 0; i < listArr.Length; i++)//��ʮ��Ͱ�����ڴ��ʼ���� 
����listArr[i] = new List<int>(); 
����for (int i = 0; i < iMaxLength; i++)//һ��ִ��iMaxLength�Σ�iMaxLength��Ԫ�ص����λ���� 
����{ 
����foreach (int number in arr)//��Ͱ 
����{ 
����currentItem = number.ToString();//����ǰԪ��ת�����ַ��� 
����try { currnetChar = currentItem[currentItem.Length-i-1]; }//�Ӹ�λ���λ��ʼ��Ͱ 
����catch { listArr[0].Add(number); continue; }//��������쳣���򽫸���ѹ��listArr[0]������˵5 ��û��ʮλ���ģ�ִ������Ĳ����϶��ᷢ��Խ���쳣�ģ���������������Ϊ��������Ϊ5��ʮλ����0�����Խ���ѹ��listArr[0]��Ͱ� 
����switch (currnetChar)//ͨ��currnetChar��ֵ��ȷ����ѹ���ĸ�Ͱ�С� 
����{ 
����case '0': listArr[0].Add(number); break; 
����case '1': listArr[1].Add(number); break; 
����case '2': listArr[2].Add(number); break; 
����case '3': listArr[3].Add(number); break; 
����case '4': listArr[4].Add(number); break; 
����case '5': listArr[5].Add(number); break; 
����case '6': listArr[6].Add(number); break; 
����case '7': listArr[7].Add(number); break; 
����case '8': listArr[8].Add(number); break; 
����case '9': listArr[9].Add(number); break; 
����default: throw new Exception("unknow error"); 
����} 
����} 
����for (int j = 0; j < listArr.Length; j++)//��ʮ��Ͱ��������������У�ѹ��list 
����foreach (int number in listArr[j].ToArray<int>()) 
����{ 
����list.Add(number); 
����listArr[j].Clear();//���ÿ��Ͱ 
����} 
����arr = list.ToArray<int>();//arrָ���������е�Ԫ�� 
����//Console.Write("{0} times:",i); 
����Print(arr);//���һ�����еĽ�� 
����list.Clear();//���list 
����} 
����} 
����//�õ����Ԫ�ص�λ�� 
����private static int GetMaxLength(int[] arr) 
����{ 
����int iMaxNumber = Int32.MinValue; 
����foreach (int i in arr)//�����õ����ֵ 
����{ 
����if (i > iMaxNumber) 
����iMaxNumber = i; 
����} 
����return iMaxNumber.ToString().Length;//����������Ԫ�ص�λ���ǲ����е�Ͷ��ȡ����... 
����} 
����//�������Ԫ�� 
����public static void Print(int[] arr) 
����{ 
����foreach (int i in arr) 
����System.Console.Write(i.ToString()+'\t'); 
����System.Console.WriteLine(); 
����} 
����//����������顣������ķ�Χ��0��1000������iLengthָ�������ٸ������ 
����public static int[] CreateRandomArray(int iLength) 
����{ 
����int[] arr = new int[iLength]; 
����Random random = new Random(); 
����for (int i = 0; i < iLength; i++) 
����arr[i] = random.Next(0,1001); 
����return arr; 
����} 
����} 
����} 
---------------------------------Code --------------------------------------------- 
���������������ȶ��Ե�������ʱ�临�Ӷ�ΪO (nlog(r)m)������rΪ����ȡ�Ļ�������mΪ��������ĳЩʱ�򣬻������򷨵�Ч�ʸ��������ıȽ������򷨡�