package javaTester;

public class Topic_03_Text {

	public static void main(String[] args) {
		System.out.println("Khong co khoang trang o dau hoac cuoi");
		System.out.println("   Co khoang trang o dau");
		System.out.println("Co khoang trang o cuoi  ");
		System.out.println("   Co khoang trang o dau va cuoi  ");
		System.out.println("\nCo xuong dong o dau");
		System.out.println("Co xuong dong o cuoi\n");
		System.out.println("Co tab o cuoi\t");
		System.out.println("\tCo tab o dau");
		
		String firstName = "Michael";
		String lastName = "Jackson";
		
		//Nối chuỗi
		System.out.println(firstName + " " + lastName);
		
		//Nối chuỗi
		System.out.println(firstName.concat(" " + lastName));
		
		//Nối chuỗi
		System.out.println(firstName.concat(" ").concat(lastName));
	}

}
