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
public class TestHarness { 
    
    /**
     * 
     * @param primType1
     * @param primType2
     * @return weather values are equal to each other
     */
    boolean checkEqual(Comparable primType1, Comparable primType2) throws Exception{
        if(primType1.compareTo(primType2) == 0){
            return true;
        }
        return false;
    }
    
    /**
     * 
     * @param primType1
     * @param primType2
     * @return weather value1 is greater than value2
     */
    boolean checkGreater(Comparable primType1, Comparable primType2) throws Exception{
        if(primType1.compareTo(primType2) == 1){
            return true;
        }
        return false;
    }
    
    /**
     * 
     * @param primType1
     * @param primType2
     * @return weather value1 is less than value2
     */
    boolean checkSmaller(Comparable primType1, Comparable primType2) throws Exception{
        if(primType1.compareTo(primType2) == -1){
            return true;
        }
        return false;
    }
    
    
}
