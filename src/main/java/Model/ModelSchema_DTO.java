package Model;

public class ModelSchema_DTO {
	private int ques_id;
	private String question_title;
	private String question;
	private String opt1;
	private String opt2; 
	private String opt3; 
	private String opt4;
	private int anskey ;
	private String diff_level;
	public int getQues_id() {
		return ques_id;
	}
	public void setQues_id(int ques_id) {
		this.ques_id = ques_id;
	}
	public String getQuestion_title() {
		return question_title;
	}
	public void setQuestion_title(String question_title) {
		this.question_title = question_title;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getOpt1() {
		return opt1;
	}
	public void setOpt1(String opt1) {
		this.opt1 = opt1;
	}
	public String getOpt2() {
		return opt2;
	}
	public void setOpt2(String opt2) {
		this.opt2 = opt2;
	}
	public String getOpt3() {
		return opt3;
	}
	public void setOpt3(String opt3) {
		this.opt3 = opt3;
	}
	public String getOpt4() {
		return opt4;
	}
	public void setOpt4(String opt4) {
		this.opt4 = opt4;
	}
	public int getAnskey() {
		return anskey;
	}
	public void setAnskey(int anskey) {
		this.anskey = anskey;
	}
	public String getDiff_level() {
		return diff_level;
	}
	public void setDiff_level(String diff_level) {
		this.diff_level = diff_level;
	}
	
}
