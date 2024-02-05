package algo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Trie {

    TrieNode root;


    public Trie() {
        root=new TrieNode(' ');
    }
    

    static class TrieNode{
        char c;
        List<TrieNode> childList;
        int count;
        boolean isEnd;

       public TrieNode(char c){
        this.c=c;
        this.childList=new LinkedList<>();
        this.isEnd=false;
        this.count=0;
       }     

       public TrieNode getChild(char c){
        if(this.childList!=null){
            for(TrieNode node:this.childList){
                if(node.c==c){
                    return node;
                }
            }
        }
        return null;
       }
        
    }

    public boolean search(String str){
        TrieNode current=root;
        for(char c: str.toCharArray()){
            if(current.getChild(c)==null)
             return false;
             else 
              current=current.getChild(c);
        }
        if(current.isEnd)
        return true;
        return false;
    }

    public void insert(String str){
        if(search(str)) return;
        TrieNode current=root;
        for(char ch:str.toCharArray()){
           TrieNode child= current.getChild(ch);
           if(child!=null){
                current=child;
           }else{
             current.childList.add(new TrieNode(ch));
             current=current.getChild(ch);
           }
           current.count++;
        }
        current.isEnd=true;
    }

    public void remove(String str){
        if(!search(str)) return ;
        TrieNode current=root;
        for(char ch: str.toCharArray()){
            TrieNode child=current.getChild(ch);
            if(child.count==1){
                current.childList.remove(child); 
              return;
            }else{
               child.count--;
               current=child; 
            }
        }
        current.isEnd=false;
    }

    public void printAllWordsinTrie(TrieNode r,String s){
        TrieNode current=r;
        if(current.childList==null) return;
        Iterator<TrieNode> itr=current.childList.iterator();
        while(itr.hasNext()){
            TrieNode node=itr.next();
            s+=node.c;
            printAllWordsinTrie(node,s);
            if(node.isEnd){
                System.out.println(""+s);
                s=s.substring(0,s.length()-1);
                }else{
                    s=s.substring(0,s.length()-1);      //
                }

        }
    }

    public static void main(String[] args) {
        Trie t=new Trie();
        t.insert("dear");
        t.insert("deal");
        t.insert("do");
        t.insert("he");
        t.insert("hen");
        t.insert("heat");
 
        System.out.println("hen present in trie : "+t.search("hen"));
        System.out.println("hear present in trie : "+t.search("hear"));
        System.out.println("deal present in trie : "+t.search("deal"));
        System.out.println("========================");
        System.out.println("Printing all word present in trie : ");
        t.printAllWordsinTrie(t.root,"");
        t.remove("hen");
        System.out.println("---------------------------");
        t.printAllWordsinTrie(t.root,"");
    }
    
}
