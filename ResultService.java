import java.time.LocalDateTime;

public class ResultService {

    Database db = Database.getInstance();

    public void declareResult() {

        Election e = db.getElection();

        if (e == null) {
            System.out.println("Create Election First");
            return;
        }

        if (LocalDateTime.now().isBefore(e.getEnd())) {
            System.out.println("Election Still Running");
            return;
        }

        if (e.getCandidates().isEmpty()) {
            System.out.println("No Candidates");
            return;
        }

        Candidate winner = e.getCandidates().get(0);

        for (Candidate c : e.getCandidates()) {
            if (c.getVotes() > winner.getVotes()) {
                winner = c;
            }
        }

        System.out.println("\n----- RESULTS -----");

        for (Candidate c : e.getCandidates()) {
            System.out.println(c.getName() + " : " + c.getVotes());
        }

        System.out.println("Winner: " + winner.getName());
    }
}