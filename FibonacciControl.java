package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

public class FibonacciControl implements ActionListener {
	private FibonacciModel model;//FibonacciModel field for model in MVC pattern 
	private FibonacciView view;//FibonacciView field for field in MVC pattern
	private CalculateFibonacci calculateFibonacci;//SwingWorker thread which calculate sum of fibonacci series
	private String textArea = "";
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if(e.getSource() == view.getGetSumButton()) {//if user clicked GetSumButton 
				int numberOfRow = Integer.parseInt(view.getInputData());//convert the string entered into the textField to an integer type and store in local variable
				if(numberOfRow <= 0) throw new Exception();//check if integer data is invalid data(below 0)
				else {
					calculateFibonacci = new CalculateFibonacci();//generate calculateFibonacci thread(SwingWorker)
					model.setNumberOfRow(numberOfRow);//set number-of-row field of model 
					
					calculateFibonacci.execute();//execute SwingWorker thread
				}
			}
			else if(e.getSource() == view.getCancelButton()) {//if user clicked cancel-button
				calculateFibonacci.cancel(true);//interrupt SwingWorker thread
				view.freezeCancelButton();//freeze cancel-button
			}
		}
		catch(Exception ex) {//catch invalid data exception
			view.setViewSumTextField("");//clear viewSum_textArea in view
			view.setShowSeriesTextArea("");//clear showSeries_textArea in view
			view.setProgressBar(0);//reset progressBar in view
			JOptionPane.showMessageDialog(null, "Enter valid input!", "Warning", JOptionPane.INFORMATION_MESSAGE);//show error message
		}
		finally {
			textArea = "";//clear textArea field
			model.setSumOfSeries(0);//reset sum of fibonacci series
		}
	}
	
	public FibonacciControl(FibonacciModel model, FibonacciView view) {
		this.model = model;
		this.view = view;
		view.setListener(this);//add ActionListener to two buttons
	}//constructor 
	
	public class CalculateFibonacci extends SwingWorker<Boolean, String> {
		@Override
		protected Boolean doInBackground() throws Exception {
			model.addFibonacciElement(0);//add first element of fibonacciSeries list in model 
			model.addFibonacciElement(1);//add second element of fibonacciSeries list in model
			
			view.activateCancelButton();//activate cancel-button
			
			for(int i = 0; i < model.getnumberOfRow(); i++) {
				Thread.sleep(100);
				
				if(i > 1) {
					int temp = model.getFibonacciElement(i-1) + model.getFibonacciElement(i-2);//for storing data temporally
					model.addFibonacciElement(temp);//add (i+1)th element of fibonacciSeries list in model
				}
				
				model.calculateSumOfSeries(model.getFibonacciElement(i));//add value of (i+1)th element to sum-of-series
				textArea += Integer.toString(model.getFibonacciElement(i)) + "\n";
				
				
				// * send data to process method *
				publish("Sum = "+Integer.toString(model.getSumOfSeries()));
				publish(textArea);
				publish(Integer.toString((100*(i+1))/model.getnumberOfRow()));//set the progress of task in SwingWorker thread
			}
			
			return true;
		}
		
		@Override
		protected void process(List<String> chunks) {
			String viewSum = chunks.get(chunks.size() - 3);//get string data from chunks list
			String showSeries = chunks.get(chunks.size() - 2);//get string data from chunks list
			Integer progress = Integer.parseInt(chunks.get(chunks.size() - 1));//get integer data from chunks list
			
			view.setViewSumTextField(viewSum);//set data of viewSum_textField field in view
			view.setShowSeriesTextArea(showSeries);//set data of showSeries_textArea in view
			view.setProgressBar(progress);//set data of progressBar in view
		}

		@Override
		protected void done() {
			try {
				FileOutputStream fileStream = new FileOutputStream("Fibonnaci_Series.txt", false);//generate FileOutputStream instance to connect file with PrintWriter(no appending)
				PrintWriter outputStream = new PrintWriter(fileStream);//generate PrintWriter object connected to "Fibonacci_Series.txt" file
				outputStream.println(model.getFibonacciSeries());//print fibonnacciSeries list of model
				outputStream.close();//close PrintWriter stream
				fileStream.close();//close FileOutputStream
			} catch (IOException e) {//catch IOException
				e.printStackTrace();
			}
			
			model.clearFibonacciSeries();//clear fibonacciSeries list in model
			view.freezeCancelButton();//freeze cancel-button in view
		}
	}
	
}

