package com.mycompany;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        System.out.print("Enter: ");
        String h =a.next();
        System.out.println("The Result: "+derivativeForMoreThanOne(h));
    }
    public static String derivativeForMoreThanOne(String a){
        if (isValidInput(a)){
            try {
                ArrayList<String>y=Split(a);
                ArrayList<Character> esharat=getESHARA(a);
                for (int i=0;i<y.size();i++){
                    String u=derivative(y.get(i));
                    y.set(i,u);
                }
                // y=sumOfSimilarHdod(y);
                return print(y,esharat);
            }catch (Exception e){
                return "invalid input";
            }
        }else {
            return "invalid input";
        }
    }
    public static String print(ArrayList<String> a,ArrayList<Character> getEshara){
        String y=a.get(0)+getEshara.get(0);
        for (int i =1 ;i<a.size();i++){
            if (i!=a.size()-1){
                y=y+a.get(i)+getEshara.get(i);
            }else {
                y=y+a.get(i);
            }
        }
        return y;
    }
    public static String derivative(String a){
        if (isXExist(a)){
            String aaw;
            if (isNumber(a.charAt(0)) && isNumber(a.charAt(a.length()-1))){
                int er=beforeX(a);
                int er2=thePower(a);
                if (er2-1!=1){
                    if (er*er2 !=1){
                        aaw=(er*er2)+"X^"+(er2-1);
                    }else{
                        aaw="X^"+(er2-1);
                    }
                }else{
                    if (er*er2 !=1){
                        aaw=(er*er2)+"X";
                    }else{
                        aaw="X";
                    }

                }
            }else {
                if (!isNumber(a.charAt(0))){
                    a="1"+a;
                }
                if (!isNumber(a.charAt(a.length()-1))){
                    a=a+"^1";
                }
                aaw=derivative(a);
            }
            if (aaw.charAt(aaw.length()-1)=='0'){
                aaw=removeIfPower0(aaw);
            }
            return aaw;
        }else {
            return "0";
        }
    }
    public static String removeIfPower0(String a){
        String e ="";
        boolean r ;
        if (isNumber(a.charAt(0))){
            r=true;
        }else{
            e="1";
            r=false;
        }
        if (r){
            for (int i =0; i<a.length();i++){
                if (a.charAt(i)==Character.toUpperCase('x')){
                    break;
                }
                e=e+a.charAt(i);
            }
        }
        return e;
    }
    public static int thePower(String a){
        int e = a.indexOf('^');
        String w ="";
        for (int i =e+1;i<a.length();i++){
            w=w+a.charAt(i);
        }
        return Integer.parseInt(w);
    }
    public static int beforeX(String a){
        String e ="";
        for(int i =0 ; i<a.length();i++){
            if (isNumber(a.charAt(i))){
                e=e+a.charAt(i);
                continue;
            }
            break;
        }
        return Integer.parseInt(e);
    }
    public static boolean isNumber(char a){
        return a>='0' && a<='9';
    }
    public static ArrayList<String> Split(String ag,char aw){
        String q ="";
        ArrayList<String> arrayList=new ArrayList<>();
        for (int i =0 ; i<ag.length();i++){
            if (ag.charAt(i)==aw ||i==ag.length()-1){
                if (i==ag.length()-1){
                    q=q+ag.charAt(ag.length()-1);
                }
                arrayList.add(q);
                q="";
            }else{
                q=q+ag.charAt(i);
            }
        }
        return arrayList;
    }
    public static ArrayList<String> Split(String ag){
        String q ="";
        ArrayList<String> arrayList=new ArrayList<>();
        for (int i =0 ; i<ag.length();i++){
            if ((ag.charAt(i)=='+'||ag.charAt(i)=='-') ||i==ag.length()-1){
                if (i==ag.length()-1){
                    q=q+ag.charAt(ag.length()-1);
                }
                arrayList.add(q);
                q="";
            }else{
                q=q+ag.charAt(i);
            }
        }
        return arrayList;
    }
    public static ArrayList<Character> getESHARA(String a){

        ArrayList<Character> a1= new ArrayList<>();
        for (int i =0; i<a.length();i++){
            if (a.charAt(i)=='+' || a.charAt(i)=='-'){
                a1.add(a.charAt(i));
            }
        }
        return a1;
    }
    public static boolean isXExist(String a){
        boolean a1=false;
        for (int i =0 ; i<a.length();i++){
            if (Character.toUpperCase(a.charAt(i))=='X'){
                a1=true;
                break;
            }
        }
        return a1;
    }
//    public static ArrayList<String> sumOfSimilarHdod(ArrayList<String> g){
//        for (int i =0 ; i<g.size();i++){
//            for (int y=0;y<g.size();y++){
//                if (isXExist(g.get(i)) && isXExist(g.get(y))){
//                    String h1=g.get(i);
//                    String h2=g.get(y);
//                    if (thePower(h1) == thePower(h2)){
//                        int power=thePower(h1);
//                        int base1=beforeX(h1);
//                        int base2=beforeX(h2);
//                        String r =(base1+base2)+"X^"+power;
//                        g.set(i,r);
//                        g.remove(y);
//                    }
//                }else if(!isXExist(g.get(i)) && !isXExist(g.get(y))){
//                    int a = Integer.parseInt(g.get(i));
//                    int b = Integer.parseInt(g.get(y));
//                    g.set(i,""+(a+b));
//                    g.remove(y);
//                }
//            }
//        }
//        return g;
//    }
    private static boolean isValidInput(String a){
        boolean w=true;
        for (int i =0; i<a.length();i++){
            if (!isValidChar(a.charAt(i))){
                w=false;
                break;
            }
        }
        return w;
    }
    private static boolean isValidChar(char a){
        return (a<='9' && a>='0') || a=='+'||a=='-' || Character.toUpperCase(a)=='X' || a=='^';
    }
}
