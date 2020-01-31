package java_practice;

import java.util.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import junit.framework.JUnit4TestAdapter;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;


class Wheel{
    private float rim,tire;

    Wheel(float rim,float tire){
        this.rim=rim;
        this.tire=tire;
    }


    float diameter(){
        return this.rim + (this.tire * 2);
    }

}

class Gear{


    private  float chainRing,cog,tire,rim;

    Gear(Map<String ,Float> m1){
        this.chainRing =m1.get("chainRing");
        this.cog=m1.get("cog");
        this.rim=m1.get("rim");
        this.tire=m1.get("tire");
    }

    float gearInches(){
        return this.ratio()*(new Wheel(this.rim,this.tire).diameter());
    }


    float ratio(){
        return (this.chainRing / (float)this.cog);
    }
}

class WhellTest extends TestCase {
    @Test
    void testCalculatesDiameter()
    {
        Wheel wheel = new Wheel(26, (float)1.5);

        assertEquals(29, wheel.diameter(),0.01);}

}


class GearTest extends TestCase{
    @Test
    public void testCalculatesGearInches(){
        Map<String , Float> m1=new HashMap<>();
        m1.put("chainRing",(float)52);
        m1.put("cog",(float)11);
        m1.put("rim",(float)26);
        m1.put("tire",(float)1.5);
        Gear gear= new Gear(m1);
        assertEquals(137.1,gear.gearInches(),0.01);
    }
}

public class ex1{
    public static void main(String args[]){
        WhellTest w1=new WhellTest();
        GearTest g1=new GearTest();
        w1.testCalculatesDiameter();
        g1.testCalculatesGearInches();
    }
}


class Wheel2{
    private float rim,tire;

    Wheel2(float rim,float tire){
        this.rim=rim;
        this.tire=tire;
    }


    float diameter(){
        return this.rim + (this.tire * 2);
    }

}

class Gear2{


    private  float chainRing,cog;
    private Wheel2 w1;

    Gear2(Map<String ,Float> m1,Wheel2 tmp){
        this.chainRing =(float)m1.get("chainRing");
        this.cog=(float)m1.get("cog");
       this.w1=tmp;
    }

    float gearInches(){
        return this.ratio()*w1.diameter();
    }


    float ratio(){
        return (this.chainRing / (float)this.cog);
    }
}

class WhellTest2 extends TestCase {
    @Test
    void testCalculatesDiameter()
    {
        Wheel2 wheel = new Wheel2(26, (float)1.5);

        assertEquals(29, wheel.diameter(),0.01);}

}


class GearTest2 extends TestCase{
    @Test
    public void testCalculatesGearInches(){
        Map<String , Float> m1=new HashMap<>();
        m1.put("chainRing",(float)52);
        m1.put("cog",(float)11);

        Gear2 gear= new Gear2(m1,new Wheel2((float)26,(float)1.5));
        assertEquals(137.1,gear.gearInches(),0.01);

    }
}

public class ex2{
    public static void main(String args[]){
        WhellTest2 w1=new WhellTest2();
        GearTest2 g1=new GearTest2();
        w1.testCalculatesDiameter();
        g1.testCalculatesGearInches();
    }
}


class Wheel3{
    private float rim,tire;

    Wheel3(float rim,float tire){
        this.rim=rim;
        this.tire=tire;
    }


    float diameter(){
        return this.rim + (this.tire * 2);
    }

}


interface Observer{
float changed(float a,float b);}

class Gear3 {


    private float chainRing, cog;
    private Wheel3 w1;
    private Observer observer;

    Gear3(Map<String, Float> m1, Wheel3 tmp, Observer ob) {
        this.chainRing = (float) m1.get("chainRing");
        this.cog = (float) m1.get("cog");
        this.w1 = tmp;
        this.observer = ob;
    }

    float gearInches() {
        return this.ratio() * w1.diameter();
    }


    float ratio() {
        return (this.chainRing / (float) this.cog);
    }

    float setCog(float new_cog) {
        this.cog = new_cog;
       return this.changed();
    }

    void set_chainring(float new_chainring) {
        this.chainRing = new_chainring;
        this.changed();
    }

    float changed() {
    float b;
        b = observer.changed(chainRing, cog);
        return b;
    }

}

@RunWith(MockitoJUnitRunner.class)
    class GearTest3 {
    @InjectMocks
        Gear3 g1;
        @Mock
        Observer tmp;
        public void setUp(){
            Map<String , Float> m1=new HashMap<>();
            m1.put("chainRing",(float)10.0);
            m1.put("cog",(float)20.0);

            Gear3 gear= new Gear3(m1,new Wheel3((float)10.0,(float)20.0),tmp);
            when(tmp.changed((float)10.0,(float)20.0)).thenReturn((float)30.00);

            //test the add functionality
            assertEquals( (float)30.0, g1.setCog((float)20.0),0.01 );
        }


    }


public class ex3 {

        public  static  void Main(String args[]){
        GearTest3 t1=new GearTest3();
        t1.setUp();
        }
}


class BiCycle{
    private float size, chain, tire_size;

    BiCycle(){}
    BiCycle(Map<String, Float> m1)
    {
        if(m1.containsKey("size")){
            this.size=m1.get("size");

        } else{
            this.size=0;
        }

        if(m1.containsKey("chain")){
            this.chain=m1.get("chain");

        } else{
            this.chain= defaultChain();
        }

        if(m1.containsKey("tire_size")){
            this.tire_size=m1.get("tire_size");

        } else{
            this.tire_size=defaultTireSize();
        }

    }



    int  localSpares() { return 2;}
    float defaultTireSize(){ return (float)20.0;}
    float defaultChain(){ return  (float)20.0;}

}


class RoadBike extends BiCycle {
    private float tape_c;

    RoadBike(){}


    int localSpares()

    {
    return 2;
    }


    float defaultTireSize(){ return (float)23.0;}

    float defaultChain(){ return  (float)20.0;}


}

interface TestClass {
    void localSparesTest();
}


class BiCycleTestClass implements TestClass {

    public void localSparesTest(){

        BiCycle tmp = mock(BiCycle.class);
        when(tmp.localSpares()).thenReturn(2);
        tmp.localSpares();
        verify(tmp).localSpares();
    }
}

class RoadBikeTestClass  implements  TestClass{
    public void localSparesTest(){

        BiCycle tmp = mock(BiCycle.class);
        when(tmp.localSpares()).thenReturn(2);
        tmp.localSpares();
        verify(tmp).localSpares();
    }

}
public class ex4 {

    public static void main(String args[]){
        BiCycle c1=new BiCycle();
        TestClass t1=new BiCycleTestClass();
        t1.localSparesTest();
    }
}
