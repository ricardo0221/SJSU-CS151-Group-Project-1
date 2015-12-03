package Scheduler;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DatePanel extends JPanel {

	private String startDateLabel = "";
	private String endDateLabel = "";
	private JButton prevButton;
	private JButton nextButton;
	private JLabel weekLabel;
	
	private Calendar currentDate;
	private Calendar startDate;
	private Calendar endDate;
	private int currentDayOfWeek;
	
	
	public DatePanel(Calendar currentDate) {
		this.currentDate = currentDate;
		currentDayOfWeek = currentDate.get(Calendar.DAY_OF_WEEK);
		startDate = null;
		endDate = null;
	
		
	}
	
	/*
	 * Returns the start date of the Week
	 */
	
	public Calendar getStartDay(){
		Calendar tempDay = currentDate;
		if(currentDayOfWeek != 1){
			Boolean isSunday = false;
			while(!isSunday){
				tempDay.add(Calendar.DATE, -1);
				if((tempDay.get(Calendar.DAY_OF_WEEK)) == 1){
					startDate = tempDay;
					isSunday = true;
				}
			}
		}
		
		else{
			startDate = tempDay;
		}
		
		return startDate;
	}
	
	/*
	 * Returns the start date of the week as a string
	 */
	public String getStartDateLabel(Calendar today) {
		startDateLabel = ((startDate.get(Calendar.MONTH) + 1) + "/" + startDate.get(Calendar.DATE) + "/" + startDate.get(Calendar.YEAR));
		
		return startDateLabel;
	}
	
	/*
	 * Returns the end date of the Week
	 */
	
	public Calendar getEndDate(){
		Calendar temp = startDate;
		
		temp.add(Calendar.DATE, 6);
		
		return temp;
	}
	
	/*
	 * Returns the start date of the week as a string
	 */
	public String getEndDateLabel(Calendar today) {
		endDateLabel = ((endDate.get(Calendar.MONTH) + 1) + "/" + endDate.get(Calendar.DATE) + "/" + endDate.get(Calendar.YEAR));
		return endDateLabel;
	}
	
}
