
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Election {

    private String title;
    private LocalDateTime start;
    private LocalDateTime end;

    private ArrayList<Candidate> candidates = new ArrayList<>();
    private ArrayList<Voter> voters = new ArrayList<>();

    public Election(String title, LocalDateTime start, LocalDateTime end) {
        this.title = title;
        this.start = start;
        this.end = end;
    }

    public ArrayList<Candidate> getCandidates() { return candidates; }

    public ArrayList<Voter> getVoters() { return voters; }

    public LocalDateTime getStart() { return start; }

    public LocalDateTime getEnd() { return end; }
}