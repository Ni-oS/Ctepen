package com.example.nik.ctepen;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Main3Activity extends MainActivity {
TextView text1;
     public static int[] hel(int a[],int n){//переворачивает массив c n элементов
         int m=a.length;
         int b[]=new int[n];
         for(int i=0;i<m;i++){
             b[i]=a[m-1-i];
         }
         return b;
     }
    public static int[] ger(int a[]){//переворачивает массив
        int n=a.length;
        int b[]=new int[n];
        for(int i =0;i<n;i++){
            b[i]=a[n-1-i];
        }
        return b;
    }
    public static int[] minus(int a[]){//удаляет первые нулN
        int n= a.length;
    int e = n-1;
        for (int i=0;i<n;i++){
            if(a[i]!=0){
                e=i;
                i=n;
            }
        }
        int b[]=new int[n-e];
        for(int i =0; i<n;i++){
            b[i]=a[i+e];
        }
        return b;
    }

    public static int[] proiz(int A[],int B[]){
        int n= A.length;
        int m=B.length;
        int t= 0;
        if(n>m){
            m=n*2;
        }else{
            m=m*2;
        }
        int a[]=hel(A,m);
        int b[]=hel(B,n);
        int c[]= new int[m];
        for(int i = 0;i<m;i++){
            for(int j=0;j<m;j++){
                if(i+j<m){
                    c[i+j]=a[i]*b[j]+t+c[i+j];
                    t=c[i+j]/10;
                    c[i+j]=c[i+j]%10;
                }
            }
            t=0;
        }
        c=ger(c);
        return minus(c);
    }
    public static int[] dil(int a[]){//делит массив на два
        int n=a.length;
        int c=0,d=0;
        for(int i=0;i<n;i++){
            if(a[i]%2==1){
                d++;
            }
            a[i]=(c*10+a[i])/2;
            c=d;d=0;
        }
        return minus(a);
    }
    public static int der(int a[],int b[]){//определяет а больше б
        int n= a.length;
        int m=b.length;
        if(n>m){
            return 1;
        }else {
            if (m > n) {
                return 0;
            } else {
                for (int i = 0;i<n;i++){
                    if(a[i]<b[i]){
                        return 0;
                    }else{
                        return 1;
                    }
                }
            }
        }
        return 0;
    }
    static int[]vich(int A[],int B[]){//разность чисел
        int n=A.length;
        int m=B.length;
        int r=1;
        int t=0;
        if(n>m){
            m=n;
        }
        int a[];
        int b[];
        if(der(A,B)==1){
            a=hel(A,m);
            b=hel(B,m);
        }else{
            a=hel(B,m);
            b=hel(A,m);
            r=-1;
        }
        int c[]=new int[m];
        for(int i=0;i<m;i++){
            c[i]=a[i]-b[i]-t;
            t=0;
            if(c[i]<0){
                c[i]=c[i]+10;
                t++;
            }
        }
        c=ger(c);
        c=minus(c);
        c[0]=c[0]*r;
        return(c);
    }
    public static int[] step(int c[],int b[]){
        if(b[b.length-1]%2==0){
            int a[]=step(c,dil(b));
            return proiz(a,a);
        }else{
            if(b.length!=1||b[0]!=1){
                int x[]={1};
                int a[]=step(c,vich(b,x));
                return proiz(a,c);
            }else{
                return c;
            }
        }
    }
    static void vsv(int a[]){
        int n=a.length;
        for(int i=0;i<n;i++){
            System.out.print(a[i]);
        }
    }
    public static int[] tre(char a[]){
        int n= a.length;
        int b[]= new int[n];
        for(int i=0;i<n;i++){
            b[i]=a[i]-'0';
        }
        return b;
    }
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        text1=(TextView) findViewById(R.id.Text);
        Intent i=getIntent();
        String s=i.getStringExtra("a");
        String g=i.getStringExtra("b");
//Long a=Long.parseLong(s);
//        Long b= Long.parseLong(g);

//            int a[] = new int[0];
//            int n=a.length;
            char b[]=s.toCharArray();
            char c[]=g.toCharArray();
            int A[]=tre(b);
            int B[]=tre(c);
            int a[] =step(A,B);
            int n=a.length;
            for(int l=0;l<n;l++) {
                text1.setText(a[l]);
            }
}}

