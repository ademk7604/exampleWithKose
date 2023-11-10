package s03_Abstract;

public class TestClass{
	public static void main(String[] args) {
		//Insan obje = new Insan(182, 95);
		Bina obje = new Bina();
		System.out.println(obje.boyMetre());
		System.out.println(obje.boySantimentre());
		System.out.println(obje.boyKilometre());
	}
}

interface Boy{
	 // Bu değişken varsayılan olarak public, static, ve final özelliklere sahiptir. Atama zorunludur
	int degisken =0; 
	static String tanim() {
		return "Bu interface impelemnt eden class icin"
				+"boy bilgileri donulmesini garanti eder.";
	}
	int boySantimentre();
	double boyMetre();
	default double boyKilometre() {
		return 0;
	}
	
	/*
	 * Interface de buunan default methodlar, 
	 * bu interfaceyi extends eden class lar tarfindan Overrid edilmek zorunda degildir. 
	 */
	
	/*
	 * Interface lerde eskiden sadece govdesi olmayan methodlar tanimlayabiliyorduk-> double boyMetre();
	 * java8 den itibaren default ve static kelimelerini kullanabilir hale geldik 
	 * ve bunlarin govdelerini kodlayabiliyoruz
	 * Bu methodlar abstract dir basina abstract koymamiza gerek yok
	 */
	/*
	 * Interface ile abstract FARKI?
	 * interface private methodlar yaratilabilir. Ama field lar PUBLIC dir.
	 * intenface tanimladigimiz degiskenlerin degeri PUBLIC, STATIC ve FINAL dir.
	 * abstract class da herhangi gondevi belirlenmis bir method bulunabilirken,
	 * interface de sadece static ve default methodlarin govdesi olabilmesi ve diger methodlar govdesizdir
	 * 
	 */
	//Java 9 dan itibaren interface de private method yaratabiliyoruz
	private void privateMethod() {
		System.out.println("Private method in interface");
	}
	private void defaultMethod() {
		System.out.println("Default method in interface");
		privateMethod(); // Bu metot, sadece aynı arayüz içindeki diğer metotlar tarafından çağrılabilir.
	}
	
}


abstract class Hayvan implements Boy{
	private int kilo;
	private int boy;
	
	public abstract boolean canliMi();
	/*
	 * abstract belirsiz muglak, ne yapacagi belli degil
	 * yani yarim birakilmis class a abstract class diyebiliyoruz
	 * Bir class abstract classi imp ettiginde mutlaka yarim birakilmis methodlari kodlamak zorunda
	 * Abstract class larda her turlu degiskene sahip olabilirsinz Private Public Protected 
	 * Abstract class, ben yarimim tam degilim biri beni extends ederse bunlari tamamlamak zorunda
	 * Abstract class imp ettigi interface i n methodalrini ve filed lerini overrid etmek zorunda degildir.
	 */
	
	
	public int getKilo() {
		return kilo;
	}

	public void setKilo(int kilo) {
		this.kilo = kilo;
	}

	public int getBoy() {
		return boy;
	}

	public void setBoy(int boy) {
		this.boy = boy;
	}
	
}	
class Insan extends Hayvan{

	public Insan(int boy, int kilo) {
		this.setBoy(boy);
		this.setKilo(kilo);
	}
	
	// hayvan class i overrid etmis olsaydi burda etmek zorunda degildik
	@Override
	public int boySantimentre() {
		
		return this.getBoy();
	}

	@Override
	public double boyMetre() {
		
		return this.getBoy()/100.0;
	}

	@Override
	public boolean canliMi() {
		return true;
	}
	
}

class Bina implements Boy{
	
	// bu method default oldugu icin Overrid etmez zorunda degiliz 
	public double boyKilometre() {
		return 2000;
	}

	@Override
	public int boySantimentre() {
		// TODO Auto-generated method stub
		return 2000;
	}

	@Override
	public double boyMetre() {
		// TODO Auto-generated method stub
		return 20;
	}
	
	/*
	 * NEDEN Interface ve Abstract diye farkli seyler yapmislar
	 * Interface ler daha genel herkeste olabilecek ve sahip olmasi zorunlu ozellikleri barindirir. Boy, kilo
	 * Interface daha Generic tir. ornegin Boy'u Bina. Bitki. Hayvan implements edebilir.
	 * Herhangi bir class istedigi kadar interfaceyi impl edebilir
	 * Bir class sadece bir class dan inhertance edebilir yani extends
	 */
}
	


