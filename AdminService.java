// ==============================
// File: AdminService.java
// ==============================

import java.time.LocalDateTime;

public class AdminService {

    Database db = Database.getInstance();

    public void createElection(String title, LocalDateTime start, LocalDateTime end) {
        db.setElection(new Election(title, start, end));
        System.out.println("Election Created");
    }

    public void addCandidate(int id, String name) {

        if (db.getElection() == null) {
            System.out.println("Create Election First");
            return;
        }

        for (Candidate c : db.getElection().getCandidates()) {
            if (c.getId() == id) {
                System.out.println("Candidate ID Already Exists");
                return;
            }
        }

        db.getElection().getCandidates().add(new Candidate(id, name));
        System.out.println("Candidate Added");
    }

    public void addVoter(String voterId, String name, int age) {

    if (db.getElection() == null) {
        System.out.println("Create Election First");
        return;
    }

    if (age < 18) {
        System.out.println("Voter Not Eligible");
        return;
    }

    for (Voter v : db.getElection().getVoters()) {
        if (v.getVoterId().equals(voterId)) {
            System.out.println("Voter Already Registered");
            return;
        }
    }

    
        db.getElection().getVoters().add(new Voter(voterId, name, age));
        System.out.println("Voter Registered Successfully");
    }
}