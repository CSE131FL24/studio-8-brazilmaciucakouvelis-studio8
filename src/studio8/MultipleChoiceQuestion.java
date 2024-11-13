package studio8;

public class MultipleChoiceQuestion extends Question {

	private String[] choices;

	public MultipleChoiceQuestion(String prompt, String answer, int points, String[] choices) {
		// Call the super class constructor for common fields
		super(prompt, answer, points);
		// Set the unique field for multiple-choice options
		this.choices = choices;
	}

	public void displayPrompt() {
		// Display the prompt using the base class method
		super.displayPrompt();
		// Display each choice with a number prefix
		for (int i = 0; i < choices.length; i++) {
			System.out.println((i + 1) + ". " + choices[i]);
		}
	}

	public static void main(String[] args) {
		String[] choices = { "seven", "nine", "eight", "six" };
		Question multipleChoice = new MultipleChoiceQuestion("What studio is this?", "3", 1, choices);
		multipleChoice.displayPrompt();
		System.out.println(multipleChoice.checkAnswer("hi"));// wrong
		System.out.println(multipleChoice.checkAnswer("1"));// wrong
		System.out.println(multipleChoice.checkAnswer("3"));// right
	}

}
