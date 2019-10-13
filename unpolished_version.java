package spambot.coffee;

import java.util.Scanner;


public class Main {

    final static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int water=400, milk=540, beans=120, cups=9, x, money=550;
        boolean on=true;
        int resources[]={water, milk, beans, cups, money};
        machineStats(resources);
        while(on){
            System.out.print("Write action (buy, fill, take, remaining, exit): ");
            switch(in.nextLine()){
                case "buy": buy(resources); break;
                case "fill": fill(resources); break;
                case "take": take(resources); break;
                case "remaining": machineStats(resources); break;
                case "exit": on=false; break;
            }
        }
    }
    
    
       
    static void machineStats(int res[]){//0.water, 1.milk, 2.beans, 3.cups, 4.money
      String stats[]={"The coffee machine has:", res[0]+" of water", res[1]+" of milk", res[2]+" of coffee beans", res[3]+" of disposable cups", res[4]+" of money"};
      for(int i=0; i<stats.length; i++)System.out.println(stats[i]);
      System.out.println();
    }
    
    
    static void buy(int res[]){//0.water, 1.milk, 2.beans, 3.cups, 4.money
      System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
      boolean aviable=true;
      switch(in.nextLine()){
        case "1":
            if(res[0]>=250 && res[2]>=16){
                res[0]-=250; res[2]-=16; res[4]+=4; break;}
            else{System.out.println("Sorry, not enough resources!"); available=false; break;}
        case "2":
            if(res[0]>=350 && res[1]>=75 && res[2]>=20){
                res[0]-=350; res[1]-=75; res[2]-=20; res[4]+=7; break;}
            else{System.out.println("Sorry, not enough resources!"); available=false; break;}
        case "3":
            if(res[0]>=200 && res[1]>=100 && res[2]>=12){
                res[0]-=200; res[1]-=100; res[2]-=12; res[4]+=6; break;}
            else{System.out.println("Sorry, not enough resources!"); available=false; break;}
        case "back": available=false; break;
      }
      if(available==true) res[3]-=1;
    }
    
    static void fill(int res[]){//0.water, 1.milk, 2.beans, 3.cups, 4.money
        System.out.print("Write how many ml of water do you want to add: ");
        res[0]+=in.nextInt();
        System.out.print("Write how many ml of milk do you want to add: ");
        res[1]+=in.nextInt();
        System.out.print("Write how many grams of coffee beans do you want to add: ");
        res[2]+=in.nextInt();
        System.out.print("Write how many disposable cups of coffee do you want to add: ");
        res[3]+=in.nextInt();
    }
    
    static int take(int res[]){
      int money=res[4];
      System.out.println("I gave you $"+res[4]);
      res[4]=0;
      return money;
    }
        
    static void fillMachine(int water, int milk, int beans, int cups, int x){
      System.out.print("Write how many ml of water the coffee machine has: ");
        water=in.nextInt();
        System.out.print("Write how many ml of milk the coffee machine has: ");
        milk=in.nextInt();
        System.out.print("Write how many grams of coffee beans the coffee machine has: ");
        beans=in.nextInt();
        System.out.print("Write how many cups of coffee you will need: ");
        cups=in.nextInt();
        x=min(water/200, min(milk/50, beans/15));
        if(x==cups) System.out.println("Yes, I can make that amount of coffee");
        else if(x>cups)System.out.println("Yes, I can make that amount of coffee (and even "+(x-cups)+" more than that)");
        else System.out.println("No, I can make only "+x+" cup(s) of coffee");
    }
    
    static void makeCoffee(){
        String process[]={"Starting to make a coffee", "Grinding coffee beans", "Boiling water", "Mixing boiled water with crushed coffee beans", "Pouring coffee into the cup", "Pouring some milk into the cup", "Coffee is ready!"};
        for(int i=0; i<process.length; i++)System.out.println(process[i]);
    }

    static void cupCheck(){
        Scanner in = new Scanner(System.in);
        int cups;
        System.out.print("Write how many cups of coffee you will need: ");
        cups=in.nextInt();
        System.out.println("For "+cups+" cups of coffee you will need:");
        System.out.println(cups*200+" ml of water");
        System.out.println(cups*50+" ml of milk");
        System.out.println(cups*15+" g of coffee beans");}
        
    static void machineStats2(int water, int milk, int beans, int cups, int money){
      String stats[]={"The coffee machine has:", water+" of water", milk+" of milk", beans+" of coffee beans", cups+" of disposable cups", money+" of money"};
      for(int i=0; i<stats.length; i++)System.out.println(stats[i]);
    }
        
    static int min(int a, int b){return ((a)>=(b)) ? (b):(a);}

}
