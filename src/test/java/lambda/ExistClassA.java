package lambda;

public class ExistClassA {
    private String doSomething() {
        return "hello world";
    }

    private void likeSomething() {
        System.out.println("like what?");
    }

    public void saySomething() {
        System.out.println("say, hello world");
    }

    public void eatSomething(int foodNum) {
        if (foodNum > 5) {
            System.out.println("Great!");
        }
    }
}
