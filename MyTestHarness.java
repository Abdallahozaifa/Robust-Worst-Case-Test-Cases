/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testletgeneration;

/**
 *
 * @author hea113
 */
public class MyTestHarness extends TestHarness{
    Comparable object1,object2;
    
    /**
     * initializes the two objects
     * 
     * @param object1
     * @param object2 
     */
    public MyTestHarness(Comparable object1, Comparable object2){
        this.object1 = object1;
        this.object2 = object2;
    }
    
    /**
     * 
     * @param object1
     * @param object2
     * @return weather the two objects are equal 
     * @throws Exception 
     */
    public boolean checkEqual(Comparable object1, Comparable object2) throws Exception{
        if(super.checkEqual(object1, object2) == true){
            return true;
        }
        return false;
    }
    
    /**
     * 
     * @param object1
     * @param object2
     * @return weather object1 is greater than object2
     * @throws Exception 
     */
    public boolean checkGreater(Comparable object1, Comparable object2) throws Exception{
        if(super.checkGreater(object1, object2) == true){
            return true;
        }
        return false;
    }
    
    /**
     * 
     * @param object1
     * @param object2
     * @return weather object1 is smaller than object2
     * @throws Exception 
     */
    public boolean checkSmaller(Comparable object1, Comparable object2) throws Exception{
        if(super.checkSmaller(object1, object2) == true){
            return true;
        }
        return false;
    }
    
       
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
//       Class testletGen = Class.forName(args[0]);
//       TestletGeneration testletGener = (TestletGeneration) testletGen.newInstance();
//       testletGener.test();
         TestletGeneration tg = new TestletGeneration();
         tg.test();
    }
}
