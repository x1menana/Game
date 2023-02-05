import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		//questions and multiple choice options 1-20
		String q1 = "What word means: using the power of computers to solve problems?\n"
				+ "(a)computer science\n(b)technology\n(c)engineering\n";
		
		String q2 = "What word means: creating a sequence of instructions to solve a problem?\n"
				+ "(a)critical thinking\n(b)logical thinking\n(c)computational thinking\n";
		
		String q3 = "What word means: a set of instructions a computer follows?\n"
				+ "(a)manual\n(b)program\n(c)rules\n";
		
		String q4 = "What word means: performing computations on a set of data from a program?\n"
				+ "(a)running\n(b)coding\n(c)process\n";
		
		String q5 = "What word means: a sequence of instructions that solves a problem?\n"
				+ "(a)algorithm\n(b)program\n(c)steps\n";
		
		String q6 = "What word means: what programmers create and use to tell a computer what to do?\n"
				+ "(a)code\n(b)program\n(c)java\n";
		
		String q7 = "What word means: when a program receives data from a file, keyboard, touchscreen, network, etc.?\n"
				+ "(a)output\n(b)variable\n(c)input\n";
		
		String q8 = "What word means: when a program puts data somewhere, such as a file, screen, or network?\n"
				+ "(a)input\n(b)output\n(c)variable\n";
		
		String q9 = "What word means: a placeholder for a piece of information that can change?\n"
				+ "(a)variables\n(b)holder\n(c)letter\n";
		
		String q10 = "What word means: an error in a program that prevents the "
				+ "program from running as expected?\n"
				+ "(a)moth\n(b)bug\n(c)cricket\n";
		
		String q11 = "What word means: a logical system comprising a set of rules that assigns "
				+ "a property to various structures of a computer program?\n"
				+ "(a)roles\n(b)manual\n(c)type system\n";
		
		String q12 = "What word means: characters (letters, numbers, and symbols) denoted by single or double quotes?\n"
				+ "(a)string\n(b)int\n(c)float\n";
				
		String q13 = "What word means: a variable that extends beyond the decimal point?\n"
				+ "(a)float\n(b)integer\n(c)boolean\n";
		
		String q14 = "What word means: the 'true and false' logic that powers computers?\n"
				+ "(a)fact\n(b)logic\n(c)boolean\n";
		
		String q15 = "What word means: a whole number that can be positive, negative, or zero?\n"
				+ "(a)float\n(b)integer\n(c)string\n";
		
		String q16 = "What word means: rules that control the structure of the symbols, punctuation, and words in a programming language?\n"
				+ "(a)manual\n(b)syntax\n(c)order\n";
		
		String q17 = "What word means: the form of capitalization used for naming variables?\n"
				+ "(a)snake case\n(b)English\n(c)camel case\n";
		
		String q18 = "What word means: style of writing in which each space is replaced with an underscore (_) character, "
				+ "and the first letter of each word is written in lowercase?\n"
				+ "(a)snake case\n(b)camel case\n(c)under case\n";
		
		String q19 = "What word means: a variable or value that is used in an operation?\n"
				+ "(a)operator\n(b)operand\n(c)letters\n";
		
		String q20 = "What word means: an arithmetic symbol such as a plus sign, minus sign, "
				+ "multiplication sign, division sign, greater than, or less than sign?\n"
				+ "(a)operand\n(b)math symbols\n(c)operator\n";
		
		//this tells the code the correct answer choices to each questions
		Question [] questions = {
				new Question(q1, "a"),
				new Question(q2, "c"),
				new Question(q3, "b"),
				new Question(q4, "c"),
				new Question(q5, "a"),
				new Question(q6, "a"),
				new Question(q7, "c"),
				new Question(q8, "b"),
				new Question(q9, "a"),
				new Question(q10, "b"),
				new Question(q11, "c"),
				new Question(q12, "a"),
				new Question(q13, "a"),
				new Question(q14, "c"),
				new Question(q15, "b"),
				new Question(q16, "b"),
				new Question(q17, "c"),
				new Question(q18, "a"),
				new Question(q19, "b"),
				new Question(q20, "c"),
		};
		takeTest(questions);
	}
	
	//this is the grader for the questions
	public static void takeTest(Question [] questions) {
		int score = 0;
		Scanner keyboardInput = new Scanner(System.in);
		
		for(int i = 0; i < questions.length; i++) {
			System.out.println(questions[i].prompt);
			String answer = keyboardInput.nextLine();
			if(answer.equals(questions[i].answer)) {
				score++;
			}
		}
		System.out.println("You got " + score + "/" + questions.length);
	}
}