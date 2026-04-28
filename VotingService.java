// ==============================
// File: VotingService.java
// ==============================

import java.time.LocalDateTime;

public class VotingService {

    Database db = Database.getInstance();

    public Voter authenticate(String voterId) {

        for (Voter v : db.getElection().getVoters()) {
            if (v.getVoterId().equals(voterId)) {
                return v;
            }
        }

        return null;
    }

    public void showCandidates() {

        if (db.getElection().getCandidates().isEmpty()) {
            System.out.println("No Candidates Available");
            return;
        }

        for (Candidate c : db.getElection().getCandidates()) {
            System.out.println(c.getId() + " - " + c.getName());
        }
    }

    public void castVote(Voter voter, int candidateId) {

        Election e = db.getElection();

        if (e == null) {
            System.out.println("Create Election First");
            return;
        }

        LocalDateTime now = LocalDateTime.now();

        if (now.isBefore(e.getStart())) {
            System.out.println("Election Not Started");
            return;
        }

        if (now.isAfter(e.getEnd())) {
            System.out.println("Voting Closed");
            return;
        }

        if (voter.hasVoted()) {
            System.out.println("Already Voted");
            return;
        }

        try {
            for (Candidate c : e.getCandidates()) {
                if (c.getId() == candidateId) {
                    c.addVote();
                    voter.markVoted();
                    System.out.println("Vote Recorded Successfully");
                    return;
                }
            }

            System.out.println("Invalid Candidate");

        } catch (Exception ex) {
            System.out.println("System Error - Rollback");
        }
    }
}