package s04_accessmidofiers;

public class Test {
	
	public String herkese= "public degisken";
	protected String korumali = "protected degisken";
	String duz = "default degisken";
	private String gizli = "private degisken";

	/*
	 * Public    -> heryerden ulasilir
	 * protected -> class, package, subClass (ayni paket), SubClass (farkli paket) den ulasilir
	 * Default   -> class, Package, SubClass (ayni paket)
	 * Private   -> Class
	 */

	public static void main(String[] args) {
		Test testObjesi = new Test();
		System.out.println("Erisebildigim degiskenler: "+
		testObjesi.duz+" "+testObjesi.herkese+" "+testObjesi.korumali+" "+testObjesi.gizli);
	}
}
