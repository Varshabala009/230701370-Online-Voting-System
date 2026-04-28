
public class Database {

    private static Database instance = new Database();
    private Election election;

    private Database() {}

    public static Database getInstance() {
        return instance;
    }

    public Election getElection() {
        return election;
    }

    public void setElection(Election election) {
        this.election = election;
    }
}