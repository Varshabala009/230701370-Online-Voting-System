# Online Voting System

A complete Java-based online voting system that allows administrators to create elections, register candidates and voters, and conduct secure voting with result declaration.

## 📋 Table of Contents
- [Features](#features)
- [Requirements](#requirements)
- [Project Structure](#project-structure)
- [Installation & Setup](#installation--setup)
- [How to Run](#how-to-run)
- [Usage Guide](#usage-guide)
- [System Workflow](#system-workflow)

## ✨ Features

✅ **Election Management**
- Create and manage elections with custom date/time ranges
- Set election start and end times

✅ **Candidate Registration**
- Register candidates with unique IDs
- Track vote count for each candidate

✅ **Voter Registration**
- Register voters with voter ID, name, and age
- Age verification (minimum 18 years required)
- Prevent duplicate voter registration

✅ **Secure Voting**
- Voters can cast votes only once
- Vote validation during election period
- Real-time vote recording
- Prevent voting during election downtime

✅ **Result Declaration**
- View final voting results
- Display winner with highest vote count
- Show detailed vote breakdown for all candidates

## 💻 Requirements

- **Java 8 or higher**
- **Windows/Linux/Mac** operating system
- **Command line/Terminal** access

## 📁 Project Structure

```
Online-Voting-System/
├── AdminService.java          # Manages election, candidate, and voter operations
├── VotingService.java         # Handles voting logic and authentication
├── ResultService.java         # Declares and displays voting results
├── Database.java              # Singleton database class for data storage
├── Election.java              # Election class with candidates and voters
├── Candidate.java             # Candidate entity with vote counting
├── Voter.java                 # Voter entity with voting status
├── Main.java                  # Main menu and user interface
├── .gitignore                 # Git ignore file
└── README.md                  # This file
```

## 🚀 Installation & Setup

### Step 1: Clone or Download the Repository
```bash
git clone https://github.com/Varshabala009/230701370-Online-Voting-System.git
cd 230701370-Online-Voting-System
```

### Step 2: Verify Java Installation
```bash
java -version
```

### Step 3: Compile the Project
Navigate to the project directory and compile all Java files:
```bash
javac *.java
```

This will generate `.class` files for all Java classes.

## ▶️ How to Run

### Run the Program
```bash
java Main
```

The main menu will appear:
```
========================
 ONLINE VOTING SYSTEM 
========================
1. Create Election
2. Register Candidate
3. Register Voter
4. Vote
5. Declare Result
6. Exit
Enter Choice: 
```

## 📖 Usage Guide

### 1. Create Election (Option 1)
- Creates a new election with 2-minute duration
- Must be done before registering candidates and voters
- Example output: `Election Created`

### 2. Register Candidate (Option 2)
- Enter **Candidate ID** (unique number)
- Enter **Candidate Name**
- Example: ID: 1, Name: John

**Validations:**
- Candidate ID must be unique
- Election must be created first

### 3. Register Voter (Option 3)
- Enter **Voter ID** (e.g., V101)
- Enter **Voter Name**
- Enter **Age** (minimum 18 years required)

**Validations:**
- Age must be ≥ 18 years
- Voter ID must be unique
- Election must be created first

**Example:**
```
Enter Voter ID: V101
Enter Voter Name: Rahul
Enter Age: 22
Voter Registered Successfully
```

### 4. Vote (Option 4)
- Enter **Voter ID** to authenticate
- Select **Candidate ID** to cast vote
- Each voter can vote only once

**Validations:**
- Voter must be registered
- Election must be active (between start and end time)
- Voter cannot vote twice
- Candidate ID must be valid

**Example:**
```
Enter Voter ID: V101
1 - John
2 - Sarah
Select Candidate ID: 1
Vote Recorded Successfully
```

### 5. Declare Result (Option 5)
- Displays all candidates with their vote counts
- Shows the winner (candidate with most votes)
- Example output:
```
========================
      ELECTION RESULT     
========================
1 - John: 5 votes
2 - Sarah: 3 votes
Winner: John with 5 votes
```

### 6. Exit (Option 6)
- Safely exits the application

## 🔄 System Workflow

```
1. Start Application
   ↓
2. Create Election (Sets 2-minute voting window)
   ↓
3. Register Candidates
   ↓
4. Register Voters
   ↓
5. Voters Cast Votes (within election period)
   ↓
6. Declare Results
   ↓
7. Exit
```

## 📝 Example Usage Session

```
Enter Choice: 1
Election Created

Enter Choice: 2
Enter Candidate ID: 1
Enter Candidate Name: Alice
Candidate Added

Enter Choice: 2
Enter Candidate ID: 2
Enter Candidate Name: Bob
Candidate Added

Enter Choice: 3
Enter Voter ID: V101
Enter Voter Name: Rahul
Enter Age: 22
Voter Registered Successfully

Enter Choice: 4
Enter Voter ID: V101
1 - Alice
2 - Bob
Select Candidate ID: 1
Vote Recorded Successfully

Enter Choice: 5
========================
      ELECTION RESULT     
========================
1 - Alice: 1 votes
2 - Bob: 0 votes
Winner: Alice with 1 votes

Enter Choice: 6
Thank You
```

## 🔐 Key Classes & Methods

### Database.java
- Singleton pattern for single database instance
- Stores election data

### Election.java
- Manages candidates and voters list
- Tracks election timing

### AdminService.java
- `createElection()` - Creates new election
- `addCandidate()` - Registers candidate
- `addVoter()` - Registers voter with age verification

### VotingService.java
- `authenticate()` - Verifies voter identity
- `castVote()` - Records vote with validations
- `showCandidates()` - Displays available candidates

### ResultService.java
- `declareResult()` - Displays final results and winner

## ⚙️ Technical Details

- **Design Pattern:** Singleton (Database class)
- **Data Structure:** ArrayList for storing candidates and voters
- **Concurrency:** Single-threaded console application
- **Time Management:** LocalDateTime for election scheduling

## 🐛 Error Handling

The system validates:
- Minimum voting age (18 years)
- Unique voter and candidate IDs
- Election creation before registration
- Active voting period
- Duplicate voting attempts

## 📱 Future Enhancements

- Database persistence (File/SQL storage)
- Multi-user concurrent voting
- User authentication with passwords
- Enhanced GUI interface
- Vote encryption for security
- Admin dashboard

## 👤 Author

**Varshabala009**
- GitHub: https://github.com/Varshabala009

## 📄 License

This project is open source and available under the MIT License.

---

**Happy Voting! 🗳️**