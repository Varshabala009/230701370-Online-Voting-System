public class Voter {

    private String voterId;
    private String name;
    private int age;
    private boolean voted;

    public Voter(String voterId, String name, int age) {
        this.voterId = voterId;
        this.name = name;
        this.age = age;
        this.voted = false;
    }

    public String getVoterId() {
        return voterId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean hasVoted() {
        return voted;
    }

    public void markVoted() {
        voted = true;
    }
}