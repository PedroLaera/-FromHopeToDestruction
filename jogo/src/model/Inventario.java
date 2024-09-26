package model;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Inventario{
    private List<Item>itens = new ArrayList<>();

    public Inventario(){
    }

    public void adicionarItem(Item item){
        this.itens.add(item);
    }

    public void removerItem(Item item){
        this.itens.remove(item);
    }

    public boolean contemItem(String nomeItem){
        Iterator var2=this.itens.iterator();

        Item item;
        do{
            if(!var2.hasNext()){
                return false;
            }

            item=(Item)var2.next();
        }while(!item.getNome().equalsIgnoreCase(nomeItem));

        return true;
    }

    public void mostrarInventario(){
        if(this.itens.isEmpty()){
            System.out.println("Oinventárioestávazio.");
        }else{
            System.out.println("Itensnoinventário:");
            Iterator var1=this.itens.iterator();

            while(var1.hasNext()){
                Item item=(Item)var1.next();
                PrintStream var10000=System.out;
                String var10001=item.getNome();
                var10000.println(var10001+":"+item.getDescricaoPositiva());
            }
        }

    }

    public List<Item>getItens(){
        return this.itens;
    }

    public void setItens(List<Item>itens){
        this.itens=itens;
    }
}
