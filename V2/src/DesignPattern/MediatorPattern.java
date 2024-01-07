package DesignPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Bidder and Auction using Mediator Impl
 * 
 * 
 */

interface Mediator{

    void addBidder(Member members);
    void placeBid(Member member, int bidAmt);
   
}

class Action implements Mediator{

    List<Member> members=null;


    public Action() {
        members=new ArrayList<>();
    }


    @Override
    public void addBidder(Member bidder) {
      members.add(bidder);
    }

   

    @Override
    public void placeBid(Member member, int bidAmt) {
        for(Member m:members){
            if(!m.getName().equals(member.getName())){
                m.receiveBidNotification(bidAmt);
            }
        }
    }
    
} 


interface Member{
    void placeBid(int amt);
    void receiveBidNotification(int bidAmt);
     String getName();
}

class Bidder implements Member{

    String name;
    Mediator mediator;

    public Bidder(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
        this.mediator.addBidder(this);
    }


    @Override
    public String getName() {
      return name;
    }

    @Override
    public void placeBid(int amt) {
        this.mediator.placeBid(this, amt);
    }

    @Override
    public void receiveBidNotification(int amt) {
       System.out.println("Bidder Name: "+getName()+", Received notification of bid amount placed be some one else "+amt);
    }

}

public class MediatorPattern {
    
    public static void main(String[] args) {
        Mediator mediator=new Action();
        Bidder b1=new Bidder("A1",mediator);
        Bidder b2=new Bidder("A2",mediator);
        Bidder b3=new Bidder("A3",mediator);
        b1.placeBid(10);
      //  b2.placeBid(20);
    }
}
