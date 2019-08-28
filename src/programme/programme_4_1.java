package programme;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class programme_4_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate date=LocalDate.now();
		
		int today=date.getDayOfMonth();
		
		date=date.minusDays(today-1);//设置date为本月第一天
		date=date.minusMonths(1);
		int month=date.getMonthValue();
		DayOfWeek weekday=date.getDayOfWeek();
		int value=weekday.getValue();//DayOfWeek是enum，通过weekday.getValue()获得它的值
		
		System.out.println("Mon Tue Wed Thu Fri Sat Sun");
		for (int i = 1; i < value; i++) {
			System.out.print("    ");
		}
		while(date.getMonthValue()==month){
			System.out.printf("%3d",date.getDayOfMonth());
			if(date.getDayOfMonth()==today)
				System.out.print("*");
			else
				System.out.print(" ");
			if(date.getDayOfWeek().getValue()==7)
				System.out.println();
			date=date.plusDays(1);
		}
	}

}
