package lambda;

/**
 * While we need to use a method whose arguments include the interface
 */
public class LambdaTest {
    public static void main(String[] args) {
        NormalClass normalClass = new NormalClass();
        /**
         * The traditional way:
         * is to create an implementation of the interface first
         */
//        LambdaInterface lambdaInterface = new LambdaInterfaceImpl();
//        normalClass.deal(lambdaInterface);

        /**
         * The JDK 8 lambda way:
         * go straight
         */
//        normalClass.deal(() -> System.out.println("hello world"));

        /**
         * we can also use some existed method as the functional interface
         * that calls Method Reference
         */
        ExistClassA classA = new ExistClassA();
        normalClass.deal(classA::saySomething);
//        normalClass.deal(classA::eatSomething); this is wrong
        normalClass.deal(ExistClassB::doSomething);
//        normalClass.deal(ExistClassB::eatSomething); this is wrong
        normalClass.deal(ExistClassB::saySomething);
    }
}
