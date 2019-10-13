package spambot.coffee;

import java.util.Scanner;


public class Main {


    public static void main(String[] args) {
        
        coffeeMachine test = new coffeeMachine();
        test.machineStats();
        test.process();
        System.out.println("FINISHED");

    }
        

}

class coffeeMachine{
    Scanner in = new Scanner(System.in);
    int water=400, milk=540, beans=120, cups=9, x, money=550;
    int res[]={water, milk, beans, cups, money};
    
    private enum State{
        on, main_menu, buy, off; 
    }
    
    State state=State.on;
    
    void process(){
        while(this.state==State.on){
            System.out.print("Write action (buy, fill, take, remaining, exit): ");
            switch(this.in.nextLine()){
                case "buy": this.buy(); break;
                case "fill": this.fill(); break;
                case "take": this.take(); break;
                case "remaining": this.machineStats(); break;
                case "exit": this.state=State.off; break;
            }
        }
    }

    void machineStats(){//0.water, 1.milk, 2.beans, 3.cups, 4.money
        String stats[]={"The coffee machine has:", this.res[0]+" of water", this.res[1]+" of milk", this.res[2]+" of coffee beans", this.res[3]+" of disposable cups", this.res[4]+" of money"};
        for(int i=0; i<stats.length; i++)System.out.println(stats[i]);
        System.out.println();
    }
    
    void buy(){//0.water, 1.milk, 2.beans, 3.cups, 4.money
        System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        boolean avb=true, bck=false;
        switch(this.in.nextLine()){
            case "1":
                if(this.res[0]>=250 && this.res[2]>=16){
                    this.res[0]-=250; this.res[2]-=16; this.res[4]+=4; break;}
                else{avb=false; break;}
            case "2":
                if(this.res[0]>=350 && this.res[1]>=75 && this.res[2]>=20){
                    this.res[0]-=350; this.res[1]-=75; this.res[2]-=20; this.res[4]+=7; break;}
                else{avb=false; break;}
            case "3":
                if(this.res[0]>=200 && this.res[1]>=100 && this.res[2]>=12){
                    this.res[0]-=200; this.res[1]-=100; this.res[2]-=12; this.res[4]+=6; break;}
                else{avb=false; break;}
            default: avb=false; bck=true; break;
      }
         if(avb){this.res[3]-=1; System.out.println("I have enough resources, making you a coffee!");}
         else if(!bck) System.out.println("Sorry, not enough resources!");
    }
    
    void fill(){//0.water, 1.milk, 2.beans, 3.cups, 4.money
        System.out.print("Write how many ml of water do you want to add: ");
        this.res[0]+=this.in.nextInt();
        System.out.print("Write how many ml of milk do you want to add: ");
        this.res[1]+=this.in.nextInt();
        System.out.print("Write how many grams of coffee beans do you want to add: ");
        this.res[2]+=this.in.nextInt();
        System.out.print("Write how many disposable cups of coffee do you want to add: ");
        this.res[3]+=this.in.nextInt();
    }
    
    int take(){
        int m=this.res[4];
        System.out.println("I gave you $"+this.res[4]);
        this.res[4]=0;
        return m;
    }
        
    
  
}

