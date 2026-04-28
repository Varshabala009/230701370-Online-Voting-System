

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        AdminService admin = new AdminService();
        VotingService voting = new VotingService();
        ResultService result = new ResultService();

        int choice;

        do {

            System.out.println("\n========================");
            System.out.println(" ONLINE VOTING SYSTEM ");
            System.out.println("========================");
            System.out.println("1. Create Election");
            System.out.println("2. Register Candidate");
            System.out.println("3. Register Voter");
            System.out.println("4. Vote");
            System.out.println("5. Declare Result");
            System.out.println("6. Exit");
            System.out.print("Enter Choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    LocalDateTime start = LocalDateTime.now();
                    LocalDateTime end = start.plusMinutes(2);
                    admin.createElection("College Election", start, end);
                    break;

                case 2:
                    System.out.print("Enter Candidate ID: ");
                    int cid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Candidate Name: ");
                    String cname = sc.nextLine();

                    admin.addCandidate(cid, cname);
                    break;

                case 3:
                    System.out.print("Enter Voter ID: ");
                    String voterId = sc.nextLine();

                    System.out.print("Enter Voter Name: ");
                    String vname = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    admin.addVoter(voterId, vname, age);
                    break;

                case 4:
                    Database db = Database.getInstance();

                    if (db.getElection() == null) {
                        System.out.println("Create Election First");
                        break;
                    }

                    if (db.getElection().getVoters().isEmpty()) {
                        System.out.println("No Voters Registered");
                        break;
                    }

                    System.out.print("Enter Voter ID: ");
                    String id = sc.nextLine();

                    Voter voter = voting.authenticate(id);

                    if (voter == null) {
                        System.out.println("Invalid Voter ID");
                        break;
                    }

                    voting.showCandidates();

                    System.out.print("Select Candidate ID: ");
                    int voteId = sc.nextInt();
                    sc.nextLine();

                    voting.castVote(voter, voteId);
                    break;

                case 5:
                    result.declareResult();
                    break;

                case 6:
                    System.out.println("Thank You");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 6);

        sc.close();
    }
}