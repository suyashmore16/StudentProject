import javax.swing.*;
import BreezySwing.*;
public class StudentGui extends GBFrame{
	
	int type = 0;
	int ctr = 0;
	
	Person[] people = new Person[10];
	JButton enterButton = addButton("Enter", 1, 2, 1, 1);
	JLabel Name = addLabel("Person Name", 1, 1, 1, 1);
	JTextField nameInput = addTextField("Name", 1, 2, 1, 1);
	JLabel stuId = addLabel("Student ID:", 2, 1, 1, 1);
	JTextField studentId = addTextField("00000", 2, 2, 1, 1);
	JLabel underLabel = addLabel("Grade:", 3, 1, 1, 1);
	JTextField underField = addTextField("", 3, 2, 1, 1);
	JLabel gradLabel = addLabel("Major:", 4, 1, 1, 1);
	JTextField gradField = addTextField("", 4, 2, 1, 1);
	JButton printAll = addButton ("Print all" , 5,1,1,1);
	JTextField gradeLabel= addTextField ("Grade e.g. 9",  6,1,1,1);
	JButton outputGrade = addButton ("Output"  ,    	6,1,1,1);
	JTextField majorMatch= addTextField ("Major e.g. computer science",  6,2,1,1);
	JButton outputMajor = addButton ("Output"  ,    	6,2,1,1);

	JButton printStuButton= addButton ("Print Students" , 7,1,1,1);
	JButton printUnderButton= addButton ("Print Undergrads",7,2,1,1);
	JButton printGradButton	= addButton ("Print Grads"  ,  	7,3,1,1);
public void buttonClicked(JButton buttonObj){ //button click "sensor"
    	
    	if (buttonObj == enterButton) {
    		
    		if(ctr < 10) {
    			
    			//determines the type of object
        		if(!nameInput.getText().isBlank() && !studentId.getText().isBlank() && !underField.getText().isBlank() &&!gradField.getText().isBlank()) {
        			type = 5;
        		}
        		
        		
        		else if(!nameInput.getText().isBlank() && !studentId.getText().isBlank() && !gradField.getText().isBlank()) {
        			type = 4;
        			
        		}else if(!nameInput.getText().isBlank() && !studentId.getText().isBlank() && !underField.getText().isBlank()) {
        			type = 3;
        			
        		}else if(!nameInput.getText().isBlank() && !studentId.getText().isBlank()) {
        			if(underField.getText().isBlank() && gradField.getText().isBlank()) {
        				type = 2;
        			}else {
        				type = 5;
        			}
        			
        		}else if(!nameInput.getText().isBlank()) {
        			if(studentId.getText().isBlank() && underField.getText().isBlank() && gradField.getText().isBlank()) {
        				type = 1;
        			}else {
        				type = 5;
        			}
        			
        		}
        		
        		//creating people
        		switch (type) {
        		case 1:
        			people[ctr] = new Person(nameInput.getText());
        			
        			ctr++;
        			type = 0;
        			messageBox("Person entered");
        			break;
        			
        		case 2:
        			people[ctr] = new Student(nameInput.getText(), studentId.getText());
        			
        			ctr++;
        			type = 0;
        			messageBox("Student entered");
        			break;
        			
        		case 3:
        			people[ctr] = new Undergraduate(nameInput.getText(), studentId.getText(), underField.getText());
        			
        			ctr++;
        			type = 0;
        			messageBox("Undergraduate entered");
        			break;
        			
        		case 4:
        			people[ctr] = new Graduate(nameInput.getText(), studentId.getText(), gradField.getText());
        			
        			ctr++;
        			type = 0;
        			messageBox("Graduate entered");
        			break;
        			
        		case 5: //error check
        			messageBox("invalid input");
        			type = 0;
        			break;
        		}
        		
        		
        		//resetting fields
        		nameInput.setText("");
        		studentId.setText("");
        		underField.setText("");
        		gradField.setText("");
        		
    		}else {
    			//resetting fields
        		nameInput.setText("");
        		studentId.setText("");
        		underField.setText("");
        		gradField.setText("");
    			messageBox("Person limit reached");
    		}
    		
    		
    		
    		}
    	
    	if (buttonObj == printAll) {
    		
    		String output = "";
    		
    		
    		for(int i = 0; i < ctr; i++) {
    		
    			output += people[i].print();
    			output += '\n';
    		}
    		
    		messageBox(output ,500,400);
    		output = "";
    	}
    	
    	if (buttonObj == outputGrade) {
    		String input = gradeLabel.getText();
    		String output = "People who are grade level " + input + ":" + '\n';
    		
    		//loop to check type of person
    		for(int i = 0; i < ctr; i++) {
    			if(people[i] instanceof Undergraduate) {
    				if(people[i].gradeEquals(input)) {
    					output += people[i].getName() + '\n';
    				}
    			}
    		}
    		
    		messageBox(output ,300,200);
    		gradeLabel.setText("input grade");
    	}
    	
    	if (buttonObj == outputMajor) {
    		String input = majorMatch.getText();
    		String output = "People who are of major " + input + ":" + '\n';
    		
    		for(int i = 0; i < ctr; i++) {
    			if(people[i] instanceof Graduate) {
    				if(people[i].majorEquals(input)) {
    					output += people[i].getName() + '\n';
    				}
    			}
    		}
    		
    		messageBox(output ,300,200);
    		majorMatch.setText("input major");
    		
    	}
    	
    	if (buttonObj == printStuButton) {
    		String output = "";
    		
    		for(int i = 0; i < ctr; i++) {
    			if(people[i] instanceof Student) {
    				output += people[i].print() + '\n';
    			}
    		}
    		
    		messageBox(output ,500,400);
    	}
    	
    	if (buttonObj == printUnderButton) {
    		String output = "";
    		
    		for(int i = 0; i < ctr; i++) {
    			if(people[i] instanceof Undergraduate) {
    				output += people[i].print() + '\n';
    			}
    		}
    		
    		messageBox(output ,500,400);
    	}
    	
    	if (buttonObj == printGradButton) {
    		
    		String output = "";
    		
    		for(int i = 0; i < ctr; i++) {
    			if(people[i] instanceof Graduate) {
    				output += people[i].print() + '\n';
    			}
    		}
    		
    		messageBox(output ,500,400);
    	}
    	
    	
	    }

	
	public static void main(String[] args) {
		JFrame frm = new StudentGui();
		frm.setTitle ("Student Database");
	    frm.setSize (500, 500);
	    frm.setVisible (true);
	    
	    
	    
	}       
	  	
}
