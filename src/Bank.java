import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Random;

public class Bank {
    private ArrayList<PriorityQueue<Customer>> cashDesks;

    public Bank(int N){
        cashDesks= new ArrayList<>(N);
        for (int i =0; i<N; i++){
            cashDesks.add(new PriorityQueue<>());
        }
    }
    public void customerEnters(String fullname,int priority){
        Random r = new Random();
        int cashdesk = r.nextInt(cashDesks.size());
        cashDesks.get(cashdesk).add(new Customer(fullname,priority));
        System.out.println(fullname+"("+priority+")"+" entered! He will be served by cash desk: "+ (cashdesk+1));

    }
    public void customerServed(){
        Random r = new Random();
        ArrayList<Integer> notEmpty= new ArrayList<>();
        for (int i=0; i<cashDesks.size(); i++)
           if (!cashDesks.get(i).isEmpty())
               notEmpty.add(i);
        if (notEmpty.isEmpty()){
            System.out.println("No customers");
        }else{
            int cashDesk=notEmpty.get(r.nextInt(notEmpty.size()));
            Customer customer= cashDesks.get(cashDesk).remove();
            System.out.println("Customer: "+ customer+ " served by cashdesk: "+(cashDesk+1));

        }
    }

    @Override
    public String toString() {
        String s = "\n"+ "=".repeat(20);
        for (int i=0; i<cashDesks.size(); i++){
            s+= "\nCash desk " +(i+1) + ": ";
            s+= cashDesks.get(i).toString();

        }
        s+="\n"+"=".repeat(20)+"\n";
        return s;
    }
}
