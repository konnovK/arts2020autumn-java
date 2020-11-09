package poem;

public class PoemCheck {
    public static void main(String[] args) {
        Poem p1 = new Poem(new String[] {"aaaaaaabb","bbaaaabb!","ccccccccopp","bcaaccoppp", "bbbaaaaaopp!"});
        Poem p2 = new Poem(new String[] {"", ""});
        Poem p3 = new Poem(new String[] {"abc"});
        p1.checkEasy();
        System.out.println();
        p1.checkHard();
        System.out.println();
        p2.checkEasy();
        System.out.println();
        p2.checkHard();
        System.out.println();
        p3.checkEasy();
        System.out.println();
        p3.checkHard();
        System.out.println();
    }
}
