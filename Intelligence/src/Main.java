public class Main{
    public static void main(String args[]) {
        Hero h1 = new Hero("Jan", 50);
        Leader l1 = new Leader("Eagle", 20);
        Hero h3 = (Hero) l1;
        h1.sayHelloTo(h3);
        h3.sayHelloTo(h1);
        Squad s = new Squad("DELTA");
        s.setLeader(l1);
        boolean exec = true;
        try {
            s.addHero(h1);
            s.addHero(h3);
        } catch (TooManyHeroesException e) {
            System.out.println(s);
            exec = false;
            e.printStackTrace();
        }finally {
            if (exec) System.out.println(s);
        }
    }
}
class Hero {
    private String name;
    private int power;
    public Hero(String name, int power) {
        this.name = name;
        this.power = power;
    }
    public String getName() {return name;}
    public void sayHelloTo(Hero other) {
        System.out.println("Hi " + other.getName() + "!");
    }
    @Override
    public String toString() {return name;}
}
class Leader extends Hero {
    public Leader(String name, int power) {
        super(name, power);
    }
}
class Squad {
    private String name;
    private Leader leader;
    private HeroNode heroes = null;
    private int heroCount = 0;
    private final int capacity = 1;
    public Squad(String name) {
        this.name = name;
    }
    public void setLeader(Leader leader) {this.leader = leader;}
    public void addHero(Hero hero) throws TooManyHeroesException {
        if (heroCount < capacity) {
            HeroNode newNode = new HeroNode(hero);
            if (heroes == null) {
                heroes = newNode;
            } else {
                HeroNode current = heroes;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
            heroCount++;
        } else {
            throw new TooManyHeroesException("Too many heroes!!!");
        }
    }
    @Override
    public String toString() {
        String result = name + ", leader: " + leader.getName() + ", heroes: ";
        HeroNode current = heroes;
        while (current != null) {
            result += current.hero.getName();
            if (current.next != null) {
                result += ", ";
            }
            current = current.next;
        }
        return result;
    }
    private static class HeroNode {
        Hero hero;
        HeroNode next;

        HeroNode(Hero hero) {
            this.hero = hero;
            this.next = null;
        }
    }
}
class TooManyHeroesException extends Exception {
    public TooManyHeroesException(String message) {
        super(message);
    }
}