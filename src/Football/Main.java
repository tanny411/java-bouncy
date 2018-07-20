package Football;

public class Main {
    public static void main(String[] args) {
        Football fp=new Football();
        Goalkepeer goalkepeer = new Goalkepeer(fp);
        Shooter shooter = new  Shooter(fp);
    }
}