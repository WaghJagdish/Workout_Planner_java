import java.util.ArrayList;
import java.util.Scanner;

class Exercise {
    String name;
    String muscleGroup;

    Exercise(String name, String muscleGroup) {
        this.name = name;
        this.muscleGroup = muscleGroup;
    }
}

class WorkoutPlan {
    String name;
    ArrayList<Exercise> exercises;

    WorkoutPlan(String name) {
        this.name = name;
        this.exercises = new ArrayList<>();
    }

    void addExercise(Exercise exercise) {
        exercises.add(exercise);
    }
}

public class WorkoutPlanner {
    static ArrayList<WorkoutPlan> workoutPlans = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Create Workout Plan");
            System.out.println("2. View Workout Plans");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1:
                    createWorkoutPlan();
                    break;
                case 2:
                    viewWorkoutPlans();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
        }
    }

    static void createWorkoutPlan() {
        System.out.print("Enter workout plan name: ");
        String workoutPlanName = scanner.nextLine();
        WorkoutPlan workoutPlan = new WorkoutPlan(workoutPlanName);

        while (true) {
            System.out.print("Enter exercise name (or 'done' to finish): ");
            String exerciseName = scanner.nextLine();
            if (exerciseName.equalsIgnoreCase("done")) {
                break;
            }
            System.out.print("Enter exercise muscle group: ");
            String muscleGroup = scanner.nextLine();
            Exercise exercise = new Exercise(exerciseName, muscleGroup);
            workoutPlan.addExercise(exercise);
        }

        workoutPlans.add(workoutPlan);
        System.out.println("Workout plan created successfully!");
    }

    static void viewWorkoutPlans() {
        if (workoutPlans.isEmpty()) {
            System.out.println("No workout plans created yet!");
            return;
        }
        for (int i = 0; i < workoutPlans.size(); i++) {
            WorkoutPlan workoutPlan = workoutPlans.get(i);
            System.out.println("Workout Plan " + (i + 1) + ": " + workoutPlan.name);
            for (Exercise exercise : workoutPlan.exercises) {
                System.out.println("- " + exercise.name + " (" + exercise.muscleGroup + ")");
            }
            System.out.println();
        }
    }
}
