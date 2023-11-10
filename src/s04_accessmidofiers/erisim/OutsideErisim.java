package s04_accessmidofiers.erisim;

import s04_accessmidofiers.Test;

public class OutsideErisim extends Test{
	public static void main(String[] args) {
		
		Test testObjesi = new Test();
		System.out.println("Erisebildigim degiskenler: "+testObjesi.herkese);
		
		OutsideErisim outsideErisim = new OutsideErisim();
		System.out.println("Erisebildigim degiskenler: "+outsideErisim.herkese
				+" "+outsideErisim.korumali);
	}

}
