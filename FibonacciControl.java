package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

public class FibonacciControl implements ActionListener {
	private FibonacciModel model;
	private FibonacciView view;
	private CalculateFibonacci calculateFibonacci;
	private String textArea = "";
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if(e.getSource() == view.getGetSumButton()) {
				int numberOfRow = Integer.parseInt(view.getInputData());
				if(numberOfRow <= 0) throw new Exception();
				else {
					calculateFibonacci = new CalculateFibonacci();
					model.setNumberOfRow(numberOfRow);
					
					calculateFibonacci.execute();
				}
			}
			else if(e.getSource() == view.getCancelButton()) {
				calculateFibonacci.cancel(true);
				view.freezeCancelButton();
			}
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Enter valid input!", "Warning", JOptionPane.INFORMATION_MESSAGE);
		}
		finally {
			textArea = "";
		}
	}
	
	public FibonacciControl(FibonacciModel model, FibonacciView view) {
		this.model = model;
		this.view = view;
		view.setListener(this);
	}
	
	public class CalculateFibonacci extends SwingWorker<Boolean, String> {
		@Override
		protected Boolean doInBackground() throws Exception {
			model.addFibonacciElement(0);
			model.addFibonacciElement(1);
			
			view.activateCancelButton();
			
			for(int i = 0; i < model.getnumberOfRow(); i++) {
				Thread.sleep(100);
				
				if(i > 1) {
					int temp = model.getFibonacciElement(i-1) + model.getFibonacciElement(i-2);//for storing data temporally
					model.addFibonacciElement(temp);
				}
				
				model.calculateSumOfSeries(model.getFibonacciElement(i));
				textArea += Integer.toString(model.getFibonacciElement(i)) + "\n";
				
				publish("Sum = "+Integer.toString(model.getSumOfSeries()));
				publish(textArea);
				publish(Integer.toString((100*i)/model.getnumberOfRow()));
			}
			
			return true;
		}
		
		@Override
		protected void process(List<String> chunks) {
			String viewSum = chunks.get(chunks.size() - 3);
			String showSeries = chunks.get(chunks.size() - 2);
			Integer progress = Integer.parseInt(chunks.get(chunks.size() - 1));
			
			view.setViewSumTextField(viewSum);
			view.setShowSeriesTextArea(showSeries);
			view.setProgressBar(progress);
		}

		@Override
		protected void done() {
			model.clearFibonacciSeries();
			view.freezeCancelButton();
		}
	}
	
}

