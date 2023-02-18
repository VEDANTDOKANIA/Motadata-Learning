public class Demo {
    // public static void main(String[] args) {
    //     byte x = 64;
    //     int i;
    //     byte y; 
    //     i = x << 2;
    //     y = (byte) (x << 2);
    //     System.out.print(i + " " + y);

    //     // try {
    //     //     int[] arr = {1,2,3,4};
    //     // } catch (ArithmeticException e) {
    //     //     System.out.println("Arith");
    //     // } catch (ArrayIndexOutOfBoundException e) {
    //     //     System.out.print("Arr");
    //     // }

    // }

    public int fun(int a) {
        System.out.println("int");
        return a;
    }

    public String fun(int a, int b) {
        System.out.println("String");
        return "hee";
    }

    public static void main(String[] args) {
        try {
            int aaaaaaaa = 10/0;
        }catch(Exception exception)
        {
            System.out.println("Excepton");
        } finally {
            System.out.println("finally");
        }
    }
}


//  class Base {
    

//     public static void main(String[] args) {

//         try {
//             Thread.sleep(10000);
//         } catch (Exception e) {
//             System.out.println("Exception: "+e);
//         }

//         A a = new A();

//         // Base b = new Derived();
//         // b.print();
//     }
// }

// class Derived extends Base {


//     void print() {
//         System.out.println("Derived");
//     }
// }



