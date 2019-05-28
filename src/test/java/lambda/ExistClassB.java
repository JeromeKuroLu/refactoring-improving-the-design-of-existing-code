package lambda;

public final class ExistClassB {
    public static String doSomething() {
        System.out.println("Class B do something");
        return "hello world";
    }

    public static void saySomething() {
        System.out.println("Class B says, hello world");
    }

    public static void eatSomething(int foodNum) {
        if (foodNum > 5) {
            System.out.println("Class B says, it's Great");
        }
    }
}
