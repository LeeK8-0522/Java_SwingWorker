package Main;

import java.awt.EventQueue;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {//run Runnable object
				try {
					FibonacciModel model = new FibonacciModel();//generate ApplicantFormView instance for view in MVC pattern.
					FibonacciView view = new FibonacciView();//generate ApplicantFormModel instance for model in MVC pattern.
					FibonacciControl control = new FibonacciControl(model, view);//generate ApplicantFormControl instance for control in MVC pattern and initialize it by referencing model and view 
					view.setVisible(true);//set view visible
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
