/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learnjava;

/**
 *
 * @author SERGE
 */
public class Recursion {
    static class MainClass{
        public int a = 10;
        public int b = 0;
    }
    public static MainClass Main(){
        MainClass g = new MainClass();
        return g;
    }
    
    public static void Run(){
        MainClass g = Main();
        System.out.println(g.b);
    }
}