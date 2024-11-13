package studio8;

public class SelectAllQuestion extends MultipleChoiceQuestion {

	public SelectAllQuestion(String prompt, String answer, String[] choices) {
		super(prompt, answer, choices.length, choices);
	}

	@Override
	public int checkAnswer(String givenAnswer) {
		int score = this.getPoints();
		score -= findMissingCorrectAnswers(givenAnswer);
		score -= findIncorrectGivenAnswers(givenAnswer);
		return Math.max(score, 0);
	}

	private int findMissingCorrectAnswers(String givenAnswer) {
		String answer = this.getAnswer();
		int incorrectValues = findMissingCharacters(givenAnswer, answer);
		return incorrectValues;
	}

	private int findIncorrectGivenAnswers(String givenAnswer) {
		String answer = this.getAnswer();
		int incorrectValues = findMissingCharacters(answer, givenAnswer);
		return incorrectValues;
	}

	private static int findMissingCharacters(String baseString, String toCheck) {
		int missingValues = 0;
		for (int i = 0; i < toCheck.length(); i++) {
			char characterToLocate = toCheck.charAt(i);
			if (baseString.indexOf(characterToLocate) == -1) { // not in baseString
				missingValues++;
			}
		}
		return missingValues;
	}

	public static void main(String[] args) {
		String[] choices = { "instance variables", "git", "methods", "eclipse" };
		Question selectAll = new SelectAllQuestion("Select all of the following that can be found within a class:",
				"13", choices);
		selectAll.displayPrompt();
		System.out.println(selectAll.checkAnswer("hi")); // no credit
		System.out.println(selectAll.checkAnswer("2")); // 1 point
		System.out.println(selectAll.checkAnswer("13")); // full credit
		System.out.println(selectAll.checkAnswer("31")); // full credit
		System.out.println(selectAll.checkAnswer("1")); // 3 points
		System.out.println(selectAll.checkAnswer("3")); // 3 points
		System.out.println(selectAll.checkAnswer("23")); // 2 points
		System.out.println(selectAll.checkAnswer("34")); // 2 points
		System.out.println(selectAll.checkAnswer("4")); // 1 point
		System.out.println(selectAll.checkAnswer("124")); // 1 point
		System.out.println(selectAll.checkAnswer("24")); // 0 points

	}
}
